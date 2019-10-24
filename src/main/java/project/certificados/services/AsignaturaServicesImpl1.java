package project.certificados.services;

import project.certificados.entities.Area;
import project.certificados.entities.Asignatura;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandra.
 */
//@Service
public class AsignaturaServicesImpl1 implements AsignaturaServices{

    private AreaServices areaServices;
    private List<Asignatura> asignaturas=new ArrayList<>();
    @Override
    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    @Override
    public void addAsignatura(Asignatura asignatura) {
       asignaturas.add(asignatura);
    }

    @Override
    public Asignatura getAsignatura(Integer id) {
        Asignatura ans=null;
        for (Asignatura asignatura:asignaturas) {
            if(asignatura.getIdAsignatura()==id){
                ans=asignatura;
                break;
            }
        }
        return ans;
    }

    @Override
    public void updateAsignatura(Asignatura asignatura) {
        for (Asignatura asignatura0 : asignaturas) {
            if(asignatura0.getIdAsignatura()==asignatura.getIdAsignatura()){
                asignatura0=asignatura;
                break;
            }
        }
    }

    @Override
    public List<Asignatura> getAsignaturasByArea(Integer idArea) {
        return areaServices.getArea(idArea).getAsignaturas();
    }
}
