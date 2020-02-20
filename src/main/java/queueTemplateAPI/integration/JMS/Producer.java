package queueTemplateAPI.controller.JMS;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import queueTemplateAPI.integration.model.Cep;

@Component
public class Producer  {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private String cep = "mensagem";


    public void run(Cep cep,String... args) throws Exception {
        ObjectMapper om = new ObjectMapper();
            String JsonCep = om.writeValueAsString(cep);
//            System.out.println(JsonCep);

        this.jmsMessagingTemplate.convertAndSend("cep.queue", JsonCep);
        System.out.println("CEP " + cep.getCep() +  " was sent successfully");

    }
}
