package generadorpantallas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the WIDGET_PANTALLA database table.
 * 
 */
@Entity
@Table(name="WIDGET_PANTALLA")
@NamedQuery(name="WidgetPantalla.findAll", query="SELECT w FROM WidgetPantalla w")
public class WidgetPantalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_WIDGET_PANTALLA")
	private long idWidgetPantalla;

	@Column(name="DESC_WIDGET_PANTALLA")
	private String descWidgetPantalla;

	@Column(name="FECHA_ALTA")
	private Timestamp fechaAlta;

	@Column(name="FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	@Column(name="IND_ESTATUS")
	private String indEstatus;

	private BigDecimal posicion;

	@Column(name="USUARIO_ALTA")
	private BigDecimal usuarioAlta;

	@Column(name="USUARIO_MODIFICACION")
	private BigDecimal usuarioModificacion;

	//bi-directional many-to-one association to Pantalla
	@ManyToOne
	@JoinColumn(name="ID_PANTALLA")
	private Pantalla pantalla;

	//bi-directional many-to-one association to Widget
	@ManyToOne
	@JoinColumn(name="ID_WIDGET")
	private Widget widget;

	//bi-directional many-to-one association to WidgetPantalla
	@ManyToOne
	@JoinColumn(name="WIGDET_PANTALLA_PADRE")
	private WidgetPantalla widgetPantalla;

	//bi-directional many-to-one association to WidgetPantalla
	@OneToMany(mappedBy="widgetPantalla")
	private List<WidgetPantalla> widgetPantallas;

	public WidgetPantalla() {
	}

	public long getIdWidgetPantalla() {
		return this.idWidgetPantalla;
	}

	public void setIdWidgetPantalla(long idWidgetPantalla) {
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

}