package mx.gob.conacyt.generadorpantallas.factories;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CatTipoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Componente;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Menu;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Transicion;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Boton;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Checkbox;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Form;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Grid;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Modal;
import mx.gob.conacyt.generadorpantallas.modern.domain.contenedores.Panel;

public class ModernFactory {

    private ModernFactory() {
    }

    public static Campo getCampo(CampoWidget cw) {
        String tipo = cw.getCatControlUi().getCveControlUi();
        switch (tipo) {
        case "button":
            return new Boton();
        case "checkbox":
            return new Checkbox();
        }
        return new Campo();
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
        return modern;
    }

    // TODO
    public static mx.gob.conacyt.generadorpantallas.modern.domain.Menu toModern(Menu menu) {
        mx.gob.conacyt.generadorpantallas.modern.domain.Menu modern = new mx.gob.conacyt.generadorpantallas.modern.domain.Menu();
        Transicion transicion = new Transicion();
        modern.setTransicion(transicion);
        return modern;
    }

    public static mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla toModern(Pantalla pantalla) {
        mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla modern = new mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla();
        modern.setId(pantalla.getIdPantalla());
        modern.setClave(pantalla.getCvePantalla());
        modern.setDescripcion(pantalla.getDescPantalla());
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
        return campo;
    }

}
