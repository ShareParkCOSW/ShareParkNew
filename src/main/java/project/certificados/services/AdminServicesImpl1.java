package project.certificados.services;

import project.certificados.entities.Admin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandra.
 */
//@Service
public class AdminServicesImpl1 implements AdminServices{


    private List<Admin> admins=new ArrayList<>();
    @Override
    public List<Admin> getAdmins() {
        return admins;
    }

    @Override
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    @Override
    public Admin getAdmin(Integer id) {
        Admin ans=null;
        for (Admin admin:admins) {
            if(admin.getIdAdmin()==id){
                ans=admin;
                break;
            }
        }
        return ans;
    }

    @Override
    public void updateAdmin(Admin admin) {
        for (Admin admin0 : admins) {
            if(admin0.getIdAdmin()==admin.getIdAdmin()){
                admin0=admin;
                break;
            }
        }
    }
}
