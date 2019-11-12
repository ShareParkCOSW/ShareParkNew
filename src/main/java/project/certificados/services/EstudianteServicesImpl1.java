package project.certificados.services;

import project.certificados.entities.Estudiante;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandra.
 */
//@Service
public class EstudianteServicesImpl1 implements EstudianteServices{


    private List<Estudiante> estudiantes=new ArrayList<>();
    @Override
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    @Override
    public void addEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    @Override
    public Estudiante getEstudiante(String id) {
        Estudiante ans=null;
        for (Estudiante estudiante:estudiantes) {
            if(estudiante.getIdEstudiante()==id){
                ans=estudiante;
                break;
            }
        }
        return ans;
    }

    @Override
    public void updateEstudiante(Estudiante estudiante) {
        for (Estudiante estudiante0 : estudiantes) {
            if(estudiante0.getIdEstudiante()==estudiante.getIdEstudiante()){
                estudiante0=estudiante;
                break;
            }
        }
    }
}
