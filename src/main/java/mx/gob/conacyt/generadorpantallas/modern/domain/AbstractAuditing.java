package mx.gob.conacyt.generadorpantallas.modern.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public abstract class AbstractAuditing {

    private Timestamp fechaAlta;

    private Date fechaModificacion;

    private BigDecimal usuarioAlta;

    private BigDecimal usuarioModificacion;

    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public BigDecimal getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(BigDecimal usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public BigDecimal getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(BigDecimal usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

}
