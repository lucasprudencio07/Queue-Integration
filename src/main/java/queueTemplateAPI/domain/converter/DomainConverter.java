package queueTemplateAPI.domain.converter;

import org.springframework.stereotype.Component;
import queueTemplateAPI.domain.data.CepDTO;
import queueTemplateAPI.integration.model.Cep;
import queueTemplateAPI.integration.model.CepEntity;

import java.util.ArrayList;
import java.util.List;

@Component
public class DomainConverter {
    public CepDTO PersistEntityToDomain(Cep cepEntity) {
        return CepDTO.builder()
                        .cep(cepEntity.getCep())
                        .logradouro(cepEntity.getLogradouro())
                        .complemento(cepEntity.getComplemento())
                        .bairro(cepEntity.getBairro())
                        .localidade(cepEntity.getLocalidade())
                        .uf(cepEntity.getUf())
                        .unidade(cepEntity.getUnidade())
                        .ibge(cepEntity.getIbge())
                        .gia(cepEntity.getGia())
                        .build();

    }

    public CepEntity convertFromDomainToEntity(CepDTO cepDTO) {
        return CepEntity.builder()
                        .cep(cepDTO.getCep())
                        .logradouro(cepDTO.getLogradouro())
                        .complemento(cepDTO.getComplemento())
                        .bairro(cepDTO.getBairro())
                        .localidade(cepDTO.getLocalidade())
                        .uf(cepDTO.getUf())
                        .unidade(cepDTO.getUnidade())
                        .ibge(cepDTO.getIbge())
                        .gia(cepDTO.getGia())
                        .build();
    }

    public Cep convertFromDomainToModel(CepDTO cepDTO) {
        return Cep.builder()
                .cep(cepDTO.getCep())
                .logradouro(cepDTO.getLogradouro())
                .complemento(cepDTO.getComplemento())
                .bairro(cepDTO.getBairro())
                .localidade(cepDTO.getLocalidade())
                .uf(cepDTO.getUf())
                .unidade(cepDTO.getUnidade())
                .ibge(cepDTO.getIbge())
                .gia(cepDTO.getGia())
                .build();
    }

    public CepEntity updateFromDomainToEntity(Long id, CepDTO cepDTO) {
        return CepEntity.builder()
                        .id(id)
                        .cep(cepDTO.getCep())
                        .logradouro(cepDTO.getLogradouro())
                        .complemento(cepDTO.getComplemento())
                        .bairro(cepDTO.getBairro())
                        .localidade(cepDTO.getLocalidade())
                        .uf(cepDTO.getUf())
                        .unidade(cepDTO.getUnidade())
                        .ibge(cepDTO.getIbge())
                        .gia(cepDTO.getGia())
                        .build();
    }

    public CepDTO EntityToDomain(CepEntity cepEntity) {
        return CepDTO.builder()
                        .id(cepEntity.getId())
                        .cep(cepEntity.getCep())
                        .logradouro(cepEntity.getLogradouro())
                        .complemento(cepEntity.getComplemento())
                        .bairro(cepEntity.getBairro())
                        .localidade(cepEntity.getLocalidade())
                        .uf(cepEntity.getUf())
                        .unidade(cepEntity.getUnidade())
                        .ibge(cepEntity.getIbge())
                        .gia(cepEntity.getGia())
                        .build();

    }

    public List<CepDTO> EntityListToDomainList(List<CepEntity> cepEntityList) {
        List<CepDTO> cepDTOList = new ArrayList<>();
        for (CepEntity entity : cepEntityList) {
            cepDTOList.add(CepDTO.builder()
                                .id(entity.getId())
                                .cep(entity.getCep())
                                .logradouro(entity.getLogradouro())
                                .complemento(entity.getComplemento())
                                .bairro(entity.getBairro())
                                .localidade(entity.getLocalidade())
                                .uf(entity.getUf())
                                .unidade(entity.getUnidade())
                                .ibge(entity.getIbge())
                                .gia(entity.getGia())
                                .build()
            );
        }
        return cepDTOList;
    }
}
