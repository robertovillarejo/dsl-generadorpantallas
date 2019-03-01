package mx.gob.conacyt.generadorpantallas.legacy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.gob.conacyt.generadorpantallas.visitor.Element;
import mx.gob.conacyt.generadorpantallas.visitor.LegacyVisitor;

/**
 * The persistent class for the CAT_COMPONENTE database table.
 * 
 */
@Entity
@Table(name = "CAT_COMPONENTE")
public class Componente implements Serializable, Element {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_COMPONENTE")
    private Long idComponente;

    @Column(name = "CVE_COMPONENTE")
    private String cveComponente;

    @Column(name = "DESC_COMPONENTE")
    private String descComponente;

    @Column(name = "FECHA_ALTA")
    private Timestamp fechaAlta;

    @Column(name = "FECHA_MODIFICACION")
    private Timestamp fechaModificacion;

    @Column(name = "IND_ESTATUS")
    private String indEstatus;

    private BigDecimal liberacion;

    @Column(name = "USUARIO_ALTA")
    private BigDecimal usuarioAlta;

    @Column(name = "USUARIO_MODIFICACION")
    private BigDecimal usuarioModificacion;

    // bi-directional many-to-one association to Menu
    @OneToMany(mappedBy = "componente")
    private List<Menu> menus = new ArrayList<>();

    public Componente() {
    }

    public long getIdComponente() {
        return this.idComponente;
    }

    public void setIdComponente(long idComponente) {
        this.idComponente = idComponente;
    }

    public String getCveComponente() {
        return this.cveComponente;
    }

    public void setCveComponente(String cveComponente) {
        this.cveComponente = cveComponente;
    }

    public String getDescComponente() {
        return this.descComponente;
    }

    public void setDescComponente(String descComponente) {
        this.descComponente = descComponente;
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

    public BigDecimal getLiberacion() {
        return this.liberacion;
    }

    public void setLiberacion(BigDecimal liberacion) {
        this.liberacion = liberacion;
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

    public List<Menu> getMenus() {
        return this.menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu addMenus(Menu menus) {
        getMenus().add(menus);
        menus.setComponente(this);

        return menus;
    }

    public Menu removeMenus(Menu menus) {
        getMenus().remove(menus);
        menus.setComponente(null);

        return menus;
    }

    @Override
    public void accept(LegacyVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Componente [idComponente=" + idComponente + ", cveComponente=" + cveComponente + ", descComponente="
                + descComponente + ", fechaAlta=" + fechaAlta + ", fechaModificacion=" + fechaModificacion
                + ", indEstatus=" + indEstatus + ", liberacion=" + liberacion + ", usuarioAlta=" + usuarioAlta
                + ", usuarioModificacion=" + usuarioModificacion + "]";
    }

}