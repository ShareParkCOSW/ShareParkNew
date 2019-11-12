package project.certificados.services;

import project.certificados.entities.Calificacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandra.
 */
//@Service
public class CalificacionServicesImpl1 implements CalificacionServices{

    private InformeServices informeServices;
    private List<Calificacion> calificaciones=new ArrayList<>();
    @Override
    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    @Override
    public void addCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }

    @Override
    public Calificacion getCalificacion(Integer id) {
        Calificacion ans=null;
        for (Calificacion calificacion:calificaciones) {
            if(calificacion.getIdCalificacion()==id){
                ans=calificacion;
                break;
            }
        }
        return ans;
    }

    @Override
    public void updateCalificacion(Calificacion calificacion) {
        for (Calificacion calificacion0 : calificaciones) {
            if(calificacion0.getIdCalificacion()==calificacion.getIdCalificacion()){
                calificacion0=calificacion;
                break;
            }
        }
    }

    @Override
    public List<Calificacion> getCalificacionesByInforme(Integer idInforme) {
        return informeServices.getInforme(idInforme).getCalificaciones();
    }
}
