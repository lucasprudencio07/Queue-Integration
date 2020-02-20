package queueTemplateAPI.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import queueTemplateAPI.controller.converter.ControllerConverter;
import queueTemplateAPI.controller.data.CepRequest;
import queueTemplateAPI.controller.data.CepResponse;
import queueTemplateAPI.domain.data.CepDTO;
import queueTemplateAPI.domain.CepDomain;

import java.util.List;

@RestController
@RequestMapping("/cep")
@RequiredArgsConstructor
public class CepController {

    private final ControllerConverter controllerConverter;
    private final CepDomain domain;


    /** Persist the object **/
    @PostMapping("/persist/{cep}")
    public String getCepFromAPI(@PathVariable("cep") String cep) throws Exception {

        CepDTO cepDomain = domain.getCepFromDomainToEntity(cep);

        CepResponse cepResponse = controllerConverter.domainToResponse(cepDomain);

        domain.cepToBePersisted(cepDomain);

        return " O CEP " + cepResponse.getCep() + " foi cadastrado com sucesso no banco de dados.";
    }


    /** Get one persisted object  **/
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "get one CEP",
            content = @Content(schema = @Schema(implementation = CepResponse.class)))
    })
    @GetMapping("/{id}")
    public CepResponse getOneCep(@PathVariable("id") Long id) {

        return controllerConverter.domainToResponse(domain.getCepByIdFromResponseToDomain(id));
    }


    /** Get all persisted objects **/
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "get All CEPs",
                  content = @Content(schema = @Schema(implementation = CepResponse.class)))
    })
    @GetMapping
    public List<CepResponse> getAllCep() {

        List<CepDTO> cepDomainList = domain.getAllCepFromResponseToDomain();

        return controllerConverter.DomainListToResponseList(cepDomainList);
    }


    /** Delete one object by id **/
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCepById(@PathVariable("id") Long id) {

        domain.deleteCep(id);

        return ResponseEntity.noContent().build();
    }


    /** Update one object by id **/
    @PutMapping("/{id}")
    public CepResponse updateCepById(@PathVariable("id") Long id, @RequestBody CepRequest cepRequest) {

        CepDTO cepDTO = controllerConverter.convertResquestToDomain(cepRequest);

        CepDTO cepDTOUpdated = domain.updateCepFromResponseToDomain(id, cepDTO);

        return controllerConverter.domainToResponse(cepDTOUpdated);
    }

}