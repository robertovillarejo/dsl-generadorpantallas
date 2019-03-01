package mx.gob.conacyt.generadorpantallas.utils;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.WidgetPantalla;

public class Utils {

	private Utils() {
	}

	private static void loadWidget(Widget w) {
		for (Widget hijo : w.getHijos()) {
			loadWidget(hijo);
		}
		for (CampoWidget cw : w.getCampoWidgets()) {
			cw.getFormato();
			cw.getCatControlUi();
			cw.getWidget();
		}
	}

	public static void loadPantallaEagerly(Pantalla p) {
		for (WidgetPantalla wp : p.getWidgetPantallas()) {
			Widget w = wp.getWidget();
			loadWidget(w);
		}
	}

}
