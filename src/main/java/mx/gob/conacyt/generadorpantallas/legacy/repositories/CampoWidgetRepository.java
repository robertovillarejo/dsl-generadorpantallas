package mx.gob.conacyt.generadorpantallas.legacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;

@Repository
public interface CampoWidgetRepository extends JpaRepository<CampoWidget, Long> {

}
