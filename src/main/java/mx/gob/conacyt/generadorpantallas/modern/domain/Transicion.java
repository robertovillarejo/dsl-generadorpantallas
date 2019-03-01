package mx.gob.conacyt.generadorpantallas.modern.domain;

public class Transicion extends AbstractAuditing {

    private Pantalla pantalla;

    public Pantalla getPantalla() {
        return pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

}
