package generadorpantallas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the SECUENCIA_FLUJO_PANTALLA database table.
 * 
 */
@Entity
@Table(name="SECUENCIA_FLUJO_PANTALLA")
@NamedQuery(name="SecuenciaFlujoPantalla.findAll", query="SELECT s FROM SecuenciaFlujoPantalla s")
public class SecuenciaFlujoPantalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SECUENCIA_FLUJO_PANTALLA")
	private long idSecuenciaFlujoPantalla;

	@Column(name="DESC_SECUENCIA_FLUJO_PANTALLA")
	private String descSecuenciaFlujoPantalla;

	@Column(name="ESTATUS_EJECUCION")
	private String estatusEjecucion;

	@Column(name="FECHA_ALTA")
	private Timestamp fechaAlta;

	@Column(name="FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	@Column(name="ID_CAMPO_WIDGET_ACCION")
	private BigDecimal idCampoWidgetAccion;

	@Column(name="ID_PANTALLA_ACCION")
	private BigDecimal idPantallaAccion;

	@Column(name="IND_ESTATUS")
	private String indEstatus;

	private BigDecimal posicion;

	@Column(name="USUARIO_ALTA")
	private BigDecimal usuarioAlta;

	@Column(name="USUARIO_MODIFICACION")
	private BigDecimal usuarioModificacion;

	//bi-directional many-to-one association to CampoWidgetEventoUi
	@ManyToOne
	@JoinColumn(name="ID_CAMPO_WIDGET_EVENTO_UI")
	private CampoWidgetEventoUi campoWidgetEventoUi;

	//bi-directional many-to-one association to EventoUi
	@ManyToOne
	@JoinColumn(name="ID_EVENTO_UI")
	private EventoUi eventoUi;

	//bi-directional many-to-one association to FlujoPantalla
	@ManyToOne
	@JoinColumn(name="ID_FLUJO_PANTALLA")
	private FlujoPantalla flujoPantalla;

	//bi-directional many-to-one association to Pantalla
	@ManyToOne
	@JoinColumn(name="ID_PANTALLA")
	private Pantalla pantalla;

	//bi-directional many-to-one association to SecuenciaFlujoPantalla
	@ManyToOne
	@JoinColumn(name="ID_SECUENCIA_SIG")
	private SecuenciaFlujoPantalla secuenciaFlujoPantalla;

	//bi-directional many-to-one association to SecuenciaFlujoPantalla
	@OneToMany(mappedBy="secuenciaFlujoPantalla")
	private List<SecuenciaFlujoPantalla> secuenciaFlujoPantallas;

	//bi-directional many-to-one association to WidgetAccion
	@ManyToOne
	@JoinColumn(name="ID_WIDGET_ACCION")
	private WidgetAccion widgetAccion;

	public SecuenciaFlujoPantalla() {
	}

	public long getIdSecuenciaFlujoPantalla() {
		return this.idSecuenciaFlujoPantalla;
	}

	public void setIdSecuenciaFlujoPantalla(long idSecuenciaFlujoPantalla) {
		this.idSecuenciaFlujoPantalla = idSecuenciaFlujoPantalla;
	}

	public String getDescSecuenciaFlujoPantalla() {
		return this.descSecuenciaFlujoPantalla;
	}

	public void setDescSecuenciaFlujoPantalla(String descSecuenciaFlujoPantalla) {
		this.descSecuenciaFlujoPantalla = descSecuenciaFlujoPantalla;
	}

	public String getEstatusEjecucion() {
		return this.estatusEjecucion;
	}

	public void setEstatusEjecucion(String estatusEjecucion) {
		this.estatusEjecucion = estatusEjecucion;
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

	public BigDecimal getIdCampoWidgetAccion() {
		return this.idCampoWidgetAccion;
	}

	public void setIdCampoWidgetAccion(BigDecimal idCampoWidgetAccion) {
		this.idCampoWidgetAccion = idCampoWidgetAccion;
	}

	public BigDecimal getIdPantallaAccion() {
		return this.idPantallaAccion;
	}

	public void setIdPantallaAccion(BigDecimal idPantallaAccion) {
		this.idPantallaAccion = idPantallaAccion;
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

	public CampoWidgetEventoUi getCampoWidgetEventoUi() {
		return this.campoWidgetEventoUi;
	}

	public void setCampoWidgetEventoUi(CampoWidgetEventoUi campoWidgetEventoUi) {
		this.campoWidgetEventoUi = campoWidgetEventoUi;
	}

	public EventoUi getEventoUi() {
		return this.eventoUi;
	}

	public void setEventoUi(EventoUi eventoUi) {
		this.eventoUi = eventoUi;
	}

	public FlujoPantalla getFlujoPantalla() {
		return this.flujoPantalla;
	}

	public void setFlujoPantalla(FlujoPantalla flujoPantalla) {
		this.flujoPantalla = flujoPantalla;
	}

	public Pantalla getPantalla() {
		return this.pantalla;
	}

	public void setPantalla(Pantalla pantalla) {
		this.pantalla = pantalla;
	}

	public SecuenciaFlujoPantalla getSecuenciaFlujoPantalla() {
		return this.secuenciaFlujoPantalla;
	}

	public void setSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
		this.secuenciaFlujoPantalla = secuenciaFlujoPantalla;
	}

	public List<SecuenciaFlujoPantalla> getSecuenciaFlujoPantallas() {
		return this.secuenciaFlujoPantallas;
	}

	public void setSecuenciaFlujoPantallas(List<SecuenciaFlujoPantalla> secuenciaFlujoPantallas) {
		this.secuenciaFlujoPantallas = secuenciaFlujoPantallas;
	}

	public SecuenciaFlujoPantalla addSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
		getSecuenciaFlujoPantallas().add(secuenciaFlujoPantalla);
		secuenciaFlujoPantalla.setSecuenciaFlujoPantalla(this);

		return secuenciaFlujoPantalla;
	}

	public SecuenciaFlujoPantalla removeSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
		getSecuenciaFlujoPantallas().remove(secuenciaFlujoPantalla);
		secuenciaFlujoPantalla.setSecuenciaFlujoPantalla(null);

		return secuenciaFlujoPantalla;
	}

	public WidgetAccion getWidgetAccion() {
		return this.widgetAccion;
	}

	public void setWidgetAccion(WidgetAccion widgetAccion) {
		this.widgetAccion = widgetAccion;
	}

}