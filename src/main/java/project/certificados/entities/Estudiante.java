package project.certificados.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Created by Alejandra Goenaga
 */
@Entity
@Table(name = "Estudiante")
public class Estudiante implements Serializable {
    public Estudiante() {
    }

    private String idEstudiante=null;
    private Integer idTipoDeIdentificacion=null;
    private String numeroDeIdentificacion=null;
    private String nombre=null;
    private Integer codigo=null;
    private List<Informe> informes=new ArrayList<>();

    @Id
    @Column(name = "IdEstudiante")
    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Column(name = "IdTipoDeIdentificacion")
    public Integer getIdTipoDeIdentificacion() {
        return idTipoDeIdentificacion;
    }

    public void setIdTipoDeIdentificacion(Integer idTipoDeIdentificacion) {
        this.idTipoDeIdentificacion = idTipoDeIdentificacion;
    }

    @Column(name = "NumeroDeIdentificacion")
    public String getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

    public void setNumeroDeIdentificacion(String numeroDeIdentificacion) {
        this.numeroDeIdentificacion = numeroDeIdentificacion;
    }

    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "Codigo")
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idEstudiante", targetEntity = Informe.class)
    public List<Informe> getInformes() {
        return informes;
    }

    public void setInformes(List<Informe> informes) {
        this.informes = informes;
    }
}