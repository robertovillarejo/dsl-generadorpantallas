package mx.gob.conacyt.generadorpantallas.legacy.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the PANTALLA_EVENTO_UI database table.
 * 
 */
@Entity
@Table(name="PANTALLA_EVENTO_UI")
public class PantallaEventoUi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PANTALLA_EVENTO_UI")
	private long idPantallaEventoUi;

	@Column(name="DESC_PANTALLA_EVENTO_UI")
	private String descPantallaEventoUi;

	@Column(name="FECHA_ALTA")
	private Timestamp fechaAlta;

	@Column(name="FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	@Column(name="IND_ESTATUS")
	private String indEstatus;

	@Column(name="USUARIO_ALTA")
	private BigDecimal usuarioAlta;

	@Column(name="USUARIO_MODIFICACION")
	private BigDecimal usuarioModificacion;

	//bi-directional many-to-one association to EventoUi
	@ManyToOne
	@JoinColumn(name="ID_EVENTO_UI")
	private EventoUi eventoUi;

	//bi-directional many-to-one association to Operacion
	@ManyToOne
	@JoinColumn(name="ID_OPERACION")
	private Operacion operacion;

	//bi-directional many-to-one association to Pantalla
	@ManyToOne
	@JoinColumn(name="ID_PANTALLA")
	private Pantalla pantalla;

	//bi-directional many-to-one association to Widget
	@ManyToOne
	@JoinColumn(name="ID_WIDGET_MODAL")
	private Widget widget;

	public PantallaEventoUi() {
	}

	public long getIdPantallaEventoUi() {
		return this.idPantallaEventoUi;
	}

	public void setIdPantallaEventoUi(long idPantallaEventoUi) {
		this.idPantallaEventoUi = idPantallaEventoUi;
	}

	public String getDescPantallaEventoUi() {
		return this.descPantallaEventoUi;
	}

	public void setDescPantallaEventoUi(String descPantallaEventoUi) {
		this.descPantallaEventoUi = descPantallaEventoUi;
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

}