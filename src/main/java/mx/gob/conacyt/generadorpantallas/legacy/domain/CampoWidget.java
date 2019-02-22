package mx.gob.conacyt.generadorpantallas.legacy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import mx.gob.conacyt.generadorpantallas.visitor.Element;
import mx.gob.conacyt.generadorpantallas.visitor.LegacyVisitor;

/**
 * The persistent class for the CAMPO_WIDGET database table.
 * 
 */
@Entity
@Table(name = "CAMPO_WIDGET")
public class CampoWidget implements Serializable, Element {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CAMPO_WIDGET")
    private Long idCampoWidget;

    private String activo;

    private String atributo;

    private String busqueda;

    @Column(name = "CAMPO_FILTRADO")
    private String campoFiltrado;

    @Column(name = "CASE_CAMPO")
    private String caseCampo;

    private String configuration;

    @Column(name = "CVE_CAMPO_WIDGET")
    private String cveCampoWidget;

    @Column(name = "DESC_CAMPO_WIDGET")
    private String descCampoWidget;

    private String descripcion;

    private String direccion;

    private String enfocar;

    private String evento;

    private String exportar;

    @Column(name = "FECHA_ALTA")
    private Timestamp fechaAlta;

    @Column(name = "FECHA_MODIFICACION")
    private Timestamp fechaModificacion;

    private String grid;

    private String habilitado;

    @ManyToOne
    @JoinColumn(name = "ID_FORMATO")
    private Formato formato;

    @Column(name = "ID_LISTA_VALOR")
    private BigDecimal idListaValor;

    @Column(name = "IND_ESTATUS")
    private String indEstatus;

    @Column(name = "LINEA_NUEVA")
    private String lineaNueva;

    private BigDecimal longitud;

    @Column(name = "LONGITUD_MINIMA")
    private BigDecimal longitudMinima;

    private String mensaje;

    @Column(name = "MENSAJE_ALT")
    private String mensajeAlt;

    @Column(name = "MENSAJE_CAPTURA")
    private String mensajeCaptura;

    @Column(name = "MENSAJE_FALTANTE")
    private String mensajeFaltante;

    @Column(name = "MENSAJE_INVALIDO")
    private String mensajeInvalido;

    @Column(name = "MENSAJE_SOLICITUD")
    private String mensajeSolicitud;

    @Column(name = "MOUSE_OVER")
    private String mouseOver;

    @Column(name = "NG_CHANGE")
    private String ngChange;

    @Column(name = "NG_CLASS")
    private String ngClass;

    @Column(name = "NG_IF")
    private String ngIf;

    @Column(name = "NG_SHOW")
    private String ngShow;

    @Column(name = "NG_VALUE")
    private String ngValue;

    private String ngmodel;

    private BigDecimal posicion;

    @Column(name = "POSICION_X")
    private BigDecimal posicionX;

    @Column(name = "POSICION_Y")
    private BigDecimal posicionY;

    private String requerido;

    @Column(name = "USO_DRILLDOWN")
    private String usoDrilldown;

    @Column(name = "USUARIO_ALTA")
    private BigDecimal usuarioAlta;

    @Column(name = "USUARIO_MODIFICACION")
    private BigDecimal usuarioModificacion;

    @Column(name = "VALOR_DEFAULT")
    private String valorDefault;

    @Column(name = "VALOR_DESPLEGADO")
    private String valorDesplegado;

    // bi-directional many-to-one association to CatControlUi
    @ManyToOne
    @JoinColumn(name = "ID_CONTROL_UI")
    private CatControlUi catControlUi;

    // bi-directional many-to-one association to Widget
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_WIDGET")
    private Widget widget;

    public CampoWidget() {
    }

    public Long getIdCampoWidget() {
        return this.idCampoWidget;
    }

    public void setIdCampoWidget(Long idCampoWidget) {
        this.idCampoWidget = idCampoWidget;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getAtributo() {
        return this.atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getBusqueda() {
        return this.busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public String getCampoFiltrado() {
        return this.campoFiltrado;
    }

    public void setCampoFiltrado(String campoFiltrado) {
        this.campoFiltrado = campoFiltrado;
    }

    public String getCaseCampo() {
        return this.caseCampo;
    }

    public void setCaseCampo(String caseCampo) {
        this.caseCampo = caseCampo;
    }

    public String getConfiguration() {
        return this.configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getCveCampoWidget() {
        return this.cveCampoWidget;
    }

    public void setCveCampoWidget(String cveCampoWidget) {
        this.cveCampoWidget = cveCampoWidget;
    }

    public String getDescCampoWidget() {
        return this.descCampoWidget;
    }

    public void setDescCampoWidget(String descCampoWidget) {
        this.descCampoWidget = descCampoWidget;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEnfocar() {
        return this.enfocar;
    }

    public void setEnfocar(String enfocar) {
        this.enfocar = enfocar;
    }

    public String getEvento() {
        return this.evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getExportar() {
        return this.exportar;
    }

    public void setExportar(String exportar) {
        this.exportar = exportar;
    }

    public Timestamp getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Timestamp getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getGrid() {
        return this.grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getHabilitado() {
        return this.habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    public Formato getFormato() {
        return this.formato;
    }

    public void setFormato(Formato Formato) {
        this.formato = formato;
    }

    public BigDecimal getIdListaValor() {
        return this.idListaValor;
    }

    public void setIdListaValor(BigDecimal idListaValor) {
        this.idListaValor = idListaValor;
    }

    public String getIndEstatus() {
        return this.indEstatus;
    }

    public void setIndEstatus(String indEstatus) {
        this.indEstatus = indEstatus;
    }

    public String getLineaNueva() {
        return this.lineaNueva;
    }

    public void setLineaNueva(String lineaNueva) {
        this.lineaNueva = lineaNueva;
    }

    public BigDecimal getLongitud() {
        return this.longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLongitudMinima() {
        return this.longitudMinima;
    }

    public void setLongitudMinima(BigDecimal longitudMinima) {
        this.longitudMinima = longitudMinima;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensajeAlt() {
        return this.mensajeAlt;
    }

    public void setMensajeAlt(String mensajeAlt) {
        this.mensajeAlt = mensajeAlt;
    }

    public String getMensajeCaptura() {
        return this.mensajeCaptura;
    }

    public void setMensajeCaptura(String mensajeCaptura) {
        this.mensajeCaptura = mensajeCaptura;
    }

    public String getMensajeFaltante() {
        return this.mensajeFaltante;
    }

    public void setMensajeFaltante(String mensajeFaltante) {
        this.mensajeFaltante = mensajeFaltante;
    }

    public String getMensajeInvalido() {
        return this.mensajeInvalido;
    }

    public void setMensajeInvalido(String mensajeInvalido) {
        this.mensajeInvalido = mensajeInvalido;
    }

    public String getMensajeSolicitud() {
        return this.mensajeSolicitud;
    }

    public void setMensajeSolicitud(String mensajeSolicitud) {
        this.mensajeSolicitud = mensajeSolicitud;
    }

    public String getMouseOver() {
        return this.mouseOver;
    }

    public void setMouseOver(String mouseOver) {
        this.mouseOver = mouseOver;
    }

    public String getNgChange() {
        return this.ngChange;
    }

    public void setNgChange(String ngChange) {
        this.ngChange = ngChange;
    }

    public String getNgClass() {
        return this.ngClass;
    }

    public void setNgClass(String ngClass) {
        this.ngClass = ngClass;
    }

    public String getNgIf() {
        return this.ngIf;
    }

    public void setNgIf(String ngIf) {
        this.ngIf = ngIf;
    }

    public String getNgShow() {
        return this.ngShow;
    }

    public void setNgShow(String ngShow) {
        this.ngShow = ngShow;
    }

    public String getNgValue() {
        return this.ngValue;
    }

    public void setNgValue(String ngValue) {
        this.ngValue = ngValue;
    }

    public String getNgmodel() {
        return this.ngmodel;
    }

    public void setNgmodel(String ngmodel) {
        this.ngmodel = ngmodel;
    }

    public BigDecimal getPosicion() {
        return this.posicion;
    }

    public void setPosicion(BigDecimal posicion) {
        this.posicion = posicion;
    }

    public BigDecimal getPosicionX() {
        return this.posicionX;
    }

    public void setPosicionX(BigDecimal posicionX) {
        this.posicionX = posicionX;
    }

    public BigDecimal getPosicionY() {
        return this.posicionY;
    }

    public void setPosicionY(BigDecimal posicionY) {
        this.posicionY = posicionY;
    }

    public String getRequerido() {
        return this.requerido;
    }

    public void setRequerido(String requerido) {
        this.requerido = requerido;
    }

    public String getUsoDrilldown() {
        return this.usoDrilldown;
    }

    public void setUsoDrilldown(String usoDrilldown) {
        this.usoDrilldown = usoDrilldown;
    }

    public BigDecimal getUsuarioAlta() {
        return this.usuarioAlta;
    }

    public void setUsuarioAlta(BigDecimal usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public BigDecimal getUsuarioModificacion() {
        return this.usuarioModificacion;
    }

    public void setUsuarioModificacion(BigDecimal usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getValorDefault() {
        return this.valorDefault;
    }

    public void setValorDefault(String valorDefault) {
        this.valorDefault = valorDefault;
    }

    public String getValorDesplegado() {
        return this.valorDesplegado;
    }

    public void setValorDesplegado(String valorDesplegado) {
        this.valorDesplegado = valorDesplegado;
    }

    public CatControlUi getCatControlUi() {
        return this.catControlUi;
    }

    public void setCatControlUi(CatControlUi catControlUi) {
        this.catControlUi = catControlUi;
    }

    public Widget getWidget() {
        return this.widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    @Override
    public String toString() {
        return "CampoWidget [idCampoWidget=" + idCampoWidget + ", activo=" + activo + ", atributo=" + atributo
                + ", busqueda=" + busqueda + ", campoFiltrado=" + campoFiltrado + ", caseCampo=" + caseCampo
                + ", configuration=" + configuration + ", cveCampoWidget=" + cveCampoWidget + ", descCampoWidget="
                + descCampoWidget + ", descripcion=" + descripcion + ", direccion=" + direccion + ", enfocar=" + enfocar
                + ", evento=" + evento + ", exportar=" + exportar + ", fechaAlta=" + fechaAlta + ", fechaModificacion="
                + fechaModificacion + ", grid=" + grid + ", habilitado=" + habilitado + ", formato=" + formato
                + ", idListaValor=" + idListaValor + ", indEstatus=" + indEstatus + ", lineaNueva=" + lineaNueva
                + ", longitud=" + longitud + ", longitudMinima=" + longitudMinima + ", mensaje=" + mensaje
                + ", mensajeAlt=" + mensajeAlt + ", mensajeCaptura=" + mensajeCaptura + ", mensajeFaltante="
                + mensajeFaltante + ", mensajeInvalido=" + mensajeInvalido + ", mensajeSolicitud=" + mensajeSolicitud
                + ", mouseOver=" + mouseOver + ", ngChange=" + ngChange + ", ngClass=" + ngClass + ", ngIf=" + ngIf
                + ", ngShow=" + ngShow + ", ngValue=" + ngValue + ", ngmodel=" + ngmodel + ", posicion=" + posicion
                + ", posicionX=" + posicionX + ", posicionY=" + posicionY + ", requerido=" + requerido
                + ", usoDrilldown=" + usoDrilldown + ", usuarioAlta=" + usuarioAlta + ", usuarioModificacion="
                + usuarioModificacion + ", valorDefault=" + valorDefault + ", valorDesplegado=" + valorDesplegado
                + ", catControlUi=" + catControlUi + ", widget=" + widget + "]";
    }

    @Override
    public void accept(LegacyVisitor visitor) {
        visitor.visit(this);
    }

}