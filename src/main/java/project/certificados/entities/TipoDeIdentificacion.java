package project.certificados.entities;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Created by Alejandra Goenaga
 */
@Entity
@Table(name = "TipoDeIdentificacion")
public class TipoDeIdentificacion implements Serializable {
    public TipoDeIdentificacion() {
    }

    private Integer idTipoDeIdentificacion=null;
    private String sigla=null;
    private String descripcion=null;

    @Id
    @GeneratedValue
    @Column(name = "IdTipoDeIdentificacion")
    public Integer getIdTipoDeIdentificacion() {
        return idTipoDeIdentificacion;
    }

    public void setIdTipoDeIdentificacion(Integer idTipoDeIdentificacion) {
        this.idTipoDeIdentificacion = idTipoDeIdentificacion;
    }

    @Column(name = "Sigla")
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Column(name = "Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}