package mx.gob.conacyt.generadorpantallas.modern.domain;

public class Menu extends AbstractAuditing {

    private Transicion transicion;

    public Transicion getTransicion() {
        return transicion;
    }

    public void setTransicion(Transicion transicion) {
        this.transicion = transicion;
    }

}
