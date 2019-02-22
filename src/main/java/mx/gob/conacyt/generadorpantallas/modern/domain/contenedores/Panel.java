package mx.gob.conacyt.generadorpantallas.modern.domain.contenedores;

import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;

public class Panel extends Contenedor {

    private final String TIPO = "panel";

    @Override
    public String getTipo() {
        return TIPO;
    }

}
