package mx.gob.conacyt.generadorpantallas.converters;

import mx.gob.conacyt.generadorpantallas.domain.Componente;

public class ConverterToModern {
	
	public mx.gob.conacyt.generadorpantallas.domain.legacy.Componente toModern(mx.gob.conacyt.generadorpantallas.domain.legacy.Componente componente) {
		Componente modern = new Componente();
		modern.setClave(componente.getCveComponente());
		modern.setDescripcion(componente.getDescComponente());
		modern.setId(componente.getIdComponente());
		return componente;
	}


}
