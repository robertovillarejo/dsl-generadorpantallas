package mx.gob.conacyt.generadorpantallas.visitor;

import mx.gob.conacyt.generadorpantallas.factories.ModernFactory;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
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
	public void visit(Pantalla element) {
		mPantalla = ModernFactory.toModern(element);
		super.visit(element);
	}

	@Override
	public void visit(Widget element) {
		Contenedor c = ModernFactory.toModern(element);
		if (element.getPadre() == null) {
			mPantalla.getContenedores().add(c);
		} else {
			mContenedor.getHijos().add(c);
			c.setPadre(mContenedor);
		}
		mContenedor = c;
		for (Widget hijo : element.getHijos()) {
			visit(hijo);
		}
		super.visit(element);
	}

	@Override
	public void visit(CampoWidget element) {
		Campo c = ModernFactory.toModern(element);
		mContenedor.getCampos().add(c);
		super.visit(element);
	}

}
