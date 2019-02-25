package mx.gob.conacyt.generadorpantallas.factories;

import java.math.BigDecimal;
import java.util.Optional;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CatControlUi;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CatTipoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Formato;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ControlUiRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.FormatoRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.TipoWidgetRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.WidgetRepository;
import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;
import mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla;

public class LegacyFactory {

    public static Widget getWidget(mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor contenedor,
            TipoWidgetRepository repo) {
        Widget widget = new Widget();
        Optional<CatTipoWidget> maybeTipo = repo.findOneByCveTipoWidget(contenedor.getTipo());
        if (maybeTipo.isPresent()) {
            widget.setCatTipoWidget(maybeTipo.get());
        }
//        else {
//            return new Widget();
//            // throw new Exception(String.format("Falló al recuperar el widget de tipo: {}",
//            // contenedor.getTipo()));
//        }
        return widget;
    }

    public static mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla toLegacy(Pantalla pantalla,
            WidgetRepository repo) {
        mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla legacy = new mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla();
        legacy.setIdPantalla(pantalla.getId());
        legacy.setCvePantalla(pantalla.getClave());
        legacy.setDescPantalla(pantalla.getDescripcion());
        legacy.setIdTipoPantalla(new BigDecimal(1));// Pantalla dinámica
        legacy.setIndEstatus("1");
        return legacy;
    }

    public static mx.gob.conacyt.generadorpantallas.legacy.domain.Widget toLegacy(Contenedor contenedor,
            TipoWidgetRepository repo) {
        mx.gob.conacyt.generadorpantallas.legacy.domain.Widget widget = getWidget(contenedor, repo);
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
        return widget;
    }

    public static void toLegacy(Campo campo, CampoWidget cw, ControlUiRepository tipoCampoRepo,
            FormatoRepository formatoRepo) {
        // TODO: establecer los valores de auditoría
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
        cw.setFormato(getFormato(campo.getFormato(), formatoRepo));
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
    }

    public static Formato getFormato(String formatoStr, FormatoRepository formatoRepo) {
        Optional<Formato> maybeFormato = formatoRepo.findOneByFormato(formatoStr);
        if (maybeFormato.isPresent()) {
            return maybeFormato.get();
        }
        Formato f = new Formato();
        f.setFormato(formatoStr);
        return f;
    }

    public static CampoWidget getCampoWidget(Campo campo, ControlUiRepository tipoCampoRepo) {
        CampoWidget cw = new CampoWidget();
        Optional<CatControlUi> maybeTipoCampo = tipoCampoRepo.findOneByCveControlUi(campo.getTipo());
        if (maybeTipoCampo.isPresent()) {
            cw.setCatControlUi(maybeTipoCampo.get());
        }
        return cw;
    }
}
