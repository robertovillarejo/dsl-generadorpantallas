package mx.gob.conacyt.generadorpantallas.legacy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the CAT_SERVICIO database table.
 * 
 */
@Entity
@Table(name = "CAT_SERVICIO")
public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_SERVICIO")
    private long idServicio;

    @Column(name = "CVE_SERVICIO")
    private String cveServicio;

    @Column(name = "DESC_SERVICIO")
    private String descServicio;

    @Column(name = "FECHA_ALTA")
    private Timestamp fechaAlta;

    @Column(name = "FECHA_MODIFICACION")
    private Timestamp fechaModificacion;

    @Column(name = "IND_ESTATUS")
    private String indEstatus;

    @Column(name = "RUTA_SERVICIO")
    private String rutaServicio;

    @Column(name = "USUARIO_ALTA")
    private BigDecimal usuarioAlta;

    @Column(name = "USUARIO_MODIFICACION")
    private BigDecimal usuarioModificacion;

    private String wadl;

    private String wsdl;

    public Servicio() {
    }

    public long getIdServicio() {
        return this.idServicio;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
    }

    public String getCveServicio() {
        return this.cveServicio;
    }

    public void setCveServicio(String cveServicio) {
        this.cveServicio = cveServicio;
    }

    public String getDescServicio() {
        return this.descServicio;
    }

    public void setDescServicio(String descServicio) {
        this.descServicio = descServicio;
    }

    public Timestamp getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Timestamp getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getIndEstatus() {
        return this.indEstatus;
    }

    public void setIndEstatus(String indEstatus) {
        this.indEstatus = indEstatus;
    }

    public String getRutaServicio() {
        return this.rutaServicio;
    }

    public void setRutaServicio(String rutaServicio) {
        this.rutaServicio = rutaServicio;
    }

    public BigDecimal getUsuarioAlta() {
        return this.usuarioAlta;
    }

    public void setUsuarioAlta(BigDecimal usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public BigDecimal getUsuarioModificacion() {
        return this.usuarioModificacion;
    }

    public void setUsuarioModificacion(BigDecimal usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getWadl() {
        return this.wadl;
    }

    public void setWadl(String wadl) {
        this.wadl = wadl;
    }

    public String getWsdl() {
        return this.wsdl;
    }

    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }

}