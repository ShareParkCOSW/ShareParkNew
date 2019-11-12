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
@Table(name = "Admin")
public class Admin implements Serializable{
    public Admin() {
    }

    private String idAdmin=null;
    private Integer idTipoDeIdentificacion=null;
    private String numeroDeIdentificacion=null;
    private String nombre=null;
    private String password=null;
    private String userName=null;

    @Id
    @Column(name = "IdAdmin")
    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
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

    @Column(name = "Contrasena")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "NombreDeUsuario")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
