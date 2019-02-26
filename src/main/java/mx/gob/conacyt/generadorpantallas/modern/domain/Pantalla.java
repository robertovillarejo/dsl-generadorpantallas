package mx.gob.conacyt.generadorpantallas.modern.domain;

import java.util.ArrayList;
import java.util.List;

public class Pantalla extends AbstractAuditing {

    private Long id;

    private String clave;

    private String descripcion;

    private List<Contenedor> contenedores = new ArrayList<>();

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

    public List<Contenedor> getContenedores() {
        return contenedores;
    }

    public void setContenedores(List<Contenedor> contenedores) {
        this.contenedores = contenedores;
    }

    @Override
    public String toString() {
        return "Pantalla [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion + ", contenedores="
                + contenedores + "]";
    }

}
