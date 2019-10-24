package project.certificados.services;

import project.certificados.entities.Asignatura;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
public interface AsignaturaServices {
    public List<Asignatura> getAsignaturas();
    public void addAsignatura(Asignatura asignatura);
    public Asignatura getAsignatura(Integer id);
    public void updateAsignatura(Asignatura asignatura);
    public List<Asignatura> getAsignaturasByArea(Integer idArea);
}
