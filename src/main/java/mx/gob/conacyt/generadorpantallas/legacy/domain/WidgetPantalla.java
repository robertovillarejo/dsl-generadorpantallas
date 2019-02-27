package mx.gob.conacyt.generadorpantallas.legacy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import mx.gob.conacyt.generadorpantallas.visitor.Element;
import mx.gob.conacyt.generadorpantallas.visitor.LegacyVisitor;

/**
 * The persistent class for the WIDGET_PANTALLA database table.
 * 
 */
@Entity
@Table(name = "WIDGET_PANTALLA")
public class WidgetPantalla implements Serializable, Element {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_WIDGET_PANTALLA")
    private Long idWidgetPantalla;

    @Column(name = "DESC_WIDGET_PANTALLA")
    private String descWidgetPantalla;

    @Column(name = "FECHA_ALTA")
    private Timestamp fechaAlta;

    @Column(name = "FECHA_MODIFICACION")
    private Timestamp fechaModificacion;

    @Column(name = "IND_ESTATUS")
    private String indEstatus;

    private BigDecimal posicion;

    @Column(name = "USUARIO_ALTA")
    private BigDecimal usuarioAlta;

    @Column(name = "USUARIO_MODIFICACION")
    private BigDecimal usuarioModificacion;

    // bi-directional many-to-one association to Pantalla
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_PANTALLA")
    private Pantalla pantalla;

    // bi-directional many-to-one association to Widget
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_WIDGET")
    private Widget widget;

    // bi-directional many-to-one association to WidgetPantalla
//    @ManyToOne
//    @JoinColumn(name = "WIGDET_PANTALLA_PADRE")
    @Transient
    private WidgetPantalla widgetPantalla;

    // bi-directional many-to-one association to WidgetPantalla
//    @OneToMany(mappedBy = "widgetPantalla")
    @Transient
    private List<WidgetPantalla> widgetPantallas;

    public WidgetPantalla() {
    }

    public Long getIdWidgetPantalla() {
        return this.idWidgetPantalla;
    }

    public void setIdWidgetPantalla(Long idWidgetPantalla) {
        this.idWidgetPantalla = idWidgetPantalla;
    }

    public String getDescWidgetPantalla() {
        return this.descWidgetPantalla;
    }

    public void setDescWidgetPantalla(String descWidgetPantalla) {
        this.descWidgetPantalla = descWidgetPantalla;
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

    public String getIndEstatus() {
        return this.indEstatus;
    }

    public void setIndEstatus(String indEstatus) {
        this.indEstatus = indEstatus;
    }

    public BigDecimal getPosicion() {
        return this.posicion;
    }

    public void setPosicion(BigDecimal posicion) {
        this.posicion = posicion;
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

    public Pantalla getPantalla() {
        return this.pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public Widget getWidget() {
        return this.widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public WidgetPantalla getWidgetPantalla() {
        return this.widgetPantalla;
    }

    public void setWidgetPantalla(WidgetPantalla widgetPantalla) {
        this.widgetPantalla = widgetPantalla;
    }

    public List<WidgetPantalla> getWidgetPantallas() {
        return this.widgetPantallas;
    }

    public void setWidgetPantallas(List<WidgetPantalla> widgetPantallas) {
        this.widgetPantallas = widgetPantallas;
    }

    public WidgetPantalla addWidgetPantalla(WidgetPantalla widgetPantalla) {
        getWidgetPantallas().add(widgetPantalla);
        widgetPantalla.setWidgetPantalla(this);

        return widgetPantalla;
    }

    public WidgetPantalla removeWidgetPantalla(WidgetPantalla widgetPantalla) {
        getWidgetPantallas().remove(widgetPantalla);
        widgetPantalla.setWidgetPantalla(null);

        return widgetPantalla;
    }

    @Override
    public void accept(LegacyVisitor visitor) {
        visitor.visit(this);
    }

}