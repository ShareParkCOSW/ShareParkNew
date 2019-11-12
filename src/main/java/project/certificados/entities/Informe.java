package project.certificados.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Created by Alejandra Goenaga
 */
@Entity
@Table(name = "Informe")
public class Informe implements Serializable {
    public Informe() {
    }

    private Integer idInforme=null;
    private String idEstudiante=null;
    private Integer anio=null;
    private String curso=null;
    private String jornada=null;
    private String observaciones=null;
    private String idDirectorCurso=null;
    private String idRector=null;
    private String idSecretario=null;
    private List<Calificacion> calificaciones=new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "IdInforme")
    public Integer getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(Integer idInforme) {
        this.idInforme = idInforme;
    }

    @Column(name = "IdEstudiante")
    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Column(name = "Anio")
    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @Column(name = "Curso")
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Column(name = "Jornada")
    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    @Column(name = "Observaciones")
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Column(name = "IdDirectorCurso")
    public String getIdDirectorCurso() {
        return idDirectorCurso;
    }

    public void setIdDirectorCurso(String idDirectorCurso) {
        this.idDirectorCurso = idDirectorCurso;
    }

    @Column(name = "IdRector")
    public String getIdRector() {
        return idRector;
    }

    public void setIdRector(String idRector) {
        this.idRector = idRector;
    }

    @Column(name = "IdSecretario")
    public String getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(String idSecretario) {
        this.idSecretario = idSecretario;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idInforme", targetEntity = Calificacion.class)
    @JsonIgnore
    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }
}