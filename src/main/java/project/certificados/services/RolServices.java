package project.certificados.services;

import project.certificados.entities.Rol;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
public interface RolServices {
    public List<Rol> getRoles();
    public void addRol(Rol rol);
    public Rol getRol(Integer id);
    public void updateRol(Rol rol);
}
