package mx.gob.conacyt.generadorpantallas.legacy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CatTipoWidget;

@Repository
public interface TipoWidgetRepository extends JpaRepository<CatTipoWidget, Long> {

    public Optional<CatTipoWidget> findOneByCveTipoWidget(String cveTipoWidget);

}
