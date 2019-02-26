package mx.gob.conacyt.generadorpantallas;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CatControlUi;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Formato;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.WidgetPantalla;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.CampoWidgetRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ComponenteRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ControlUiRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.FormatoRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.PantallaRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.TipoWidgetRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.WidgetPantallaRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.WidgetRepository;
import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Boton;
import mx.gob.conacyt.generadorpantallas.visitor.LegacyModelVisitor;
import mx.gob.conacyt.generadorpantallas.visitor.ModernModelVisitor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneradorpantallasApplicationTests {

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

    @Autowired
    private CampoWidgetRepository cwRepo;

    @Test
    @Transactional
    public void testPrefixBasedGenerator() throws Exception {
        Widget w = widgetRepo.findById(130013000526012L).get();
        Formato f = formatoRepo.findOneByFormato(null).get();
        CatControlUi tipo = controlUiRepo.findOneByCveControlUi("button").get();
        CampoWidget cw = new CampoWidget();
        cw.setDescCampoWidget("Probando prefix based generator");
        cw.setActivo("0");
        cw.setHabilitado("0");
        cw.setWidget(w);
        cw.setFormato(f);
        cw.setCatControlUi(tipo);
        cw.setUsuarioAlta(new BigDecimal(999999));
        cw.setFechaAlta(new Timestamp(new Date().getTime()));
        cw.setUsuarioModificacion(new BigDecimal(999999));
        cw.setFechaModificacion(new Timestamp(new Date().getTime()));
        cw.setIndEstatus("0");
        CampoWidget nuevo = cwRepo.save(cw);
        System.out.println("El id generado es: " + nuevo.getIdCampoWidget());
    }

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
    public void consultarComponente() {
        componenteRepo.findOneByCveComponente("SNI");
    }

    @Test
    @Transactional()
    public void agregarCampoAPantalla() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Pantalla> maybePantalla = pantallaRepo.findOneByCvePantalla("SNISOLPHome");
        if (maybePantalla.isPresent()) {
            // Get original Pantalla
            Pantalla originalPantalla = maybePantalla.get();

            // Converts original Pantalla to modern
            mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla modern = testToModern(originalPantalla);

            Campo c = new Boton();
            c.setActivo(true);
            c.setHabilitado(true);
            c.setDescripcion("test");
            c.setDescripcionCampo("Botón creado programáticamente");
            c.setNgClass("'btn-default'");
            c.setPosicion(1);
            c.setPosicionX(4);
            c.setLineaNueva("0");
            c.setLongitud(10);
            modern.getContenedores().get(0).getCampos().add(c);
            Pantalla legacy = testToLegacy(modern);
            pantallaRepo.save(legacy);
            System.out.println(mapper.writeValueAsString(legacy));
        }
    }

    @Ignore
    @Test
    public void testWidgetPantallaRepo() {
        WidgetPantalla wp = wpRepo.findFirstByPantallaAndWidget(210010000000101L, 210010000000561L);
        assert wp != null;
    }

    @Ignore
    @Test
    @Transactional
    public void testBidirectionalConversion() throws Exception {
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

    public Pantalla testToLegacy(mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla pantalla) throws Exception {
        ModernModelVisitor mmv = new ModernModelVisitor(pantallaRepo, tipoWidgetRepo, formatoRepo, controlUiRepo);
        mmv.visit(pantalla);
        return mmv.getPantalla();
    }

}
