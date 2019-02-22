package mx.gob.conacyt.generadorpantallas.legacy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.gob.conacyt.generadorpantallas.visitor.Element;
import mx.gob.conacyt.generadorpantallas.visitor.LegacyVisitor;

/**
 * The persistent class for the MENU database table.
 * 
 */
@Entity
@Table(name = "MENU")
public class Menu implements Serializable, Element {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_MENU")
    private Long idMenu;

    @Column(name = "CVE_MENU")
    private String cveMenu;

    @Column(name = "DESC_MENU")
    private String descMenu;

    @Column(name = "FECHA_ALTA")
    private Timestamp fechaAlta;

    @Column(name = "FECHA_MODIFICACION")
    private Timestamp fechaModificacion;

    @Column(name = "IND_ESTATUS")
    private String indEstatus;

    @Column(name = "NG_IF")
    private String ngIf;

    private BigDecimal posicion;

    private String url;

    @Column(name = "USUARIO_ALTA")
    private BigDecimal usuarioAlta;

    @Column(name = "USUARIO_MODIFICACION")
    private BigDecimal usuarioModificacion;

    // TODO: Verificar que el tipo de relación es ManyToOne o OneToOne
    // bi-directional many-to-one association to FlujoPantalla
    @OneToMany(mappedBy = "menu")
    private List<FlujoPantalla> flujoPantallas = new ArrayList<>();

    // bi-directional many-to-one association to CatComponente
    @ManyToOne
    @JoinColumn(name = "ID_COMPONENTE")
    private Componente componente;

    // bi-directional many-to-one association to Menu
    @ManyToOne
    @JoinColumn(name = "MENU_PADRE")
    private Menu menu;

    // bi-directional many-to-one association to Menu
    @OneToMany(mappedBy = "menu")
    private List<Menu> menus;

    public Menu() {
    }

    public long getIdMenu() {
        return this.idMenu;
    }

    public void setIdMenu(long idMenu) {
        this.idMenu = idMenu;
    }

    public String getCveMenu() {
        return this.cveMenu;
    }

    public void setCveMenu(String cveMenu) {
        this.cveMenu = cveMenu;
    }

    public String getDescMenu() {
        return this.descMenu;
    }

    public void setDescMenu(String descMenu) {
        this.descMenu = descMenu;
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

    public String getNgIf() {
        return this.ngIf;
    }

    public void setNgIf(String ngIf) {
        this.ngIf = ngIf;
    }

    public BigDecimal getPosicion() {
        return this.posicion;
    }

    public void setPosicion(BigDecimal posicion) {
        this.posicion = posicion;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public List<FlujoPantalla> getFlujoPantallas() {
        return this.flujoPantallas;
    }

    public void setFlujoPantallas(List<FlujoPantalla> flujoPantallas) {
        this.flujoPantallas = flujoPantallas;
    }

    public FlujoPantalla addFlujoPantalla(FlujoPantalla flujoPantalla) {
        getFlujoPantallas().add(flujoPantalla);
        flujoPantalla.setMenu(this);

        return flujoPantalla;
    }

    public FlujoPantalla removeFlujoPantalla(FlujoPantalla flujoPantalla) {
        getFlujoPantallas().remove(flujoPantalla);
        flujoPantalla.setMenu(null);

        return flujoPantalla;
    }

    public Componente getComponente() {
        return this.componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getMenus() {
        return this.menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu addMenus(Menu menus) {
        getMenus().add(menus);
        menus.setMenu(this);

        return menus;
    }

    public Menu removeMenus(Menu menus) {
        getMenus().remove(menus);
        menus.setMenu(null);

        return menus;
    }
    
    @Override
    public void accept(LegacyVisitor visitor) {
        visitor.visit(this);
    }

}