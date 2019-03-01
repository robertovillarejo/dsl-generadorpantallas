package mx.gob.conacyt.generadorpantallas.visitor;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Componente;
import mx.gob.conacyt.generadorpantallas.legacy.domain.FlujoPantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Menu;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.SecuenciaFlujoPantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.WidgetPantalla;

public interface LegacyVisitor {

    public void visit(Componente element);

    public void visit(Menu element);

    public void visit(FlujoPantalla element);

    public void visit(SecuenciaFlujoPantalla element);

    public void visit(WidgetPantalla element);

    public void visit(Pantalla element);

    public void visit(Widget element);

    public void visit(CampoWidget element);

}
