package mx.gob.conacyt.generadorpantallas.legacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.conacyt.generadorpantallas.legacy.domain.Componente;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Long> {

    public Componente findOneByCveComponente(String cveComponente);

}
