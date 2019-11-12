package project.certificados.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "Area")
public class Area implements Serializable {
    public Area() {
    }

    private Integer idArea=null;
    private String nombre=null;
    private Integer intensidadHoraria=null;
    private List<Asignatura> asignaturas=new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "IdArea")
    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "IntensidadHoraria")
    public Integer getIntensidadHoraria() {
        return intensidadHoraria;
    }

    public void setIntensidadHoraria(Integer intensidadHoraria) {
        this.intensidadHoraria = intensidadHoraria;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idArea", targetEntity = Asignatura.class)
    @JsonIgnore
    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}