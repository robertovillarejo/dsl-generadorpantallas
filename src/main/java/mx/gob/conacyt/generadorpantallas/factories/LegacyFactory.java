package mx.gob.conacyt.generadorpantallas.factories;

import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.BOOTSTRAP_SPACE;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.BUTTON;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.CHECKBOX;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.DATEPICKER;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.HEADERLESS_TABLE;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.IMAGEN;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.INPUT_FILE;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.INPUT_TEXT_ADDON;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.LABEL;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.LABELED_CHECKBOX;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.LABEL_TEXT;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.LINK;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.LIST_GROUP;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.NG_SELECT;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.PASSWORD;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.RADIO_BUTTON;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.SECTION_SUBTITLE;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.SELECT;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.SIGNED_DOCUMENT;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.SPAN;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.TEXT;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.TEXT_AREA;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.TIME_PICKER;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.TITLE_H1;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.TITLE_H2;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.TITLE_H3;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.UI_SELECT;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.WIZARD;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;

import javax.persistence.EntityManager;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CatControlUi;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CatTipoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Formato;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ControlUiRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.FormatoRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.TipoWidgetRepository;
import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;
import mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.BootstrapSpace;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Boton;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Checkbox;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.DatePicker;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.HeaderlessTable;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.HrGraficaBase;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Imagen;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.InputFile;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.InputTextAddon;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Label;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.LabelText;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.LabeledCheckbox;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Link;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.ListGroup;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.NgSelect;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Password;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.RadioButton;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.SectionSubtitle;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Select;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.SignedDocument;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Span;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Text;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.TextArea;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.TimePicker;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.TitleH1;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.TitleH2;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.TitleH3;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.UiSelect;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Wizard;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.BigModal;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Breadcrumb;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Collapsible;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.ComboWizard;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.CustomWidget;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.DataSection;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.DivTag;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Documents;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.ExportableGrid;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Form;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Grid;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.InformativeBigModal;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.InformativeSmallModal;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Modal;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.PaginatedGrid;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Panel;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Row;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.SelectableGrid;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.SelectablePaginatedGrid;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Tab;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Table;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Tableau;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.TabsContainer;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.TagA;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.TdTag;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.TitleHr;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.TrTag;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.TreeView;

public class LegacyFactory {

	public static Widget getWidget(mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor contenedor,
			TipoWidgetRepository repo, EntityManager em) {
		Widget widget = new Widget();
		String tipo;

		if (contenedor instanceof BigModal) {
			tipo = BIG_MODAL;
		} else if (contenedor instanceof Breadcrumb) {
			tipo = BREADCRUMB;
		} else if (contenedor instanceof Collapsible) {
			tipo = COLLAPSIBLE;
		} else if (contenedor instanceof ComboWizard) {
			tipo = COMBO_WIZARD;
		} else if (contenedor instanceof CustomWidget) {
			tipo = CUSTOM;
		} else if (contenedor instanceof DataSection) {
			tipo = DATA_SECTION;
		} else if (contenedor instanceof DivTag) {
			tipo = DIV_TAG;
		} else if (contenedor instanceof Documents) {
			tipo = DOCUMENTS;
		} else if (contenedor instanceof ExportableGrid) {
			tipo = EXPORTABLE_GRID;
		} else if (contenedor instanceof Form) {
			tipo = FORM;
		} else if (contenedor instanceof Grid) {
			tipo = GRID;
		} else if (contenedor instanceof mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.HeaderlessTable) {
			tipo = HEADERLESS_TABLE_CONTAINER;
		} else if (contenedor instanceof InformativeBigModal) {
			tipo = INFORMATIVE_BIG_MODAL;
		} else if (contenedor instanceof InformativeSmallModal) {
			tipo = INFORMATIVE_SMALL_MODAL;
		} else if (contenedor instanceof Modal) {
			tipo = MODAL;
		} else if (contenedor instanceof PaginatedGrid) {
			tipo = PAGINATED_GRID;
		} else if (contenedor instanceof Panel) {
			tipo = PANEL;
		} else if (contenedor instanceof Row) {
			tipo = ROW;
		} else if (contenedor instanceof SelectableGrid) {
			tipo = SELECTABLE_GRID;
		} else if (contenedor instanceof SelectablePaginatedGrid) {
			tipo = SELECTABLE_PAGINATED_GRID;
		} else if (contenedor instanceof Tab) {
			tipo = TAB;
		} else if (contenedor instanceof Table) {
			tipo = TABLE;
		} else if (contenedor instanceof Tableau) {
			tipo = TABLEAU;
		} else if (contenedor instanceof TabsContainer) {
			tipo = TABS_CONTAINER;
		} else if (contenedor instanceof TagA) {
			tipo = TAG_A;
		} else if (contenedor instanceof TdTag) {
			tipo = TD_CONTAINER;
		} else if (contenedor instanceof mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.TitleH3) {
			tipo = H3_CONTAINER;
		} else if (contenedor instanceof TitleHr) {
			tipo = HR_CONTAINER;
		} else if (contenedor instanceof TreeView) {
			tipo = TREE_VIEW;
		} else if (contenedor instanceof TrTag) {
			tipo = TR_CONTAINER;
		} else if (contenedor instanceof mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Wizard) {
			tipo = WIZARD_CONTAINER;
		} else {
			tipo = FORM;
		}
		Optional<CatTipoWidget> maybeTipo = repo.findOneByCveTipoWidget(tipo);
		if (maybeTipo.isPresent()) {
			CatTipoWidget catTipoWidget = maybeTipo.get();
			em.detach(catTipoWidget);
			widget.setCatTipoWidget(catTipoWidget);
		}
		return widget;
	}

	public static void mergeToLegacy(Pantalla modern, mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla legacy) {
		legacy.setIdPantalla(modern.getId());
		legacy.setCvePantalla(modern.getClave());
		legacy.setDescPantalla(modern.getDescripcion());
		legacy.setIdTipoPantalla(new BigDecimal(1));// Pantalla dinámica
		legacy.setIndEstatus("1");
		legacy.setFechaAlta(modern.getFechaAlta());
		legacy.setFechaModificacion(modern.getFechaModificacion());
		legacy.setUsuarioAlta(modern.getUsuarioAlta());
		legacy.setUsuarioModificacion(modern.getUsuarioModificacion());
	}

	public static void mergeToLegacy(Contenedor contenedor, Widget widget) {
		widget.setIdWidget(contenedor.getId());
		widget.setConfiguration(contenedor.getConfiguracion());
		widget.setCveWidget(contenedor.getClave());
		widget.setDescWidget(contenedor.getDescripcion());
		widget.setIndEstatus("1");
		widget.setNgClass(contenedor.getNgClass());
		widget.setNgIf(contenedor.getNgIf());
		widget.setNgrepeat(contenedor.getNgRepeat());
		widget.setNgShow(contenedor.getNgShow());
		widget.setNgStyle(contenedor.getNgStyle());
		widget.setPosicion(new BigDecimal(contenedor.getPosicion()));
		widget.setTamanio(contenedor.getTamanio().toString());
		widget.setFechaAlta(contenedor.getFechaAlta());
		widget.setFechaModificacion(contenedor.getFechaModificacion() == null ? null
				: new Timestamp(contenedor.getFechaModificacion().getTime()));
		widget.setUsuarioAlta(contenedor.getUsuarioAlta());
		widget.setUsuarioModificacion(contenedor.getUsuarioModificacion());
	}

	public static void mergeToLegacy(Campo campo, CampoWidget cw, FormatoRepository formatoRepo, EntityManager em) {
		cw.setIdCampoWidget(campo.getId());
		cw.setDescCampoWidget(campo.getDescripcionCampo());
		cw.setCveCampoWidget(campo.getClave());
		cw.setActivo(campo.isActivo() ? "1" : "0");
		cw.setAtributo(campo.getAtributo());
		cw.setBusqueda(campo.getBusqueda());
		cw.setCampoFiltrado(campo.getCampoFiltrado());
		cw.setCaseCampo(campo.getCaseCampo());
		cw.setConfiguration(campo.getConfiguracion());
		cw.setDescripcion(campo.getDescripcion());
		cw.setDireccion(campo.getDireccion());
		cw.setEnfocar(campo.getEnfocar());
		cw.setEvento(campo.getEvento());
		cw.setExportar(campo.getExportar());
		cw.setFormato(getFormato(campo.getFormato(), formatoRepo, em));
		cw.setGrid(campo.getGrid());
		cw.setHabilitado(campo.isHabilitado() == null ? null : (campo.isHabilitado() ? "1" : "0"));
		cw.setIndEstatus("1");
		cw.setLineaNueva(campo.getLineaNueva());
		cw.setLongitud(campo.getLongitud() == null ? null : new BigDecimal(campo.getLongitud()));
		cw.setLongitudMinima(campo.getLongitudMinima() == null ? null : new BigDecimal(campo.getLongitudMinima()));
		cw.setMensaje(campo.getMensaje());
		cw.setMensajeAlt(campo.getMensajeAlterno());
		cw.setMensajeCaptura(campo.getMensajeCaptura());
		cw.setMensajeFaltante(campo.getMensajeFaltante());
		cw.setMensajeInvalido(campo.getMensajeInvalido());
		cw.setMensajeSolicitud(campo.getMensajeSolicitud());
		cw.setMouseOver(campo.getMouseOver());
		cw.setNgChange(campo.getNgChange());
		cw.setNgClass(campo.getNgClass());
		cw.setNgIf(campo.getNgIf());
		cw.setNgmodel(campo.getNgModel());
		cw.setNgShow(campo.getNgShow());
		cw.setNgValue(campo.getNgValue());
		cw.setPosicion(campo.getPosicion() == null ? null : new BigDecimal(campo.getPosicion()));
		cw.setPosicionX(campo.getPosicionX() == null ? null : new BigDecimal(campo.getPosicionX()));
		cw.setPosicionY(campo.getPosicionY() == null ? null : new BigDecimal(campo.getPosicionY()));
		cw.setRequerido(campo.isRequerido() ? "1" : "0");
		cw.setUsoDrilldown(campo.getUsoDrillDown());
		cw.setValorDefault(campo.getValorDefault());
		cw.setValorDesplegado(campo.getValorDesplegado());
		cw.setFechaAlta(campo.getFechaAlta());
		cw.setFechaModificacion(
				campo.getFechaModificacion() == null ? null : new Timestamp(campo.getFechaModificacion().getTime()));
		cw.setUsuarioAlta(campo.getUsuarioAlta());
		cw.setUsuarioModificacion(campo.getUsuarioModificacion());
	}

	public static Formato getFormato(String formatoStr, FormatoRepository formatoRepo, EntityManager em) {
		Optional<Formato> maybeFormato = formatoRepo.findOneByFormato(formatoStr);
		if (maybeFormato.isPresent()) {
			Formato f = maybeFormato.get();
			return f;
		}
		Formato f = new Formato();
		em.detach(f);
		f.setFormato(formatoStr);
		return f;
	}

	public static CampoWidget getCampoWidget(Campo campo, ControlUiRepository tipoCampoRepo, EntityManager em) {
		CampoWidget cw = new CampoWidget();
		String tipo;
		if (campo instanceof BootstrapSpace) {
			tipo = BOOTSTRAP_SPACE;
		} else if (campo instanceof Boton) {
			tipo = BUTTON;
		} else if (campo instanceof Checkbox) {
			tipo = CHECKBOX;
		} else if (campo instanceof DatePicker) {
			tipo = DATEPICKER;
		} else if (campo instanceof HeaderlessTable) {
			tipo = HEADERLESS_TABLE;
		} else if (campo instanceof HrGraficaBase) {
			tipo = HEADERLESS_TABLE;
		} else if (campo instanceof Imagen) {
			tipo = IMAGEN;
		} else if (campo instanceof InputFile) {
			tipo = INPUT_FILE;
		} else if (campo instanceof InputTextAddon) {
			tipo = INPUT_TEXT_ADDON;
		} else if (campo instanceof Label) {
			tipo = LABEL;
		} else if (campo instanceof LabeledCheckbox) {
			tipo = LABELED_CHECKBOX;
		} else if (campo instanceof LabelText) {
			tipo = LABEL_TEXT;
		} else if (campo instanceof Link) {
			tipo = LINK;
		} else if (campo instanceof ListGroup) {
			tipo = LIST_GROUP;
		} else if (campo instanceof NgSelect) {
			tipo = NG_SELECT;
		} else if (campo instanceof Password) {
			tipo = PASSWORD;
		} else if (campo instanceof RadioButton) {
			tipo = RADIO_BUTTON;
		} else if (campo instanceof SectionSubtitle) {
			tipo = SECTION_SUBTITLE;
		} else if (campo instanceof Select) {
			tipo = SELECT;
		} else if (campo instanceof SignedDocument) {
			tipo = SIGNED_DOCUMENT;
		} else if (campo instanceof Span) {
			tipo = SPAN;
		} else if (campo instanceof Text) {
			tipo = TEXT;
		} else if (campo instanceof TextArea) {
			tipo = TEXT_AREA;
		} else if (campo instanceof TimePicker) {
			tipo = TIME_PICKER;
		} else if (campo instanceof TitleH1) {
			tipo = TITLE_H1;
		} else if (campo instanceof TitleH2) {
			tipo = TITLE_H2;
		} else if (campo instanceof TitleH3) {
			tipo = TITLE_H3;
		} else if (campo instanceof UiSelect) {
			tipo = UI_SELECT;
		} else if (campo instanceof Wizard) {
			tipo = WIZARD;
		} else {
			tipo = TEXT;
		}
		Optional<CatControlUi> maybeTipoCampo = tipoCampoRepo.findOneByCveControlUi(tipo);
		if (maybeTipoCampo.isPresent()) {
			CatControlUi catControlUi = maybeTipoCampo.get();
			em.detach(catControlUi);
			cw.setCatControlUi(catControlUi);
		}
		return cw;
	}
}
