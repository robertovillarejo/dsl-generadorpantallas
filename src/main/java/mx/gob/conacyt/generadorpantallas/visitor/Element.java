package mx.gob.conacyt.generadorpantallas.visitor;

public interface Element {
    
    public void accept(LegacyVisitor visitor);

}
