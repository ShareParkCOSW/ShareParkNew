package project.certificados.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Created by Alejandra Goenaga
 */
@Entity
@Table(name = "Calificacion")
public class Calificacion implements Serializable {
    public Calificacion() {
    }

    private Integer idCalificacion=null;
    private Integer idArea=null;
    private Integer idAsignatura=null;
    private Integer idInforme=null;
    private String nota=null;
    private Timestamp fecha=null;
    private Boolean recuperacion=null;

    @Id
    @GeneratedValue
    @Column(name = "IdCalificacion")
    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    @Column(name = "IdArea")
    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    @Column(name = "IdAsignatura")
    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Column(name = "IdInforme")
    public Integer getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(Integer idInforme) {
        this.idInforme = idInforme;
    }

    @Column(name = "Nota")
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Column(name = "Fecha")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Column(name = "Recuperacion")
    public Boolean getRecuperacion() {
        return recuperacion;
    }

    public void setRecuperacion(Boolean recuperacion) {
        this.recuperacion = recuperacion;
    }
}