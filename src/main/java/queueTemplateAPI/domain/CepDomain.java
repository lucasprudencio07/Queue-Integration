package queueTemplateAPI.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import queueTemplateAPI.integration.Producer;
import queueTemplateAPI.domain.converter.DomainConverter;
import queueTemplateAPI.domain.data.CepDTO;
import queueTemplateAPI.integration.ApiCepConsumption;
import queueTemplateAPI.integration.CepRepository;
import queueTemplateAPI.integration.model.Cep;
import queueTemplateAPI.integration.model.CepEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CepDomain {

    private final DomainConverter domainConverter;
    private final ApiCepConsumption apiCepConsumption;
    private final CepRepository cepRepository;
    private final Producer producer;



    /** Persist the Object **/
    public void cepToBePersisted(CepDTO cepDomain) throws Exception {

        Cep cepEntity = domainConverter.convertFromDomainToModel(cepDomain);

        producer.run(cepEntity);
    }


    /** Consuming the API and return a CEP **/
    public CepDTO getCepFromDomainToEntity(String cep) {

        Cep cepEntity = apiCepConsumption.apiCepConsumption(cep);

        return domainConverter.PersistEntityToDomain(cepEntity);
    }


    /** Saving the Object **/
    public void sendCepFromListenerToDomain(CepDTO cepDTO) {

        CepEntity cepEntity = domainConverter.convertFromDomainToEntity(cepDTO);

        cepRepository.save(cepEntity);
    }


    /** Get One Object **/
    public CepDTO getCepByIdFromResponseToDomain(Long id) {

        CepEntity cepEntity = cepRepository.getOne(id);

        return domainConverter.EntityToDomain(cepEntity);
    }


    /** Get All Objects **/
    public List<CepDTO> getAllCepFromResponseToDomain() {

        List<CepEntity> cepEntityList = cepRepository.findAll();

        return domainConverter.EntityListToDomainList(cepEntityList);
    }


    /** Delete an Object by ID **/
    public void deleteCep(Long id) {

        cepRepository.deleteById(id);
    }


    /** Update an Object by ID **/
    public CepDTO updateCepFromResponseToDomain(Long id, CepDTO cepDTO) {

        CepEntity cepEntity = domainConverter.updateFromDomainToEntity(id, cepDTO);

        CepEntity entityUpdated = cepRepository.save(cepEntity);

        return domainConverter.EntityToDomain(entityUpdated);
    }

}
