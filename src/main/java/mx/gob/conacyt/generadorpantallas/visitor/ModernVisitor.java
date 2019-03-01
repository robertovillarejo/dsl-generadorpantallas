package mx.gob.conacyt.generadorpantallas.visitor;

import mx.gob.conacyt.generadorpantallas.modern.domain.Campo;
import mx.gob.conacyt.generadorpantallas.modern.domain.Componente;
import mx.gob.conacyt.generadorpantallas.modern.domain.Contenedor;
import mx.gob.conacyt.generadorpantallas.modern.domain.Menu;
import mx.gob.conacyt.generadorpantallas.modern.domain.Pantalla;

public interface ModernVisitor {
    
    public void visit(Componente element);
    
    public void visit(Menu element);
    
    public void visit(Pantalla element) throws Exception;
    
    public void visit(Contenedor element);
    
    public void visit(Campo element);

}
