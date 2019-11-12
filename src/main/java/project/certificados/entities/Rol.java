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
@Table(name = "Rol")
public class Rol implements Serializable {
    public Rol() {
    }

    private Integer idRol=null;
    private String cargo=null;

    @Id
    @GeneratedValue
    @Column(name = "IdRol")
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    @Column(name = "Cargo")
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}