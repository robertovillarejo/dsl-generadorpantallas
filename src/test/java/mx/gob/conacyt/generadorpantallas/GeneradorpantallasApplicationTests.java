package mx.gob.conacyt.generadorpantallas;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Optional;

import org.json.JSONException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.WidgetPantalla;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ComponenteRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ControlUiRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.FormatoRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.PantallaRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.TipoWidgetRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.WidgetPantallaRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.WidgetRepository;
import mx.gob.conacyt.generadorpantallas.legacy.services.ModernToLegacyComponent;
import mx.gob.conacyt.generadorpantallas.visitor.LegacyModelVisitor;
import mx.gob.conacyt.generadorpantallas.visitor.ModernModelVisitor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneradorpantallasApplicationTests {

    @Autowired
    private ModernToLegacyComponent service;

    @Autowired
    private PantallaRepository pantallaRepo;

    @Autowired
    private ComponenteRepository componenteRepo;

    @Autowired
    private WidgetRepository widgetRepo;

    @Autowired
    private TipoWidgetRepository tipoWidgetRepo;

    @Autowired
    private FormatoRepository formatoRepo;

    @Autowired
    private ControlUiRepository controlUiRepo;

    @Autowired
    private WidgetPantallaRepository wpRepo;

    @Ignore
    @Test
    @Transactional
    public void consultarPantalla() {
        Optional<Pantalla> maybePantalla = pantallaRepo.findOneByCvePantalla("SNIMONNotificacionAyudantes");
        maybePantalla.ifPresent(pantalla -> {
            System.out.println(pantalla.getDescPantalla());
        });
    }

    @Ignore
    @Test
    @Transactional
    public void consultarComponente() {
        componenteRepo.findOneByCveComponente("SNI");
    }

    @Ignore
    @Test
    @Transactional
    public void agregarCampoAPantalla() {
    }

    @Ignore
    @Test
    public void testWidgetPantallaRepo() {
        WidgetPantalla wp = wpRepo.findFirstByPantallaAndWidget(210010000000101L, 210010000000561L);
        assert wp != null;
    }

    @Test
    @Transactional
    public void testBidirectionalConversion() throws IOException, JSONException {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Pantalla> maybePantalla = pantallaRepo.findOneByCvePantalla("SNISOLPHome");
        if (maybePantalla.isPresent()) {
            // Get original Pantalla
            Pantalla originalPantalla = maybePantalla.get();

            // Converts original Pantalla to modern
            mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla modern = testToModern(originalPantalla);

            // Serialize original Pantalla as JSON
            String originalPantallaJson = mapper.writeValueAsString(originalPantalla);

            // Converts modern Pantalla back to legacy
            Pantalla legacy = testToLegacy(modern);

            // Serialize legacy Pantalla as JSON
            String legacyJson = mapper.writeValueAsString(legacy);

            // Compares JSON
            System.out.println(legacyJson);
            JSONAssert.assertEquals(originalPantallaJson, legacyJson, JSONCompareMode.LENIENT);
        } else {
            fail();
        }
    }

    public mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla testToModern(Pantalla pantalla) {
        LegacyModelVisitor v = new LegacyModelVisitor();
        v.visit(pantalla);
        return v.getPantalla();
    }

    public Pantalla testToLegacy(mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla pantalla) {
        ModernModelVisitor mmv = new ModernModelVisitor(widgetRepo, pantallaRepo, tipoWidgetRepo, formatoRepo,
                controlUiRepo, wpRepo);
        mmv.visit(pantalla);
        return mmv.getPantalla();
    }

}