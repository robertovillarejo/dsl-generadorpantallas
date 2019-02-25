package mx.gob.conacyt.generadorpantallas.legacy.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import mx.gob.conacyt.generadorpantallas.visitor.Element;
import mx.gob.conacyt.generadorpantallas.visitor.LegacyVisitor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "FECHA_MODIFICACION")
    private Timestamp fechaModificacion;

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

//    @ManyToMany
//    @JoinTable(name = "WIDGET_PANTALLA", joinColumns = @JoinColumn(name = "ID_PANTALLA", referencedColumnName = "ID_PANTALLA"), inverseJoinColumns = @JoinColumn(name = "ID_WIDGET", referencedColumnName = "ID_WIDGET"))
//    private List<Widget> widgets = new ArrayList<>();

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

    public Timestamp getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
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