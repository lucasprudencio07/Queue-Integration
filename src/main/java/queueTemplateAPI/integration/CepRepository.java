package queueTemplateAPI.integration;

import org.springframework.data.jpa.repository.JpaRepository;
import queueTemplateAPI.integration.model.CepEntity;

public interface CepRepository extends JpaRepository<CepEntity, Long> {
}
