package mx.gob.conacyt.generadorpantallas.visitor;

import static mx.gob.conacyt.generadorpantallas.factories.LegacyFactory.getCampoWidget;
import static mx.gob.conacyt.generadorpantallas.utils.Utils.loadPantallaEagerly;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.util.StringUtils;

import mx.gob.conacyt.generadorpantallas.factories.LegacyFactory;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.WidgetPantalla;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ControlUiRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.FormatoRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.PantallaRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.TipoWidgetRepository;
import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;
import mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla;

public class ModernModelVisitor extends AbstractModernVisitor {

	private mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla lPantalla;

	private Widget lWidget;

	private PantallaRepository pantallaRepo;

	private TipoWidgetRepository tipoWidgetRepo;

	private FormatoRepository formatoRepo;

	private ControlUiRepository controlUiRepo;

	private EntityManager em;

	public ModernModelVisitor(PantallaRepository pantallaRepo, TipoWidgetRepository tipoWidgetRepo,
			FormatoRepository formatoRepo, ControlUiRepository controlUiRepo, EntityManager em) {
		this.pantallaRepo = pantallaRepo;
		this.tipoWidgetRepo = tipoWidgetRepo;
		this.formatoRepo = formatoRepo;
		this.controlUiRepo = controlUiRepo;
		this.em = em;
	}

	public mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla getPantalla() {
		return lPantalla;
	}

	// Creation of new legacy Pantalla is unsupported
	@Override
	public void visit(Pantalla element) throws Exception {
		if (element.getId() == null && StringUtils.isEmpty(element.getClave())) {
			throw new Exception("A new Pantalla must have a clave");
		}
		// Pantalla items will be identified by clave by the user
		// If Modern pantalla has a clave then check if Modern already exists
		// TODO: find Pantalla eagerly and dettach it
		Optional<mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla> maybePantalla = pantallaRepo
				.findOneByCvePantalla(element.getClave());
		if (!maybePantalla.isPresent()) {
			throw new Exception(String.format("Pantalla with clave {} not found", element.getClave()));
		}
		lPantalla = maybePantalla.get();
		loadPantallaEagerly(lPantalla);
		em.detach(lPantalla);
		LegacyFactory.mergeToLegacy(element, lPantalla);
		super.visit(element);
	}

	@Override
	public void visit(Contenedor element) {
		// It is a root Contenedor
		if (element.getPadre() == null) {
			handleRootContenedor(element);
		} else { // It is a child Contenedor
			handleChildContenedor(element);
		}
		for (Contenedor hijo : element.getHijos()) {
			visit(hijo);
		}
		super.visit(element);
	}

	@Override
	public void visit(Campo element) {
		// Campo already exists
		if (element.getId() != null) {
			// Search the CampoWidget in lWidget.campoWidgets and 'merge' it with Campo
			Optional<CampoWidget> maybeCw = findCampoWidget(element.getId());
			if (maybeCw.isPresent()) {
				LegacyFactory.mergeToLegacy(element, maybeCw.get(), formatoRepo, em);
			}
			// Should throw an Exception
			else {
				CampoWidget cw = getCampoWidget(element, controlUiRepo, em);
				LegacyFactory.mergeToLegacy(element, cw, formatoRepo, em);
				lWidget.addCampoWidget(cw);
			}
		} else {
			// Create new CampoWidget and add it to lWidget.campoWidgets
			CampoWidget cw = getCampoWidget(element, controlUiRepo, em);
			LegacyFactory.mergeToLegacy(element, cw, formatoRepo, em);
			lWidget.addCampoWidget(cw);
		}
		super.visit(element);
	}

	private void handleRootContenedor(Contenedor element) {
		Widget w;
		// Contenedor already exists and current Pantalla already exists
		if (element.getId() != null && lPantalla.getIdPantalla() != null) {
			Optional<WidgetPantalla> maybeWp = findWidgetPantalla(element.getId(), lPantalla.getIdPantalla());
			if (maybeWp.isPresent()) {// It is already related to Pantalla
				w = maybeWp.get().getWidget();
			} else { // It is a new Contenedor
				// Should throw an Exception
				w = LegacyFactory.getWidget(element, tipoWidgetRepo, em);
				WidgetPantalla wpNew = new WidgetPantalla();
				wpNew.setPantalla(lPantalla);
				wpNew.setWidget(w);
				lPantalla.getWidgetPantallas().add(wpNew);
			}
		} else { // Is a new Contenedor and it is not related to Pantalla yet
			w = LegacyFactory.getWidget(element, tipoWidgetRepo, em);
			WidgetPantalla wpNew = new WidgetPantalla();
			wpNew.setPantalla(lPantalla);
			wpNew.setWidget(w);
			lPantalla.getWidgetPantallas().add(wpNew);
		}
		LegacyFactory.mergeToLegacy(element, w);
		lWidget = w;
	}

	private void handleChildContenedor(Contenedor element) {
		Widget w;
		if (element.getId() == null) {
			w = LegacyFactory.getWidget(element, tipoWidgetRepo, em);
		} else {
			Optional<Widget> maybeWidget = findWidget(element.getId());// Search for in children Contenedor
			if (maybeWidget.isPresent()) {
				w = maybeWidget.get();
			} else {
				// Should throw an Exception
				w = LegacyFactory.getWidget(element, tipoWidgetRepo, em);
			}
		}
		LegacyFactory.mergeToLegacy(element, w);
		lWidget.getHijos().add(w);
		lWidget = w;
	}

	private Optional<WidgetPantalla> findWidgetPantalla(Long idWidget, Long idPantalla) {
		for (WidgetPantalla wp : lPantalla.getWidgetPantallas()) {
			if (wp.getWidget().getIdWidget().equals(idWidget) && wp.getPantalla().getIdPantalla().equals(idPantalla)) {
				return Optional.of(wp);
			}
		}
		return Optional.empty();
	}

	private Optional<CampoWidget> findCampoWidget(Long id) {
		for (CampoWidget cw : lWidget.getCampoWidgets()) {
			if (cw.getIdCampoWidget().equals(id)) {
				return Optional.of(cw);
			}
		}
		return Optional.empty();
	}

	private Optional<Widget> findWidget(Long id) {
		for (Widget w : lWidget.getHijos()) {
			if (w.getIdWidget().equals(id)) {
				return Optional.of(w);
			}
		}
		return Optional.empty();
	}

}
