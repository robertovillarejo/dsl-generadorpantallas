package mx.gob.conacyt.generadorpantallas.legacy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;

@Repository
public interface WidgetRepository extends JpaRepository<Widget, Long> {
    
    public Optional<Widget> findOneByCveWidget(String cveWidget);

}
