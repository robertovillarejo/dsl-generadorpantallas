package mx.gob.conacyt.generadorpantallas.modern.domain.contenedores;

import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;

public class Grid extends Contenedor {

    private final String TIPO = "grid";

    @Override
    public String getTipo() {
        return TIPO;
    }

}
