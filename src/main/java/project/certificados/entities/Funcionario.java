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
@Table(name = "Funcionario")
public class Funcionario implements Serializable {
    public Funcionario() {
    }
    private Integer idFuncionario=null;
    private Integer idTipoDeIdentificacion=null;
    private String numeroDeIdentificacion=null;
    private String nombre=null;
    private Timestamp fechaDeNacimiento=null;
    private Integer idRol=null;

    @Id
    @Column(name = "IdFuncionarioPrimaria")
    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    @Column(name = "FechaDeNacimiento")
    public Timestamp getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Timestamp fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    @Column(name = "IdRol")
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
}