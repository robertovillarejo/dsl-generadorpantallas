package mx.gob.conacyt.generadorpantallas.legacy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.conacyt.generadorpantallas.factories.LegacyFactory;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ComponenteRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.PantallaRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.WidgetRepository;

@Component
@Transactional
public class ModernToLegacyComponent {
    
    @Autowired
    private ComponenteRepository componenteRepo;
    
    @Autowired
    private WidgetRepository widgetRepo;
    
    @Autowired
    private PantallaRepository pantallaRepo;
    
    public Pantalla toLegacy(mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla pantalla) {
        try {
            return LegacyFactory.toLegacy(pantalla, widgetRepo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
