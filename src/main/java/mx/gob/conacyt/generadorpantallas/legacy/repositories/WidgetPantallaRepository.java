package mx.gob.conacyt.generadorpantallas.legacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.conacyt.generadorpantallas.legacy.domain.WidgetPantalla;

@Repository
public interface WidgetPantallaRepository extends JpaRepository<WidgetPantalla, Long> {

}
