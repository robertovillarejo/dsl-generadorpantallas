package mx.gob.conacyt.generadorpantallas.legacy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import mx.gob.conacyt.generadorpantallas.visitor.Element;
import mx.gob.conacyt.generadorpantallas.visitor.LegacyVisitor;

/**
 * The persistent class for the PANTALLA database table.
 * 
 */
@Entity
public class Pantalla implements Serializable, Element {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "prefixGenerator", strategy = "mx.gob.conacyt.generadorpantallas.legacy.identifiergenerators.PrefixBasedGenerator")
    @GeneratedValue(generator = "prefixGenerator", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PANTALLA")
    private Long idPantalla;

    @Column(name = "CVE_PANTALLA")
    private String cvePantalla;

    @Column(name = "DESC_PANTALLA")
    private String descPantalla;

    @Column(name = "FECHA_ALTA")
    private Timestamp fechaAlta;

    @LastModifiedDate
    @Column(name = "FECHA_MODIFICACION")
    private Date fechaModificacion;

    @Column(name = "ID_TIPO_PANTALLA")
    private BigDecimal idTipoPantalla;

    @Column(name = "IND_ESTATUS")
    private String indEstatus;

    @Column(name = "USUARIO_ALTA")
    private BigDecimal usuarioAlta;

    @Column(name = "USUARIO_MODIFICACION")
    private BigDecimal usuarioModificacion;

    // bi-directional many-to-one association to PantallaEventoUi
    @JsonIgnore
    @OneToMany(mappedBy = "pantalla")
    private List<PantallaEventoUi> pantallaEventoUis = new ArrayList<>();

    // bi-directional many-to-one association to SecuenciaFlujoPantalla
    @JsonIgnore
    @OneToMany(mappedBy = "pantalla")
    private List<SecuenciaFlujoPantalla> secuenciaFlujoPantallas = new ArrayList<>();

    // bi-directional many-to-one association to WidgetPantalla
    @OneToMany(mappedBy = "pantalla")
    private List<WidgetPantalla> widgetPantallas = new ArrayList<>();

    public Pantalla() {
    }

    public Long getIdPantalla() {
        return this.idPantalla;
    }

    public void setIdPantalla(Long idPantalla) {
        this.idPantalla = idPantalla;
    }

    public String getCvePantalla() {
        return this.cvePantalla;
    }

    public void setCvePantalla(String cvePantalla) {
        this.cvePantalla = cvePantalla;
    }

    public String getDescPantalla() {
        return this.descPantalla;
    }

    public void setDescPantalla(String descPantalla) {
        this.descPantalla = descPantalla;
    }

    public Timestamp getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public BigDecimal getIdTipoPantalla() {
        return this.idTipoPantalla;
    }

    public void setIdTipoPantalla(BigDecimal idTipoPantalla) {
        this.idTipoPantalla = idTipoPantalla;
    }

    public String getIndEstatus() {
        return this.indEstatus;
    }

    public void setIndEstatus(String indEstatus) {
        this.indEstatus = indEstatus;
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

    public List<PantallaEventoUi> getPantallaEventoUis() {
        return this.pantallaEventoUis;
    }

    public void setPantallaEventoUis(List<PantallaEventoUi> pantallaEventoUis) {
        this.pantallaEventoUis = pantallaEventoUis;
    }

    public PantallaEventoUi addPantallaEventoUi(PantallaEventoUi pantallaEventoUi) {
        getPantallaEventoUis().add(pantallaEventoUi);
        pantallaEventoUi.setPantalla(this);

        return pantallaEventoUi;
    }

    public PantallaEventoUi removePantallaEventoUi(PantallaEventoUi pantallaEventoUi) {
        getPantallaEventoUis().remove(pantallaEventoUi);
        pantallaEventoUi.setPantalla(null);

        return pantallaEventoUi;
    }

    public List<SecuenciaFlujoPantalla> getSecuenciaFlujoPantallas() {
        return this.secuenciaFlujoPantallas;
    }

    public void setSecuenciaFlujoPantallas(List<SecuenciaFlujoPantalla> secuenciaFlujoPantallas) {
        this.secuenciaFlujoPantallas = secuenciaFlujoPantallas;
    }

    public SecuenciaFlujoPantalla addSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
        getSecuenciaFlujoPantallas().add(secuenciaFlujoPantalla);
        secuenciaFlujoPantalla.setPantalla(this);

        return secuenciaFlujoPantalla;
    }

    public SecuenciaFlujoPantalla removeSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
        getSecuenciaFlujoPantallas().remove(secuenciaFlujoPantalla);
        secuenciaFlujoPantalla.setPantalla(null);

        return secuenciaFlujoPantalla;
    }

    public List<WidgetPantalla> getWidgetPantallas() {
        return this.widgetPantallas;
    }

    public void setWidgetPantallas(List<WidgetPantalla> widgetPantallas) {
        this.widgetPantallas = widgetPantallas;
    }

    public WidgetPantalla addWidgetPantalla(WidgetPantalla widgetPantalla) {
        getWidgetPantallas().add(widgetPantalla);
        widgetPantalla.setPantalla(this);

        return widgetPantalla;
    }

    public WidgetPantalla removeWidgetPantalla(WidgetPantalla widgetPantalla) {
        getWidgetPantallas().remove(widgetPantalla);
        widgetPantalla.setPantalla(null);

        return widgetPantalla;
    }

    @Override
    public void accept(LegacyVisitor visitor) {
        visitor.visit(this);
    }

//    public List<Widget> getWidgets() {
//        return widgets;
//    }
//
//    public void setWidgets(List<Widget> widgets) {
//        this.widgets = widgets;
//    }
}