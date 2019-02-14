package mx.gob.conacyt.generadorpantallas.domain.legacy;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CAT_ACCION database table.
 * 
 */
@Entity
@Table(name="CAT_ACCION")
@NamedQuery(name="CatAccion.findAll", query="SELECT c FROM CatAccion c")
public class CatAccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ACCION")
	private long idAccion;

	private String confirmacion;

	@Column(name="CSS_CLASS")
	private String cssClass;

	@Column(name="CVE_ACCION")
	private String cveAccion;

	@Column(name="DESC_ACCION")
	private String descAccion;

	@Column(name="FECHA_ALTA")
	private Timestamp fechaAlta;

	@Column(name="FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	@Column(name="ICON_CLASS")
	private String iconClass;

	@Column(name="IND_ESTATUS")
	private String indEstatus;

	@Column(name="IND_SEGURIDAD")
	private String indSeguridad;

	@Column(name="USUARIO_ALTA")
	private BigDecimal usuarioAlta;

	@Column(name="USUARIO_MODIFICACION")
	private BigDecimal usuarioModificacion;

	//bi-directional many-to-one association to WidgetAccion
	@OneToMany(mappedBy="catAccion")
	private List<WidgetAccion> widgetAccions;

	public CatAccion() {
	}

	public long getIdAccion() {
		return this.idAccion;
	}

	public void setIdAccion(long idAccion) {
		this.idAccion = idAccion;
	}

	public String getConfirmacion() {
		return this.confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}

	public String getCssClass() {
		return this.cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getCveAccion() {
		return this.cveAccion;
	}

	public void setCveAccion(String cveAccion) {
		this.cveAccion = cveAccion;
	}

	public String getDescAccion() {
		return this.descAccion;
	}

	public void setDescAccion(String descAccion) {
		this.descAccion = descAccion;
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

	public String getIconClass() {
		return this.iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getIndEstatus() {
		return this.indEstatus;
	}

	public void setIndEstatus(String indEstatus) {
		this.indEstatus = indEstatus;
	}

	public String getIndSeguridad() {
		return this.indSeguridad;
	}

	public void setIndSeguridad(String indSeguridad) {
		this.indSeguridad = indSeguridad;
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

	public List<WidgetAccion> getWidgetAccions() {
		return this.widgetAccions;
	}

	public void setWidgetAccions(List<WidgetAccion> widgetAccions) {
		this.widgetAccions = widgetAccions;
	}

	public WidgetAccion addWidgetAccion(WidgetAccion widgetAccion) {
		getWidgetAccions().add(widgetAccion);
		widgetAccion.setCatAccion(this);

		return widgetAccion;
	}

	public WidgetAccion removeWidgetAccion(WidgetAccion widgetAccion) {
		getWidgetAccions().remove(widgetAccion);
		widgetAccion.setCatAccion(null);

		return widgetAccion;
	}

}