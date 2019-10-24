package project.certificados.services;

import project.certificados.entities.Calificacion;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
public interface CalificacionServices {
    public List<Calificacion> getCalificaciones();
    public void addCalificacion(Calificacion calificacion);
    public Calificacion getCalificacion(Integer id);
    public void updateCalificacion(Calificacion calificacion);
    public List<Calificacion> getCalificacionesByInforme(Integer idInforme);
}
