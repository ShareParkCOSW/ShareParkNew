package project.certificados.services;

import project.certificados.entities.Admin;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
public interface AdminServices {
    public List<Admin> getAdmins();
    public void addAdmin(Admin admin);
    public Admin getAdmin(Integer id);
    public void updateAdmin(Admin admin);
}
