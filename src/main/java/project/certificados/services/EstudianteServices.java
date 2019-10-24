package project.certificados.services;

import project.certificados.entities.Estudiante;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
public interface EstudianteServices {
    public List<Estudiante> getEstudiantes();
    public void addEstudiante(Estudiante estudiante);
    public Estudiante getEstudiante(Integer id);
    public void updateEstudiante(Estudiante estudiante);
}
