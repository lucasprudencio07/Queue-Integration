package queueTemplateAPI.integration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter @Setter @ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "CEP_ENTITY")
public class CepEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "LOCALIDADE")
    private String localidade;

    @Column(name = "UF")
    private String uf;

    @Column(name = "UNIDADE")
    private String unidade;

    @Column(name = "IBGE")
    private String ibge;

    @Column(name = "GIA")
    private String gia;

//    @Override
//    public String toString() {
//        return "\nCEP { " +
//                "\n    cep : " + cep +
//                "\n    logradouro : " + logradouro +
//                "\n    complemento : " + complemento +
//                "\n    bairro : " + bairro +
//                "\n    uf : " + uf +
//                "\n    unidade : " + ibge +
//                "\n    gia : " + gia +
//                "\n}";
//    }
}
