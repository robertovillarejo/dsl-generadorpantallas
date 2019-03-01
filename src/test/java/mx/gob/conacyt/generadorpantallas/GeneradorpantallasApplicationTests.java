package mx.gob.conacyt.generadorpantallas;

import static mx.gob.conacyt.generadorpantallas.utils.Utils.loadPantallaEagerly;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CatControlUi;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Formato;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.CampoWidgetRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ComponenteRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ControlUiRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.FormatoRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.PantallaRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.TipoWidgetRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.WidgetRepository;
import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.SectionSubtitle;
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
	private CampoWidgetRepository cwRepo;

	@Autowired
	private EntityManager em;

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

	@Test
	@Transactional
	public void consultarPantalla() {
		Optional<Pantalla> maybePantalla = pantallaRepo.findOneByCvePantalla("SNIMONNotificacionAyudantes");
		maybePantalla.ifPresent(pantalla -> {
			System.out.println(pantalla.getDescPantalla());
		});
	}

	@Test
	public void consultarComponente() {
		componenteRepo.findOneByCveComponente("SNI");
	}

	@Test
	@Transactional()
	public void agregarCampoAPantalla() throws Exception {
		Pantalla originalPantalla = pantallaRepo.findById(130013001000203L).get();
		loadPantallaEagerly(originalPantalla);

		em.detach(originalPantalla);
		mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla modern = toModern(originalPantalla);

		Campo c = new SectionSubtitle();
		c.setActivo(true);
		c.setHabilitado(true);
		c.setDescripcion("test");
		c.setDescripcionCampo(
				"<div class=\"alert alert-info\"><h4 class=\"text-left\"> Probando adición de subtítulo de sección.</h4>\r\n"
						+ "</div>");
		c.setNgClass("'btn-default'");
		c.setPosicion(-4);
		c.setPosicionX(12);
		c.setLongitud(10);
		c.setUsuarioAlta(new BigDecimal(999999));
		c.setFechaAlta(new Timestamp(new Date().getTime()));

		Contenedor cont = modern.getContenedores().get(1).getHijos().get(0);
		cont.getCampos().add(c);

		Pantalla legacy = toLegacy(modern);
		pantallaRepo.save(legacy);
	}

	@Test
	@Transactional
	public void testBidirectionalConversion() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Optional<Pantalla> maybePantalla = pantallaRepo.findOneByCvePantalla("SNISOLPHome");
		if (maybePantalla.isPresent()) {
			// Get original Pantalla
			Pantalla originalPantalla = maybePantalla.get();

			// Converts original Pantalla to modern
			mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla modern = toModern(originalPantalla);

			// Serialize original Pantalla as JSON
			String originalPantallaJson = mapper.writeValueAsString(originalPantalla);

			// Converts modern Pantalla back to legacy
			Pantalla legacy = toLegacy(modern);

			// Serialize legacy Pantalla as JSON
			String legacyJson = mapper.writeValueAsString(legacy);

			// Compares JSON
			System.out.println(legacyJson);
			JSONAssert.assertEquals(originalPantallaJson, legacyJson, JSONCompareMode.LENIENT);
		} else {
			fail();
		}
	}

	public mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla toModern(Pantalla pantalla) {
		LegacyModelVisitor v = new LegacyModelVisitor();
		v.visit(pantalla);
		return v.getPantalla();
	}

	public Pantalla toLegacy(mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla pantalla) throws Exception {
		ModernModelVisitor mmv = new ModernModelVisitor(pantallaRepo, tipoWidgetRepo, formatoRepo, controlUiRepo, em);
		mmv.visit(pantalla);
		return mmv.getPantalla();
	}

}
