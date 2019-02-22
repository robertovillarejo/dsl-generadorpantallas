package mx.gob.conacyt.generadorpantallas.legacy.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the CAMPO_WIDGET_EVENTO_UI database table.
 * 
 */
@Entity
@Table(name = "CAMPO_WIDGET_EVENTO_UI")
public class CampoWidgetEventoUi implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CAMPO_WIDGET_EVENTO_UI")
    private long idCampoWidgetEventoUi;

    @Column(name = "DEFINICION_TAREA")
    private String definicionTarea;

    @Column(name = "DESC_CAMPO_WIDGET_EVENTO_UI")
    private String descCampoWidgetEventoUi;

    @Column(name = "FECHA_ALTA")
    private Timestamp fechaAlta;

    @Column(name = "FECHA_MODIFICACION")
    private Timestamp fechaModificacion;

    @Column(name = "ID_CAMPO_WIDGET")
    private BigDecimal idCampoWidget;

    @Column(name = "ID_REPORTE")
    private BigDecimal idReporte;

    @Column(name = "IND_ESTATUS")
    private String indEstatus;

    @Column(name = "IND_MENSAJE")
    private String indMensaje;

    @Column(name = "USUARIO_ALTA")
    private BigDecimal usuarioAlta;

    @Column(name = "USUARIO_MODIFICACION")
    private BigDecimal usuarioModificacion;

    // bi-directional many-to-one association to EventoUi
    @ManyToOne
    @JoinColumn(name = "ID_EVENTO_UI")
    private EventoUi eventoUi;

    // bi-directional many-to-one association to Operacion
    @ManyToOne
    @JoinColumn(name = "ID_OPERACION")
    private Operacion operacion;

    // bi-directional many-to-one association to Widget
    @ManyToOne
    @JoinColumn(name = "ID_WIDGET_MODAL")
    private Widget widget;

    // bi-directional many-to-one association to SecuenciaFlujoPantalla
    @OneToMany(mappedBy = "campoWidgetEventoUi")
    private List<SecuenciaFlujoPantalla> secuenciaFlujoPantallas;

    public CampoWidgetEventoUi() {
    }

    public long getIdCampoWidgetEventoUi() {
        return this.idCampoWidgetEventoUi;
    }

    public void setIdCampoWidgetEventoUi(long idCampoWidgetEventoUi) {
        this.idCampoWidgetEventoUi = idCampoWidgetEventoUi;
    }

    public String getDefinicionTarea() {
        return this.definicionTarea;
    }

    public void setDefinicionTarea(String definicionTarea) {
        this.definicionTarea = definicionTarea;
    }

    public String getDescCampoWidgetEventoUi() {
        return this.descCampoWidgetEventoUi;
    }

    public void setDescCampoWidgetEventoUi(String descCampoWidgetEventoUi) {
        this.descCampoWidgetEventoUi = descCampoWidgetEventoUi;
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

    public BigDecimal getIdCampoWidget() {
        return this.idCampoWidget;
    }

    public void setIdCampoWidget(BigDecimal idCampoWidget) {
        this.idCampoWidget = idCampoWidget;
    }

    public BigDecimal getIdReporte() {
        return this.idReporte;
    }

    public void setIdReporte(BigDecimal idReporte) {
        this.idReporte = idReporte;
    }

    public String getIndEstatus() {
        return this.indEstatus;
    }

    public void setIndEstatus(String indEstatus) {
        this.indEstatus = indEstatus;
    }

    public String getIndMensaje() {
        return this.indMensaje;
    }

    public void setIndMensaje(String indMensaje) {
        this.indMensaje = indMensaje;
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

    public EventoUi getEventoUi() {
        return this.eventoUi;
    }

    public void setEventoUi(EventoUi eventoUi) {
        this.eventoUi = eventoUi;
    }

    public Operacion getOperacion() {
        return this.operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public Widget getWidget() {
        return this.widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public List<SecuenciaFlujoPantalla> getSecuenciaFlujoPantallas() {
        return this.secuenciaFlujoPantallas;
    }

    public void setSecuenciaFlujoPantallas(List<SecuenciaFlujoPantalla> secuenciaFlujoPantallas) {
        this.secuenciaFlujoPantallas = secuenciaFlujoPantallas;
    }

    public SecuenciaFlujoPantalla addSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
        getSecuenciaFlujoPantallas().add(secuenciaFlujoPantalla);
        secuenciaFlujoPantalla.setCampoWidgetEventoUi(this);

        return secuenciaFlujoPantalla;
    }

    public SecuenciaFlujoPantalla removeSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
        getSecuenciaFlujoPantallas().remove(secuenciaFlujoPantalla);
        secuenciaFlujoPantalla.setCampoWidgetEventoUi(null);

        return secuenciaFlujoPantalla;
    }

    @Override
    public String toString() {
        return "CampoWidgetEventoUi [idCampoWidgetEventoUi=" + idCampoWidgetEventoUi + ", definicionTarea="
                + definicionTarea + ", descCampoWidgetEventoUi=" + descCampoWidgetEventoUi + ", fechaAlta=" + fechaAlta
                + ", fechaModificacion=" + fechaModificacion + ", idCampoWidget=" + idCampoWidget + ", idReporte="
                + idReporte + ", indEstatus=" + indEstatus + ", indMensaje=" + indMensaje + ", usuarioAlta="
                + usuarioAlta + ", usuarioModificacion=" + usuarioModificacion + ", eventoUi=" + eventoUi
                + ", operacion=" + operacion + ", widget=" + widget + ", secuenciaFlujoPantallas="
                + secuenciaFlujoPantallas + "]";
    }
    
    

}