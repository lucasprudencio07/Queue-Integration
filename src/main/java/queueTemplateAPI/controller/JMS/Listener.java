package queueTemplateAPI.controller.JMS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import queueTemplateAPI.controller.converter.ControllerConverter;
import queueTemplateAPI.controller.data.CepResponse;
import queueTemplateAPI.domain.CepDomain;
import queueTemplateAPI.domain.data.CepDTO;

@Log
@Component
@RequiredArgsConstructor
public class Listener {

    private final ControllerConverter controllerConverter;
    private final CepDomain domain;

    @JmsListener(destination = "cep.queue")
    public void receiveMessage(String cep) throws JsonProcessingException, InterruptedException {

        Thread.sleep(30);

        ObjectMapper om = new ObjectMapper();

        CepResponse cepObject = om.readValue(cep, CepResponse.class);

//        System.out.println("CEP " + cepObject.getCep() + " was received successfully");

        log.info("CEP " + cepObject.getCep() + " was received successfully");

        CepDTO cepDomain = controllerConverter.convertResponseToDomain(cepObject);
        domain.sendCepFromListenerToDomain(cepDomain);
    }

}
