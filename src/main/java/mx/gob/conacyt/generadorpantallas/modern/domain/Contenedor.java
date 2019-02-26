package mx.gob.conacyt.generadorpantallas.modern.domain;

import java.util.ArrayList;
import java.util.List;

public class Contenedor extends AbstractAuditing {

    private Long id;

    private List<Campo> campos = new ArrayList<>();

    private String configuracion;

    private String clave;

    private String descripcion;

    private String ngClass;

    private String ngIf;

    private String ngShow;

    private String ngStyle;

    private String ngRepeat;

    private Integer posicion;

    private Integer tamanio;

    public String getTipo() {
        return "form";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    public String getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(String configuracion) {
        this.configuracion = configuracion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNgClass() {
        return ngClass;
    }

    public void setNgClass(String ngClass) {
        this.ngClass = ngClass;
    }

    public String getNgIf() {
        return ngIf;
    }

    public void setNgIf(String ngIf) {
        this.ngIf = ngIf;
    }

    public String getNgShow() {
        return ngShow;
    }

    public void setNgShow(String ngShow) {
        this.ngShow = ngShow;
    }

    public String getNgStyle() {
        return ngStyle;
    }

    public void setNgStyle(String ngStyle) {
        this.ngStyle = ngStyle;
    }

    public String getNgRepeat() {
        return ngRepeat;
    }

    public void setNgRepeat(String ngRepeat) {
        this.ngRepeat = ngRepeat;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Contenedor [id=" + id + ", campos=" + campos + ", configuracion=" + configuracion + ", clave=" + clave
                + ", descripcion=" + descripcion + ", ngClass=" + ngClass + ", ngIf=" + ngIf + ", ngShow=" + ngShow
                + ", ngStyle=" + ngStyle + ", ngRepeat=" + ngRepeat + ", posicion=" + posicion + ", tamanio=" + tamanio
                + "]";
    }

}
