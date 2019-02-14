package mx.gob.conacyt.generadorpantallas.domain.legacy;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the WIDGET database table.
 * 
 */
@Entity
@NamedQuery(name="Widget.findAll", query="SELECT w FROM Widget w")
public class Widget implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_WIDGET")
	private long idWidget;

	private String configuration;

	@Column(name="CVE_WIDGET")
	private String cveWidget;

	@Column(name="DESC_WIDGET")
	private String descWidget;

	@Column(name="FECHA_ALTA")
	private Timestamp fechaAlta;

	@Column(name="FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	@Column(name="ID_AREA_TEMATICA")
	private BigDecimal idAreaTematica;

	@Column(name="IND_ESTATUS")
	private String indEstatus;

	@Column(name="NG_CLASS")
	private String ngClass;

	@Column(name="NG_IF")
	private String ngIf;

	@Column(name="NG_SHOW")
	private String ngShow;

	@Column(name="NG_STYLE")
	private String ngStyle;

	private String ngrepeat;

	private BigDecimal posicion;

	private String tamanio;

	@Column(name="USUARIO_ALTA")
	private BigDecimal usuarioAlta;

	@Column(name="USUARIO_MODIFICACION")
	private BigDecimal usuarioModificacion;

	//bi-directional many-to-one association to CampoWidget
	@OneToMany(mappedBy="widget")
	private List<CampoWidget> campoWidgets;

	//bi-directional many-to-one association to CampoWidgetEventoUi
	@OneToMany(mappedBy="widget")
	private List<CampoWidgetEventoUi> campoWidgetEventoUis;

	//bi-directional many-to-one association to PantallaEventoUi
	@OneToMany(mappedBy="widget")
	private List<PantallaEventoUi> pantallaEventoUis;

	//bi-directional many-to-one association to CatTipoWidget
	@ManyToOne
	@JoinColumn(name="ID_TIPO_WIDGET")
	private CatTipoWidget catTipoWidget;

	//bi-directional many-to-one association to Widget
	@ManyToOne
	@JoinColumn(name="WIDGET_PADRE")
	private Widget widget;

	//bi-directional many-to-one association to Widget
	@OneToMany(mappedBy="widget")
	private List<Widget> widgets;

	//bi-directional many-to-one association to WidgetAccion
	@OneToMany(mappedBy="widget1")
	private List<WidgetAccion> widgetAccions1;

	//bi-directional many-to-one association to WidgetAccion
	@OneToMany(mappedBy="widget2")
	private List<WidgetAccion> widgetAccions2;

	//bi-directional many-to-one association to WidgetPantalla
	@OneToMany(mappedBy="widget")
	private List<WidgetPantalla> widgetPantallas;

	public Widget() {
	}

	public long getIdWidget() {
		return this.idWidget;
	}

	public void setIdWidget(long idWidget) {
		this.idWidget = idWidget;
	}

	public String getConfiguration() {
		return this.configuration;
	}

	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}

	public String getCveWidget() {
		return this.cveWidget;
	}

	public void setCveWidget(String cveWidget) {
		this.cveWidget = cveWidget;
	}

	public String getDescWidget() {
		return this.descWidget;
	}

	public void setDescWidget(String descWidget) {
		this.descWidget = descWidget;
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

	public BigDecimal getIdAreaTematica() {
		return this.idAreaTematica;
	}

	public void setIdAreaTematica(BigDecimal idAreaTematica) {
		this.idAreaTematica = idAreaTematica;
	}

	public String getIndEstatus() {
		return this.indEstatus;
	}

	public void setIndEstatus(String indEstatus) {
		this.indEstatus = indEstatus;
	}

	public String getNgClass() {
		return this.ngClass;
	}

	public void setNgClass(String ngClass) {
		this.ngClass = ngClass;
	}

	public String getNgIf() {
		return this.ngIf;
	}

	public void setNgIf(String ngIf) {
		this.ngIf = ngIf;
	}

	public String getNgShow() {
		return this.ngShow;
	}

	public void setNgShow(String ngShow) {
		this.ngShow = ngShow;
	}

	public String getNgStyle() {
		return this.ngStyle;
	}

	public void setNgStyle(String ngStyle) {
		this.ngStyle = ngStyle;
	}

	public String getNgrepeat() {
		return this.ngrepeat;
	}

	public void setNgrepeat(String ngrepeat) {
		this.ngrepeat = ngrepeat;
	}

	public BigDecimal getPosicion() {
		return this.posicion;
	}

	public void setPosicion(BigDecimal posicion) {
		this.posicion = posicion;
	}

	public String getTamanio() {
		return this.tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
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
		campoWidget.setWidget(this);

		return campoWidget;
	}

	public CampoWidget removeCampoWidget(CampoWidget campoWidget) {
		getCampoWidgets().remove(campoWidget);
		campoWidget.setWidget(null);

		return campoWidget;
	}

	public List<CampoWidgetEventoUi> getCampoWidgetEventoUis() {
		return this.campoWidgetEventoUis;
	}

	public void setCampoWidgetEventoUis(List<CampoWidgetEventoUi> campoWidgetEventoUis) {
		this.campoWidgetEventoUis = campoWidgetEventoUis;
	}

	public CampoWidgetEventoUi addCampoWidgetEventoUi(CampoWidgetEventoUi campoWidgetEventoUi) {
		getCampoWidgetEventoUis().add(campoWidgetEventoUi);
		campoWidgetEventoUi.setWidget(this);

		return campoWidgetEventoUi;
	}

	public CampoWidgetEventoUi removeCampoWidgetEventoUi(CampoWidgetEventoUi campoWidgetEventoUi) {
		getCampoWidgetEventoUis().remove(campoWidgetEventoUi);
		campoWidgetEventoUi.setWidget(null);

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
		pantallaEventoUi.setWidget(this);

		return pantallaEventoUi;
	}

	public PantallaEventoUi removePantallaEventoUi(PantallaEventoUi pantallaEventoUi) {
		getPantallaEventoUis().remove(pantallaEventoUi);
		pantallaEventoUi.setWidget(null);

		return pantallaEventoUi;
	}

	public CatTipoWidget getCatTipoWidget() {
		return this.catTipoWidget;
	}

	public void setCatTipoWidget(CatTipoWidget catTipoWidget) {
		this.catTipoWidget = catTipoWidget;
	}

	public Widget getWidget() {
		return this.widget;
	}

	public void setWidget(Widget widget) {
		this.widget = widget;
	}

	public List<Widget> getWidgets() {
		return this.widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}

	public Widget addWidget(Widget widget) {
		getWidgets().add(widget);
		widget.setWidget(this);

		return widget;
	}

	public Widget removeWidget(Widget widget) {
		getWidgets().remove(widget);
		widget.setWidget(null);

		return widget;
	}

	public List<WidgetAccion> getWidgetAccions1() {
		return this.widgetAccions1;
	}

	public void setWidgetAccions1(List<WidgetAccion> widgetAccions1) {
		this.widgetAccions1 = widgetAccions1;
	}

	public WidgetAccion addWidgetAccions1(WidgetAccion widgetAccions1) {
		getWidgetAccions1().add(widgetAccions1);
		widgetAccions1.setWidget1(this);

		return widgetAccions1;
	}

	public WidgetAccion removeWidgetAccions1(WidgetAccion widgetAccions1) {
		getWidgetAccions1().remove(widgetAccions1);
		widgetAccions1.setWidget1(null);

		return widgetAccions1;
	}

	public List<WidgetAccion> getWidgetAccions2() {
		return this.widgetAccions2;
	}

	public void setWidgetAccions2(List<WidgetAccion> widgetAccions2) {
		this.widgetAccions2 = widgetAccions2;
	}

	public WidgetAccion addWidgetAccions2(WidgetAccion widgetAccions2) {
		getWidgetAccions2().add(widgetAccions2);
		widgetAccions2.setWidget2(this);

		return widgetAccions2;
	}

	public WidgetAccion removeWidgetAccions2(WidgetAccion widgetAccions2) {
		getWidgetAccions2().remove(widgetAccions2);
		widgetAccions2.setWidget2(null);

		return widgetAccions2;
	}

	public List<WidgetPantalla> getWidgetPantallas() {
		return this.widgetPantallas;
	}

	public void setWidgetPantallas(List<WidgetPantalla> widgetPantallas) {
		this.widgetPantallas = widgetPantallas;
	}

	public WidgetPantalla addWidgetPantalla(WidgetPantalla widgetPantalla) {
		getWidgetPantallas().add(widgetPantalla);
		widgetPantalla.setWidget(this);

		return widgetPantalla;
	}

	public WidgetPantalla removeWidgetPantalla(WidgetPantalla widgetPantalla) {
		getWidgetPantallas().remove(widgetPantalla);
		widgetPantalla.setWidget(null);

		return widgetPantalla;
	}

}