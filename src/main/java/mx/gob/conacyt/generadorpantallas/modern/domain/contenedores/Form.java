package mx.gob.conacyt.generadorpantallas.modern.domain.contenedores;

import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;

public class Form extends Contenedor {
    
    private final String TIPO = "form";

    @Override
    public String getTipo() {
        return TIPO;
    }

}
