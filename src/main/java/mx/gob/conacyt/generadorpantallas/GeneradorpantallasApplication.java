package mx.gob.conacyt.generadorpantallas;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ControlUiRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.FormatoRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.PantallaRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.TipoWidgetRepository;
import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;
import mx.gob.conacyt.generadorpantallas.modern.domain.campos.Boton;
import mx.gob.conacyt.generadorpantallas.visitor.LegacyModelVisitor;
import mx.gob.conacyt.generadorpantallas.visitor.ModernModelVisitor;

@SpringBootApplication
@EnableJpaAuditing
public class GeneradorpantallasApplication implements CommandLineRunner {

    @Autowired
    private PantallaRepository pantallaRepo;

    @Autowired
    private TipoWidgetRepository tipoWidgetRepo;

    @Autowired
    private FormatoRepository formatoRepo;

    @Autowired
    private ControlUiRepository controlUiRepo;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplicationBuilder(GeneradorpantallasApplication.class)
                .web(WebApplicationType.NONE).build();
        app.run(args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

//        Pantalla pt = new Pantalla();
//        pt.setCvePantalla("testRoberto");
//        pt.setDescPantalla("Pantalla de prueba");
//        pt.setFechaAlta(new Timestamp(new Date().getTime()));
//        pt.setUsuarioAlta(new BigDecimal(999999));
//        pt.setIdTipoPantalla(new BigDecimal(1));
//        pt.setIndEstatus("0");
//        pantallaRepo.save(pt);

        Pantalla originalPantalla = pantallaRepo.findById(130013001000203L).get();
        mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla modern = toModern(originalPantalla);

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
        Contenedor cont = modern.getContenedores().get(0);
        cont.setDescripcion(cont.getDescripcion().toLowerCase());
        cont.getCampos().add(c);
        modern.setDescripcion("Sistema Nacional de Investigadores (SNI)\r\n");
//        Contenedor contNuevo = new Contenedor();
//        contNuevo.setClave("cvePrueba");
//        contNuevo.setDescripcion("pruebaContenedor");
//        contNuevo.setFechaAlta(new Timestamp(new Date().getTime()));
//        contNuevo.setUsuarioAlta(new BigDecimal(999999));
//        modern.getContenedores().add(contNuevo);

        Pantalla legacy = toLegacy(modern);
        pantallaRepo.save(legacy);
    }

    public mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla toModern(Pantalla pantalla) {
        LegacyModelVisitor v = new LegacyModelVisitor();
        v.visit(pantalla);
        return v.getPantalla();
    }

    public Pantalla toLegacy(mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla pantalla) throws Exception {
        ModernModelVisitor mmv = new ModernModelVisitor(pantallaRepo, tipoWidgetRepo, formatoRepo, controlUiRepo);
        mmv.visit(pantalla);
        return mmv.getPantalla();
    }

}
