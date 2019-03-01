package mx.gob.conacyt.generadorpantallas.legacy.services;

import org.springframework.transaction.annotation.Transactional;

import mx.gob.conacyt.generadorpantallas.factories.ModernFactory;
import mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class LegacyToModernComponent {

    public Pantalla toModern(mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla pantalla) {
        return ModernFactory.toModern(pantalla);
    }

}
