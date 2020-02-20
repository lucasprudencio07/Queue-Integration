package queueTemplateAPI.controller.JMS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import queueTemplateAPI.integration.model.Cep;

@Component
public class Listener {

    @JmsListener(destination = "cep.queue")
    public void receiveMessage(String cep) throws JsonProcessingException {

        try {
            Thread.sleep(30);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        ObjectMapper om = new ObjectMapper();
        Cep cepObject = om.readValue(cep, Cep.class);

        System.out.println("CEP " + cepObject.getCep() + " was received successfully");
    }
}
