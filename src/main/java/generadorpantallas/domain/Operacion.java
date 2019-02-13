package generadorpantallas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the OPERACION database table.
 * 
 */
@Entity
@NamedQuery(name="Operacion.findAll", query="SELECT o FROM Operacion o")
public class Operacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_OPERACION")
	private long idOperacion;

	@Column(name="CVE_OPERACION")
	private String cveOperacion;

	@Column(name="DESC_OPERACION")
	private String descOperacion;

	@Column(name="FECHA_ALTA")
	private Timestamp fechaAlta;

	@Column(name="FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	@Column(name="HABILITAR_REST")
	private String habilitarRest;

	@Column(name="IND_ESTATUS")
	private String indEstatus;

	@Column(name="USUARIO_ALTA")
	private BigDecimal usuarioAlta;

	@Column(name="USUARIO_MODIFICACION")
	private BigDecimal usuarioModificacion;

	//bi-directional many-to-one association to CampoWidgetEventoUi
	@OneToMany(mappedBy="operacion")
	private List<CampoWidgetEventoUi> campoWidgetEventoUis;

	//bi-directional many-to-one association to CatServicio
	@ManyToOne
	@JoinColumn(name="ID_SERVICIO")
	private CatServicio catServicio;

	//bi-directional many-to-one association to PantallaEventoUi
	@OneToMany(mappedBy="operacion")
	private List<PantallaEventoUi> pantallaEventoUis;

	//bi-directional many-to-one association to WidgetAccion
	@OneToMany(mappedBy="operacion")
	private List<WidgetAccion> widgetAccions;

	public Operacion() {
	}

	public long getIdOperacion() {
		return this.idOperacion;
	}

	public void setIdOperacion(long idOperacion) {
		this.idOperacion = idOperacion;
	}

	public String getCveOperacion() {
		return this.cveOperacion;
	}

	public void setCveOperacion(String cveOperacion) {
		this.cveOperacion = cveOperacion;
	}

	public String getDescOperacion() {
		return this.descOperacion;
	}

	public void setDescOperacion(String descOperacion) {
		this.descOperacion = descOperacion;
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

	public String getHabilitarRest() {
		return this.habilitarRest;
	}

	public void setHabilitarRest(String habilitarRest) {
		this.habilitarRest = habilitarRest;
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

	public List<CampoWidgetEventoUi> getCampoWidgetEventoUis() {
		return this.campoWidgetEventoUis;
	}

	public void setCampoWidgetEventoUis(List<CampoWidgetEventoUi> campoWidgetEventoUis) {
		this.campoWidgetEventoUis = campoWidgetEventoUis;
	}

	public CampoWidgetEventoUi addCampoWidgetEventoUi(CampoWidgetEventoUi campoWidgetEventoUi) {
		getCampoWidgetEventoUis().add(campoWidgetEventoUi);
		campoWidgetEventoUi.setOperacion(this);

		return campoWidgetEventoUi;
	}

	public CampoWidgetEventoUi removeCampoWidgetEventoUi(CampoWidgetEventoUi campoWidgetEventoUi) {
		getCampoWidgetEventoUis().remove(campoWidgetEventoUi);
		campoWidgetEventoUi.setOperacion(null);

		return campoWidgetEventoUi;
	}

	public CatServicio getCatServicio() {
		return this.catServicio;
	}

	public void setCatServicio(CatServicio catServicio) {
		this.catServicio = catServicio;
	}

	public List<PantallaEventoUi> getPantallaEventoUis() {
		return this.pantallaEventoUis;
	}

	public void setPantallaEventoUis(List<PantallaEventoUi> pantallaEventoUis) {
		this.pantallaEventoUis = pantallaEventoUis;
	}

	public PantallaEventoUi addPantallaEventoUi(PantallaEventoUi pantallaEventoUi) {
		getPantallaEventoUis().add(pantallaEventoUi);
		pantallaEventoUi.setOperacion(this);

		return pantallaEventoUi;
	}

	public PantallaEventoUi removePantallaEventoUi(PantallaEventoUi pantallaEventoUi) {
		getPantallaEventoUis().remove(pantallaEventoUi);
		pantallaEventoUi.setOperacion(null);

		return pantallaEventoUi;
	}

	public List<WidgetAccion> getWidgetAccions() {
		return this.widgetAccions;
	}

	public void setWidgetAccions(List<WidgetAccion> widgetAccions) {
		this.widgetAccions = widgetAccions;
	}

	public WidgetAccion addWidgetAccion(WidgetAccion widgetAccion) {
		getWidgetAccions().add(widgetAccion);
		widgetAccion.setOperacion(this);

		return widgetAccion;
	}

	public WidgetAccion removeWidgetAccion(WidgetAccion widgetAccion) {
		getWidgetAccions().remove(widgetAccion);
		widgetAccion.setOperacion(null);

		return widgetAccion;
	}

}