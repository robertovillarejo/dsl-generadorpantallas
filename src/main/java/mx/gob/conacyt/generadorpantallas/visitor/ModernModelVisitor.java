package mx.gob.conacyt.generadorpantallas.visitor;

import java.util.Optional;

import org.springframework.util.StringUtils;

import mx.gob.conacyt.generadorpantallas.factories.LegacyFactory;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.WidgetPantalla;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ControlUiRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.FormatoRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.PantallaRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.TipoWidgetRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.WidgetRepository;
import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;
import mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla;

public class ModernModelVisitor extends AbstractModernVisitor {

	private mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla lPantalla;
	private Widget lWidget;

	private WidgetRepository widgetRepo;

	private PantallaRepository pantallaRepo;

	private TipoWidgetRepository tipoWidgetRepo;

	private FormatoRepository formatoRepo;

	private ControlUiRepository controlUiRepo;

	public ModernModelVisitor(WidgetRepository widgetRepo, PantallaRepository pantallaRepo,
			TipoWidgetRepository tipoWidgetRepo, FormatoRepository formatoRepo, ControlUiRepository controlUiRepo) {
		this.widgetRepo = widgetRepo;
		this.pantallaRepo = pantallaRepo;
		this.tipoWidgetRepo = tipoWidgetRepo;
		this.formatoRepo = formatoRepo;
		this.controlUiRepo = controlUiRepo;
	}

	public mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla getPantalla() {
		return lPantalla;
	}

	@Override
	public void visit(Pantalla element) {
		if (!StringUtils.isEmpty(element.getClave())) {
			Optional<mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla> maybePantalla = pantallaRepo
					.findOneByCvePantalla(element.getClave());
			if (maybePantalla.isPresent()) {
				lPantalla = maybePantalla.get();
			}
		} else {
			lPantalla = LegacyFactory.toLegacy(element, widgetRepo);
		}
		super.visit(element);
	}

	@Override
	public void visit(Contenedor element) {

		if (element.getId() != null && lPantalla.getIdPantalla() != null) {
			Optional<WidgetPantalla> maybeWp = findWidgetPantalla(element.getId(), lPantalla.getIdPantalla());
			if (maybeWp.isPresent()) {
				lWidget = maybeWp.get().getWidget();
			}
		} else {
			lWidget = LegacyFactory.toLegacy(element, tipoWidgetRepo);
			WidgetPantalla wpNew = new WidgetPantalla();
			wpNew.setPantalla(lPantalla);
			wpNew.setWidget(lWidget);
			lPantalla.getWidgetPantallas().add(wpNew);
		}
		super.visit(element);
	}

	@Override
	public void visit(Campo element) {
		CampoWidget cw = LegacyFactory.toLegacy(element, controlUiRepo, formatoRepo);
		lWidget.addCampoWidget(cw);
		super.visit(element);
	}

	private Optional<WidgetPantalla> findWidgetPantalla(Long idWidget, Long idPantalla) {
		for (WidgetPantalla wp : lPantalla.getWidgetPantallas()) {
			if (wp.getWidget().getIdWidget() == idWidget && wp.getPantalla().getIdPantalla() == idWidget) {
				return Optional.of(wp);
			}
		}
		return Optional.empty();
	}

}
