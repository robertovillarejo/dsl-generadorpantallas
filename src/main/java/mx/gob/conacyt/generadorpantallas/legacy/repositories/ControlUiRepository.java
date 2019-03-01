package mx.gob.conacyt.generadorpantallas.legacy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CatControlUi;

@Repository
public interface ControlUiRepository extends JpaRepository<CatControlUi, Long> {

	Optional<CatControlUi> findOneByCveControlUi(String cveControlUi);

}
