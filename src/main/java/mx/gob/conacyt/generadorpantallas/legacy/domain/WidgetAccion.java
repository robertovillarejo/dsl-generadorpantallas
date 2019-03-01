package mx.gob.conacyt.generadorpantallas.legacy.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the WIDGET_ACCION database table.
 * 
 */
@Entity
@Table(name="WIDGET_ACCION")
public class WidgetAccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_WIDGET_ACCION")
	private long idWidgetAccion;

	@Column(name="DEFINICION_TAREA")
	private String definicionTarea;

	@Column(name="FECHA_ALTA")
	private Timestamp fechaAlta;

	@Column(name="FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	private String habilitado;

	@Column(name="ID_REPORTE")
	private BigDecimal idReporte;

	@Column(name="IND_ESTATUS")
	private String indEstatus;

	@Column(name="IND_MENSAJE")
	private String indMensaje;

	@Column(name="MENSAJE_ACCION")
	private String mensajeAccion;

	@Column(name="NG_IF")
	private String ngIf;

	@Column(name="NG_MODEL")
	private String ngModel;

	@Column(name="NG_SHOW")
	private String ngShow;

	private String nombre;

	private BigDecimal posicion;

	@Column(name="USUARIO_ALTA")
	private BigDecimal usuarioAlta;

	@Column(name="USUARIO_MODIFICACION")
	private BigDecimal usuarioModificacion;

	//bi-directional many-to-one association to SecuenciaFlujoPantalla
//	@OneToMany(mappedBy="widgetAccion")
	@Transient
	private List<SecuenciaFlujoPantalla> secuenciaFlujoPantallas;

	//bi-directional many-to-one association to CatAccion
	@ManyToOne
	@JoinColumn(name="ID_ACCION")
	private CatAccion catAccion;

	//bi-directional many-to-one association to EventoUi
	@ManyToOne
	@JoinColumn(name="ID_EVENTO_UI")
	private EventoUi eventoUi;

	//bi-directional many-to-one association to Operacion
	@ManyToOne
	@JoinColumn(name="ID_OPERACION")
	private Operacion operacion;

	//bi-directional many-to-one association to Widget
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_WIDGET")
	private Widget widget1;

	//bi-directional many-to-one association to Widget
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_WIDGET_MODAL")
	private Widget widget2;

	public WidgetAccion() {
	}

	public long getIdWidgetAccion() {
		return this.idWidgetAccion;
	}

	public void setIdWidgetAccion(long idWidgetAccion) {
		this.idWidgetAccion = idWidgetAccion;
	}

	public String getDefinicionTarea() {
		return this.definicionTarea;
	}

	public void setDefinicionTarea(String definicionTarea) {
		this.definicionTarea = definicionTarea;
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

	public String getHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
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

	public String getMensajeAccion() {
		return this.mensajeAccion;
	}

	public void setMensajeAccion(String mensajeAccion) {
		this.mensajeAccion = mensajeAccion;
	}

	public String getNgIf() {
		return this.ngIf;
	}

	public void setNgIf(String ngIf) {
		this.ngIf = ngIf;
	}

	public String getNgModel() {
		return this.ngModel;
	}

	public void setNgModel(String ngModel) {
		this.ngModel = ngModel;
	}

	public String getNgShow() {
		return this.ngShow;
	}

	public void setNgShow(String ngShow) {
		this.ngShow = ngShow;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<SecuenciaFlujoPantalla> getSecuenciaFlujoPantallas() {
		return this.secuenciaFlujoPantallas;
	}

	public void setSecuenciaFlujoPantallas(List<SecuenciaFlujoPantalla> secuenciaFlujoPantallas) {
		this.secuenciaFlujoPantallas = secuenciaFlujoPantallas;
	}

	public SecuenciaFlujoPantalla addSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
		getSecuenciaFlujoPantallas().add(secuenciaFlujoPantalla);
		secuenciaFlujoPantalla.setWidgetAccion(this);

		return secuenciaFlujoPantalla;
	}

	public SecuenciaFlujoPantalla removeSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
		getSecuenciaFlujoPantallas().remove(secuenciaFlujoPantalla);
		secuenciaFlujoPantalla.setWidgetAccion(null);

		return secuenciaFlujoPantalla;
	}

	public CatAccion getCatAccion() {
		return this.catAccion;
	}

	public void setCatAccion(CatAccion catAccion) {
		this.catAccion = catAccion;
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

	public Widget getWidget1() {
		return this.widget1;
	}

	public void setWidget1(Widget widget1) {
		this.widget1 = widget1;
	}

	public Widget getWidget2() {
		return this.widget2;
	}

	public void setWidget2(Widget widget2) {
		this.widget2 = widget2;
	}

}