package queueTemplateAPI.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import queueTemplateAPI.integration.model.Cep;

@Log
@Component
@RequiredArgsConstructor
public class Producer  {

    private final JmsMessagingTemplate jmsMessagingTemplate;

    public void run(Cep cep, String... args) throws Exception {

        ObjectMapper om = new ObjectMapper();
        String JsonCep = om.writeValueAsString(cep);

        this.jmsMessagingTemplate.convertAndSend("cep.queue", JsonCep);

//        System.out.println("CEP " + cep.getCep() +  " was sent successfully");

        log.info("CEP " + cep.getCep() +  " was sent successfully");
    }

}
