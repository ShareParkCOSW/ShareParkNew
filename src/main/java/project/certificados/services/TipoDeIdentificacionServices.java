package project.certificados.services;

import project.certificados.entities.TipoDeIdentificacion;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
public interface TipoDeIdentificacionServices {
    public List<TipoDeIdentificacion> getTiposDeIdentificacion();
    public void addTipoDeIdentificacion(TipoDeIdentificacion tipoDeIdentificacion);
    public TipoDeIdentificacion getTipoDeIdentificacion(Integer id);
    public TipoDeIdentificacion getTipoDeIdentificacion(String sigla);
    public void updateTipoDeIdentificacion(TipoDeIdentificacion tipoDeIdentificacion);
}
