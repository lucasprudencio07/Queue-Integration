package queueTemplateAPI.integration;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import queueTemplateAPI.integration.model.Cep;

@Repository
public class ApiCepConsumption {

    public Cep apiCepConsumption(String cep) {
        RestTemplate restTemplate =  new RestTemplate();
        return restTemplate.getForObject("https://viacep.com.br/ws/{cep}/json", Cep.class, cep);
    }
}
