package generadorpantallas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CAT_TIPO_WIDGET database table.
 * 
 */
@Entity
@Table(name="CAT_TIPO_WIDGET")
@NamedQuery(name="CatTipoWidget.findAll", query="SELECT c FROM CatTipoWidget c")
public class CatTipoWidget implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPO_WIDGET")
	private long idTipoWidget;

	@Column(name="CVE_TIPO_WIDGET")
	private String cveTipoWidget;

	@Column(name="DESC_TIPO_WIDGET")
	private String descTipoWidget;

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

	//bi-directional many-to-one association to Widget
	@OneToMany(mappedBy="catTipoWidget")
	private List<Widget> widgets;

	public CatTipoWidget() {
	}

	public long getIdTipoWidget() {
		return this.idTipoWidget;
	}

	public void setIdTipoWidget(long idTipoWidget) {
		this.idTipoWidget = idTipoWidget;
	}

	public String getCveTipoWidget() {
		return this.cveTipoWidget;
	}

	public void setCveTipoWidget(String cveTipoWidget) {
		this.cveTipoWidget = cveTipoWidget;
	}

	public String getDescTipoWidget() {
		return this.descTipoWidget;
	}

	public void setDescTipoWidget(String descTipoWidget) {
		this.descTipoWidget = descTipoWidget;
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

	public List<Widget> getWidgets() {
		return this.widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}

	public Widget addWidget(Widget widget) {
		getWidgets().add(widget);
		widget.setCatTipoWidget(this);

		return widget;
	}

	public Widget removeWidget(Widget widget) {
		getWidgets().remove(widget);
		widget.setCatTipoWidget(null);

		return widget;
	}

}