package generadorpantallas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the EVENTO_UI database table.
 * 
 */
@Entity
@Table(name="EVENTO_UI")
@NamedQuery(name="EventoUi.findAll", query="SELECT e FROM EventoUi e")
public class EventoUi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_EVENTO_UI")
	private long idEventoUi;

	@Column(name="CVE_EVENTO_UI")
	private String cveEventoUi;

	@Column(name="DESC_EVENTO_UI")
	private String descEventoUi;

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

	//bi-directional many-to-one association to CampoWidgetEventoUi
	@OneToMany(mappedBy="eventoUi")
	private List<CampoWidgetEventoUi> campoWidgetEventoUis;

	//bi-directional many-to-one association to PantallaEventoUi
	@OneToMany(mappedBy="eventoUi")
	private List<PantallaEventoUi> pantallaEventoUis;

	//bi-directional many-to-one association to SecuenciaFlujoPantalla
	@OneToMany(mappedBy="eventoUi")
	private List<SecuenciaFlujoPantalla> secuenciaFlujoPantallas;

	//bi-directional many-to-one association to WidgetAccion
	@OneToMany(mappedBy="eventoUi")
	private List<WidgetAccion> widgetAccions;

	public EventoUi() {
	}

	public long getIdEventoUi() {
		return this.idEventoUi;
	}

	public void setIdEventoUi(long idEventoUi) {
		this.idEventoUi = idEventoUi;
	}

	public String getCveEventoUi() {
		return this.cveEventoUi;
	}

	public void setCveEventoUi(String cveEventoUi) {
		this.cveEventoUi = cveEventoUi;
	}

	public String getDescEventoUi() {
		return this.descEventoUi;
	}

	public void setDescEventoUi(String descEventoUi) {
		this.descEventoUi = descEventoUi;
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

	public List<CampoWidgetEventoUi> getCampoWidgetEventoUis() {
		return this.campoWidgetEventoUis;
	}

	public void setCampoWidgetEventoUis(List<CampoWidgetEventoUi> campoWidgetEventoUis) {
		this.campoWidgetEventoUis = campoWidgetEventoUis;
	}

	public CampoWidgetEventoUi addCampoWidgetEventoUi(CampoWidgetEventoUi campoWidgetEventoUi) {
		getCampoWidgetEventoUis().add(campoWidgetEventoUi);
		campoWidgetEventoUi.setEventoUi(this);

		return campoWidgetEventoUi;
	}

	public CampoWidgetEventoUi removeCampoWidgetEventoUi(CampoWidgetEventoUi campoWidgetEventoUi) {
		getCampoWidgetEventoUis().remove(campoWidgetEventoUi);
		campoWidgetEventoUi.setEventoUi(null);

		return campoWidgetEventoUi;
	}

	public List<PantallaEventoUi> getPantallaEventoUis() {
		return this.pantallaEventoUis;
	}

	public void setPantallaEventoUis(List<PantallaEventoUi> pantallaEventoUis) {
		this.pantallaEventoUis = pantallaEventoUis;
	}

	public PantallaEventoUi addPantallaEventoUi(PantallaEventoUi pantallaEventoUi) {
		getPantallaEventoUis().add(pantallaEventoUi);
		pantallaEventoUi.setEventoUi(this);

		return pantallaEventoUi;
	}

	public PantallaEventoUi removePantallaEventoUi(PantallaEventoUi pantallaEventoUi) {
		getPantallaEventoUis().remove(pantallaEventoUi);
		pantallaEventoUi.setEventoUi(null);

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
		secuenciaFlujoPantalla.setEventoUi(this);

		return secuenciaFlujoPantalla;
	}

	public SecuenciaFlujoPantalla removeSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
		getSecuenciaFlujoPantallas().remove(secuenciaFlujoPantalla);
		secuenciaFlujoPantalla.setEventoUi(null);

		return secuenciaFlujoPantalla;
	}

	public List<WidgetAccion> getWidgetAccions() {
		return this.widgetAccions;
	}

	public void setWidgetAccions(List<WidgetAccion> widgetAccions) {
		this.widgetAccions = widgetAccions;
	}

	public WidgetAccion addWidgetAccion(WidgetAccion widgetAccion) {
		getWidgetAccions().add(widgetAccion);
		widgetAccion.setEventoUi(this);

		return widgetAccion;
	}

	public WidgetAccion removeWidgetAccion(WidgetAccion widgetAccion) {
		getWidgetAccions().remove(widgetAccion);
		widgetAccion.setEventoUi(null);

		return widgetAccion;
	}

}