package mx.gob.conacyt.generadorpantallas.domain.legacy;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the FLUJO_PANTALLA database table.
 * 
 */
@Entity
@Table(name="FLUJO_PANTALLA")
@NamedQuery(name="FlujoPantalla.findAll", query="SELECT f FROM FlujoPantalla f")
public class FlujoPantalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FLUJO_PANTALLA")
	private long idFlujoPantalla;

	@Column(name="DESC_FLUJO_PANTALLA")
	private String descFlujoPantalla;

	@Column(name="FECHA_ALTA")
	private Timestamp fechaAlta;

	@Column(name="FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	@Column(name="ID_TAREA")
	private BigDecimal idTarea;

	@Column(name="IND_ESTATUS")
	private String indEstatus;

	@Column(name="USUARIO_ALTA")
	private BigDecimal usuarioAlta;

	@Column(name="USUARIO_MODIFICACION")
	private BigDecimal usuarioModificacion;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="ID_MENU")
	private Menu menu;

	//bi-directional many-to-one association to SecuenciaFlujoPantalla
	@OneToMany(mappedBy="flujoPantalla")
	private List<SecuenciaFlujoPantalla> secuenciaFlujoPantallas;

	public FlujoPantalla() {
	}

	public long getIdFlujoPantalla() {
		return this.idFlujoPantalla;
	}

	public void setIdFlujoPantalla(long idFlujoPantalla) {
		this.idFlujoPantalla = idFlujoPantalla;
	}

	public String getDescFlujoPantalla() {
		return this.descFlujoPantalla;
	}

	public void setDescFlujoPantalla(String descFlujoPantalla) {
		this.descFlujoPantalla = descFlujoPantalla;
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

	public BigDecimal getIdTarea() {
		return this.idTarea;
	}

	public void setIdTarea(BigDecimal idTarea) {
		this.idTarea = idTarea;
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

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<SecuenciaFlujoPantalla> getSecuenciaFlujoPantallas() {
		return this.secuenciaFlujoPantallas;
	}

	public void setSecuenciaFlujoPantallas(List<SecuenciaFlujoPantalla> secuenciaFlujoPantallas) {
		this.secuenciaFlujoPantallas = secuenciaFlujoPantallas;
	}

	public SecuenciaFlujoPantalla addSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
		getSecuenciaFlujoPantallas().add(secuenciaFlujoPantalla);
		secuenciaFlujoPantalla.setFlujoPantalla(this);

		return secuenciaFlujoPantalla;
	}

	public SecuenciaFlujoPantalla removeSecuenciaFlujoPantalla(SecuenciaFlujoPantalla secuenciaFlujoPantalla) {
		getSecuenciaFlujoPantallas().remove(secuenciaFlujoPantalla);
		secuenciaFlujoPantalla.setFlujoPantalla(null);

		return secuenciaFlujoPantalla;
	}

}