package mx.gob.conacyt.generadorpantallas.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Componente;
import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;
import mx.gob.conacyt.generadorpantallas.modern.domain.Menu;
import mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla;

public abstract class AbstractModernVisitor implements ModernVisitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractModernVisitor.class);

    @Override
    public void visit(Componente element) {
        LOGGER.debug("Visiting element Componente");
        for (Menu m : element.getMenus()) {
            visit(m);
        }
    }

    @Override
    public void visit(Menu element) {
        LOGGER.debug("Visiting element Menu");
    }

    @Override
    public void visit(Pantalla element) {
        LOGGER.debug("Visiting element Pantalla");
        for (Contenedor c : element.getContenedores()) {
            visit(c);
        }
    }

    @Override
    public void visit(Contenedor element) {
        LOGGER.debug("Visiting element Contenedor");
        for (Campo c : element.getCampos()) {
            visit(c);
        }
    }

    @Override
    public void visit(Campo element) {
        LOGGER.debug("Visiting element Campo");
    }

}
