package mx.gob.conacyt.generadorpantallas.legacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.gob.conacyt.generadorpantallas.legacy.domain.WidgetPantalla;

@Repository
public interface WidgetPantallaRepository extends JpaRepository<WidgetPantalla, Long> {

//    @Query(value = "select wp from WidgetPantalla wp where wp.pantalla.idPantalla = :pantallaId and wp.widget.idWidget = :widgetId")
    @Query(value = "SELECT * FROM widget_pantalla WHERE id_pantalla = :idPantalla AND id_widget = :idWidget AND rownum = 1", nativeQuery = true)
    public WidgetPantalla findFirstByPantallaAndWidget(@Param("idPantalla") Long idPantalla,
            @Param("idWidget") Long idwWidget);

}
