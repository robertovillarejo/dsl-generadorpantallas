package mx.gob.conacyt.generadorpantallas.visitor;

import java.util.Optional;

import org.springframework.util.StringUtils;

import static mx.gob.conacyt.generadorpantallas.factories.LegacyFactory.getCampoWidget;

import mx.gob.conacyt.generadorpantallas.factories.LegacyFactory;
import mx.gob.conacyt.generadorpantallas.legacy.domain.CampoWidget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.Widget;
import mx.gob.conacyt.generadorpantallas.legacy.domain.WidgetPantalla;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.ControlUiRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.FormatoRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.PantallaRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.TipoWidgetRepository;
import mx.gob.conacyt.generadorpantallas.legacy.repositories.WidgetRepository;
import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;
import mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla;

public class ModernModelVisitor extends AbstractModernVisitor {

    private mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla lPantalla;

    private Widget lWidget;

    private PantallaRepository pantallaRepo;

    private TipoWidgetRepository tipoWidgetRepo;

    private FormatoRepository formatoRepo;

    private ControlUiRepository controlUiRepo;

    public ModernModelVisitor(PantallaRepository pantallaRepo, TipoWidgetRepository tipoWidgetRepo,
            FormatoRepository formatoRepo, ControlUiRepository controlUiRepo) {
        this.pantallaRepo = pantallaRepo;
        this.tipoWidgetRepo = tipoWidgetRepo;
        this.formatoRepo = formatoRepo;
        this.controlUiRepo = controlUiRepo;
    }

    public mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla getPantalla() {
        return lPantalla;
    }

    // Creation of new legacy Pantalla is unsupported
    @Override
    public void visit(Pantalla element) throws Exception {
        if (element.getId() == null && StringUtils.isEmpty(element.getClave())) {
            throw new Exception("A new Pantalla must have a clave");
        }
        // Pantalla items will be identified by clave by the user
        // If Modern pantalla has a clave then check if Modern already exists
        Optional<mx.gob.conacyt.generadorpantallas.legacy.domain.Pantalla> maybePantalla = pantallaRepo
                .findOneByCvePantalla(element.getClave());
        if (!maybePantalla.isPresent()) {
            throw new Exception(String.format("Pantalla with clave {} not found", element.getClave()));
        }
        lPantalla = maybePantalla.get();
        LegacyFactory.mergeToLegacy(element, lPantalla);
        super.visit(element);
    }

    @Override
    public void visit(Contenedor element) {
        if (element.getId() != null && lPantalla.getIdPantalla() != null) {
            Optional<WidgetPantalla> maybeWp = findWidgetPantalla(element.getId(), lPantalla.getIdPantalla());
            if (maybeWp.isPresent()) {
                lWidget = maybeWp.get().getWidget();
                LegacyFactory.mergeToLegacy(element, lWidget);
            } else {
                lWidget = LegacyFactory.getWidget(element, tipoWidgetRepo);
            }
        } else {
            lWidget = LegacyFactory.getWidget(element, tipoWidgetRepo);
            LegacyFactory.mergeToLegacy(element, lWidget);
            WidgetPantalla wpNew = new WidgetPantalla();
            wpNew.setPantalla(lPantalla);
            wpNew.setWidget(lWidget);
            lPantalla.getWidgetPantallas().add(wpNew);
        }
        super.visit(element);
    }

    @Override
    public void visit(Campo element) {
        // Campo already exists
        if (element.getId() != null) {
            // Search the CampoWidget in lWidget.campoWidgets and 'merge' it with Campo
            Optional<CampoWidget> maybeCw = findCampoWidget(element.getId());
            if (maybeCw.isPresent()) {
                LegacyFactory.mergeToLegacy(element, maybeCw.get(), formatoRepo);
            }
            // throw new Exception(String.format("Failed to get campo {}",
            // element.getId()));
        } else {
            // Create new CampoWidget and add it to lWidget.campoWidgets
            CampoWidget cw = getCampoWidget(element, controlUiRepo);
            LegacyFactory.mergeToLegacy(element, cw, formatoRepo);
            lWidget.addCampoWidget(cw);
        }
        super.visit(element);
    }

    private Optional<WidgetPantalla> findWidgetPantalla(Long idWidget, Long idPantalla) {
        for (WidgetPantalla wp : lPantalla.getWidgetPantallas()) {
            if (wp.getWidget().getIdWidget() == idWidget && wp.getPantalla().getIdPantalla() == idPantalla) {
                return Optional.of(wp);
            }
        }
        return Optional.empty();
    }

    private Optional<CampoWidget> findCampoWidget(Long id) {
        for (CampoWidget cw : lWidget.getCampoWidgets()) {
            if (cw.getIdCampoWidget() == id) {
                return Optional.of(cw);
            }
        }
        return Optional.empty();
    }

}
