package mx.gob.conacyt.generadorpantallas.legacy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.conacyt.generadorpantallas.legacy.domain.Formato;

@Repository
public interface FormatoRepository extends JpaRepository<Formato, Long> {

    public Optional<Formato> findOneByFormato(String formato);

}
