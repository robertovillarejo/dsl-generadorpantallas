package mx.gob.conacyt.generadorpantallas.modern.domain;

import java.util.ArrayList;
import java.util.List;

public class Componente extends AbstractAuditing {

    private Long id;

    private String clave;

    private String descripcion;

    private List<Menu> menus = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}
