package mx.gob.conacyt.generadorpantallas.factories;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CatTipoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Componente;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Menu;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Transicion;
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
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Form;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Grid;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Modal;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Panel;
import static mx.gob.conacyt.generadorpantallas.factories.LegacyConstants.*;

public class ModernFactory {

    private ModernFactory() {
    }

    public static Campo getCampo(CampoWidget cw) {
        String tipo = cw.getCatControlUi().getCveControlUi();
        switch (tipo) {
        case BUTTON:
            return new Boton();
        case CHECKBOX:
            return new Checkbox();
        case LABELED_CHECKBOX:
            return new LabeledCheckbox();
        case DATEPICKER:
            return new DatePicker();
        case HR:
            return new HrGraficaBase();
        case IMAGEN:
            return new Imagen();
        case INPUT_TEXT_ADDON:
            return new InputTextAddon();
        case INPUT_FILE:
            return new InputFile();
        case LABEL:
            return new Label();
        case LABEL_TEXT:
            return new LabelText();
        case LINK:
            return new Link();
        case LIST_GROUP:
            return new ListGroup();
        case NG_SELECT:
            return new NgSelect();
        case PASSWORD:
            return new Password();
        case RADIO_BUTTON:
            return new RadioButton();
        case TITLE_H2:
            return new TitleH2();
        case TITLE_H3:
            return new TitleH3();
        case SELECT:
            return new Select();
        case SIGNED_DOCUMENT:
            return new SignedDocument();
        case BOOTSTRAP_SPACE:
            return new BootstrapSpace();
        case SPAN:
            return new Span();
        case SECTION_SUBTITLE:
            return new SectionSubtitle();
        case HEADERLESS_TABLE:
            return new HeaderlessTable();
        case TEXT:
            return new Text();
        case TEXT_AREA:
            return new TextArea();
        case TIME_PICKER:
            return new TimePicker();
        case TITLE_H1:
            return new TitleH1();
        case UI_SELECT:
            return new UiSelect();
        case WIZARD:
            return new Wizard();
        }
        return new Text();
    }

    public static mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor getContenedor(Widget widget) {
        CatTipoWidget tipoWidget = widget.getCatTipoWidget();
        if ("form".equals(tipoWidget.getCveTipoWidget())) {
            return new Form();
        }
        if ("modal".equals(tipoWidget.getCveTipoWidget())) {
            return new Modal();
        }
        if ("grid".equals(tipoWidget.getCveTipoWidget())) {
            return new Grid();
        }
        if ("panel".equals(tipoWidget.getCveTipoWidget())) {
            return new Panel();
        }
        return new Form();
    }

    public static mx.gob.conacyt.generadorpantallas.modern.domain.Componente toModern(Componente componente) {
        mx.gob.conacyt.generadorpantallas.modern.domain.Componente modern = new mx.gob.conacyt.generadorpantallas.modern.domain.Componente();
        modern.setClave(componente.getCveComponente());
        modern.setDescripcion(componente.getDescComponente());
        modern.setId(componente.getIdComponente());
        modern.setFechaAlta(componente.getFechaAlta());
        modern.setFechaModificacion(componente.getFechaModificacion());
        modern.setUsuarioAlta(componente.getUsuarioAlta());
        modern.setUsuarioModificacion(componente.getUsuarioModificacion());
        return modern;
    }

    // TODO
    public static mx.gob.conacyt.generadorpantallas.modern.domain.Menu toModern(Menu menu) {
        mx.gob.conacyt.generadorpantallas.modern.domain.Menu modern = new mx.gob.conacyt.generadorpantallas.modern.domain.Menu();
        Transicion transicion = new Transicion();
        modern.setTransicion(transicion);
        modern.setFechaAlta(menu.getFechaAlta());
        modern.setFechaModificacion(menu.getFechaModificacion());
        modern.setUsuarioAlta(menu.getUsuarioAlta());
        modern.setUsuarioModificacion(menu.getUsuarioModificacion());
        return modern;
    }

    public static mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla toModern(Pantalla pantalla) {
        mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla modern = new mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla();
        modern.setId(pantalla.getIdPantalla());
        modern.setClave(pantalla.getCvePantalla());
        modern.setDescripcion(pantalla.getDescPantalla());
        modern.setFechaAlta(pantalla.getFechaAlta());
        modern.setFechaModificacion(pantalla.getFechaModificacion());
        modern.setUsuarioAlta(pantalla.getUsuarioAlta());
        modern.setUsuarioModificacion(pantalla.getUsuarioModificacion());
        return modern;
    }

    public static mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor toModern(Widget widget) {
        mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor contenedor = getContenedor(widget);
        contenedor.setId(widget.getIdWidget());
        contenedor.setClave(widget.getCveWidget());
        contenedor.setConfiguracion(widget.getConfiguration());
        contenedor.setDescripcion(widget.getDescWidget());
        contenedor.setNgClass(widget.getNgClass());
        contenedor.setNgIf(widget.getNgIf());
        contenedor.setNgRepeat(widget.getNgrepeat());
        contenedor.setNgShow(widget.getNgShow());
        contenedor.setNgStyle(widget.getNgStyle());
        contenedor.setPosicion(widget.getPosicion().intValue());
        contenedor.setTamanio(Integer.parseInt(widget.getTamanio()));
        contenedor.setFechaAlta(widget.getFechaAlta());
        contenedor.setFechaModificacion(widget.getFechaModificacion());
        contenedor.setUsuarioAlta(widget.getUsuarioAlta());
        contenedor.setUsuarioModificacion(widget.getUsuarioModificacion());
        return contenedor;
    }

    public static Campo toModern(CampoWidget cw) {
        Campo campo = getCampo(cw);
        campo.setId(cw.getIdCampoWidget());
        campo.setActivo(Boolean.parseBoolean(cw.getActivo()));
        campo.setAtributo(cw.getAtributo());
        campo.setBusqueda(cw.getBusqueda());
        campo.setCampoFiltrado(cw.getCampoFiltrado());
        campo.setCaseCampo(cw.getCaseCampo());
        campo.setClave(cw.getCveCampoWidget());
        campo.setConfiguracion(cw.getConfiguration());
        campo.setDescripcion(cw.getDescripcion());
        campo.setDescripcionCampo(cw.getDescCampoWidget());
        campo.setDireccion(cw.getDireccion());
        campo.setEnfocar(cw.getEnfocar());
        campo.setEvento(cw.getEvento());
        campo.setExportar(cw.getExportar());
        campo.setFormato(cw.getFormato().getFormato());
        campo.setGrid(cw.getGrid());
        campo.setHabilitado(cw.getHabilitado() == null ? null : Boolean.parseBoolean(cw.getHabilitado()));
        campo.setLineaNueva(cw.getLineaNueva());
        campo.setLongitud(cw.getLongitud() == null ? null : cw.getLongitud().intValue());
        campo.setLongitudMinima(cw.getLongitudMinima() == null ? null : cw.getLongitudMinima().intValue());
        campo.setMensaje(cw.getMensaje());
        campo.setMensajeAlterno(cw.getMensajeAlt());
        campo.setMensajeCaptura(cw.getMensajeCaptura());
        campo.setMensajeFaltante(cw.getMensajeFaltante());
        campo.setMensajeInvalido(cw.getMensajeInvalido());
        campo.setMensajeSolicitud(cw.getMensajeSolicitud());
        campo.setMouseOver(cw.getMouseOver());
        campo.setNgChange(cw.getNgChange());
        campo.setNgClass(cw.getNgClass());
        campo.setNgIf(cw.getNgIf());
        campo.setNgModel(cw.getNgmodel());
        campo.setNgShow(cw.getNgShow());
        campo.setNgValue(cw.getNgValue());
        campo.setPosicion(cw.getPosicion() == null ? null : cw.getPosicion().intValue());
        campo.setPosicionX(cw.getPosicionX() == null ? null : cw.getPosicionX().intValue());
        campo.setPosicionY(cw.getPosicionY() == null ? null : cw.getPosicionX().intValue());
        campo.setRequerido(Boolean.parseBoolean(cw.getRequerido()));
        campo.setUsoDrillDown(cw.getUsoDrilldown());
        campo.setValorDefault(cw.getValorDefault());
        campo.setValorDesplegado(cw.getValorDesplegado());
        campo.setFechaAlta(cw.getFechaAlta());
        campo.setFechaModificacion(cw.getFechaModificacion());
        campo.setUsuarioAlta(cw.getUsuarioAlta());
        campo.setUsuarioModificacion(cw.getUsuarioModificacion());
        return campo;
    }

}
