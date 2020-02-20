package queueTemplateAPI.controller.converter;

import org.springframework.stereotype.Component;
import queueTemplateAPI.controller.data.CepRequest;
import queueTemplateAPI.controller.data.CepResponse;
import queueTemplateAPI.domain.data.CepDTO;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Component
public class ControllerConverter {

    public CepResponse domainToResponse(CepDTO cepDTO) {

        if (isNull(cepDTO)) {
            return null;
        }

        return CepResponse.builder()
                          .id(cepDTO.getId())
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


    public CepDTO convertResponseToDomain (CepResponse cepResponse) {
        return CepDTO.builder()
                        .cep(cepResponse.getCep())
                        .logradouro(cepResponse.getLogradouro())
                        .complemento(cepResponse.getComplemento())
                        .bairro(cepResponse.getBairro())
                        .localidade(cepResponse.getLocalidade())
                        .uf(cepResponse.getUf())
                        .unidade(cepResponse.getUnidade())
                        .ibge(cepResponse.getIbge())
                        .gia(cepResponse.getGia())
                        .build();

    }


    public CepDTO convertResquestToDomain (CepRequest cepRequest) {
        return CepDTO.builder()
                        .cep(cepRequest.getCep())
                        .logradouro(cepRequest.getLogradouro())
                        .complemento(cepRequest.getComplemento())
                        .bairro(cepRequest.getBairro())
                        .localidade(cepRequest.getLocalidade())
                        .uf(cepRequest.getUf())
                        .unidade(cepRequest.getUnidade())
                        .ibge(cepRequest.getIbge())
                        .gia(cepRequest.getGia())
                        .build();

    }


    public List<CepResponse> DomainListToResponseList(List<CepDTO> cepDTOList) {
        List<CepResponse> cepResponseList = new ArrayList<>();
        for (CepDTO cepDTO : cepDTOList) {
            cepResponseList.add(CepResponse.builder()
                                            .id(cepDTO.getId())
                                            .cep(cepDTO.getCep())
                                            .logradouro(cepDTO.getLogradouro())
                                            .complemento(cepDTO.getComplemento())
                                            .bairro(cepDTO.getBairro())
                                            .localidade(cepDTO.getLocalidade())
                                            .uf(cepDTO.getUf())
                                            .unidade(cepDTO.getUnidade())
                                            .ibge(cepDTO.getIbge())
                                            .gia(cepDTO.getGia())
                                            .build()
            );
        }
        return cepResponseList;
    }
}
