package generadorpantallas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CAT_CONTROL_UI database table.
 * 
 */
@Entity
@Table(name="CAT_CONTROL_UI")
@NamedQuery(name="CatControlUi.findAll", query="SELECT c FROM CatControlUi c")
public class CatControlUi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CONTROL_UI")
	private long idControlUi;

	@Column(name="CVE_CONTROL_UI")
	private String cveControlUi;

	@Column(name="DESC_CONTROL_UI")
	private String descControlUi;

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

	//bi-directional many-to-one association to CampoWidget
	@OneToMany(mappedBy="catControlUi")
	private List<CampoWidget> campoWidgets;

	public CatControlUi() {
	}

	public long getIdControlUi() {
		return this.idControlUi;
	}

	public void setIdControlUi(long idControlUi) {
		this.idControlUi = idControlUi;
	}

	public String getCveControlUi() {
		return this.cveControlUi;
	}

	public void setCveControlUi(String cveControlUi) {
		this.cveControlUi = cveControlUi;
	}

	public String getDescControlUi() {
		return this.descControlUi;
	}

	public void setDescControlUi(String descControlUi) {
		this.descControlUi = descControlUi;
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

	public List<CampoWidget> getCampoWidgets() {
		return this.campoWidgets;
	}

	public void setCampoWidgets(List<CampoWidget> campoWidgets) {
		this.campoWidgets = campoWidgets;
	}

	public CampoWidget addCampoWidget(CampoWidget campoWidget) {
		getCampoWidgets().add(campoWidget);
		campoWidget.setCatControlUi(this);

		return campoWidget;
	}

	public CampoWidget removeCampoWidget(CampoWidget campoWidget) {
		getCampoWidgets().remove(campoWidget);
		campoWidget.setCatControlUi(null);

		return campoWidget;
	}

}