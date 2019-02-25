package mx.gob.conacyt.generadorpantallas.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Componente;
import mx.gob.conacyt.generadorpantallas.legacy.domain.FlujoPantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Menu;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.SecuenciaFlujoPantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.WidgetPantalla;

public abstract class AbstractLegacyModelVisitor implements LegacyVisitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractLegacyModelVisitor.class);

    @Override
    public void visit(Componente element) {
        LOGGER.debug("Visiting element componente");
        for (Menu menu : element.getMenus()) {
            visit(menu);
        }
    }

    @Override
    public void visit(Menu element) {
        LOGGER.debug("Visiting element menu");
        for (FlujoPantalla fp : element.getFlujoPantallas()) {
            visit(fp);
        }
    }

    @Override
    public void visit(FlujoPantalla element) {
        LOGGER.debug("Visiting element FlujoPantalla");
        for (SecuenciaFlujoPantalla sfp : element.getSecuenciaFlujoPantallas()) {
            visit(sfp);
        }
    }

    @Override
    public void visit(SecuenciaFlujoPantalla element) {
        LOGGER.debug("Visiting element SecuenciaFlujoPantalla");
    }

    @Override
    public void visit(WidgetPantalla element) {
        LOGGER.debug("Visiting element WidgetPantalla");
        if (element.getWidget() != null) {
            visit(element.getWidget());
        }
    }

    @Override
    public void visit(Pantalla element) {
        LOGGER.debug("Visiting element Pantalla");
        for (WidgetPantalla wp : element.getWidgetPantallas()) {
            visit(wp);
        }
    }

    @Override
    public void visit(Widget element) {
        LOGGER.debug("Visiting element Widget");
        for (CampoWidget c : element.getCampoWidgets()) {
            visit(c);
        }
    }

    @Override
    public void visit(CampoWidget element) {
        LOGGER.debug("Visiting element CampoWidget");
    }

}
