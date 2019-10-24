package project.certificados.services;

import project.certificados.entities.Rol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandra.
 */
//@Service
public class RolServicesImpl1 implements RolServices{


    private List<Rol> roles=new ArrayList<>();
    @Override
    public List<Rol> getRoles() {
        return roles;
    }

    @Override
    public void addRol(Rol rol) {
        roles.add(rol);
    }

    @Override
    public Rol getRol(Integer id) {
        Rol ans=null;
        for (Rol rol:roles) {
            if(rol.getIdRol()==id){
                ans=rol;
                break;
            }
        }
        return ans;
    }

    @Override
    public void updateRol(Rol rol) {
        for (Rol rol0 : roles) {
            if(rol0.getIdRol()==rol.getIdRol()){
                rol0=rol;
                break;
            }
        }
    }
}
