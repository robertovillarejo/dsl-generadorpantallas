package mx.gob.conacyt.generadorpantallas.legacy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;

@Repository
public interface PantallaRepository extends JpaRepository<Pantalla, Long> {

	public Optional<Pantalla> findOneByCvePantalla(String cvePantalla);

}
