package mx.gob.conacyt.generadorpantallas.visitor;

import mx.gob.conacyt.generadorpantallas.factories.ModernFactory;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Componente;
import mx.gob.conacyt.generadorpantallas.legacy.domain.FlujoPantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Menu;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.SecuenciaFlujoPantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;

public class LegacyModelVisitor extends AbstractLegacyModelVisitor {

    private mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla mPantalla;
    private Contenedor mContenedor;
    
    public mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla getPantalla() {
        return mPantalla;
    }

    @Override
    public void visit(Componente element) {
//        mx.gob.conacyt.generadorpantallas.modern.domain.Componente c = ModernFactory.toModern(element);
        super.visit(element);
    }

    @Override
    public void visit(Menu element) {
        super.visit(element);
    }

    @Override
    public void visit(FlujoPantalla element) {
        super.visit(element);
    }

    @Override
    public void visit(SecuenciaFlujoPantalla element) {
        super.visit(element);
    }

    @Override
    public void visit(Pantalla element) {
        mPantalla = ModernFactory.toModern(element);
        super.visit(element);
    }

    @Override
    public void visit(Widget element) {
        mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor c = ModernFactory.toModern(element);
        mPantalla.getContenedores().add(c);
        mContenedor = c;
        super.visit(element);
    }

    @Override
    public void visit(CampoWidget element) {
        Campo c = ModernFactory.toModern(element);
        mContenedor.getCampos().add(c);
        super.visit(element);
    }

}
