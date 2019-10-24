package project.certificados.services;

import project.certificados.entities.TipoDeIdentificacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandra.
 */
//@Service
public class TipoDeIdentificacionServicesImpl1 implements TipoDeIdentificacionServices{


    private List<TipoDeIdentificacion> tiposDeIdentificacion=new ArrayList<>();
    @Override
    public List<TipoDeIdentificacion> getTiposDeIdentificacion() {
        return tiposDeIdentificacion;
    }

    @Override
    public void addTipoDeIdentificacion(TipoDeIdentificacion tipoDeIdentificacion) {
        tiposDeIdentificacion.add(tipoDeIdentificacion);
    }

    @Override
    public TipoDeIdentificacion getTipoDeIdentificacion(Integer id) {
        TipoDeIdentificacion ans=null;
        for (TipoDeIdentificacion tipoDeIdentificacion:tiposDeIdentificacion) {
            if(tipoDeIdentificacion.getIdTipoDeIdentificacion()==id){
                ans=tipoDeIdentificacion;
                break;
            }
        }
        return ans;
    }

    @Override
    public void updateTipoDeIdentificacion(TipoDeIdentificacion tipoDeIdentificacion) {
        for (TipoDeIdentificacion tipoDeIdentificacion0 : tiposDeIdentificacion) {
            if(tipoDeIdentificacion0.getIdTipoDeIdentificacion()==tipoDeIdentificacion.getIdTipoDeIdentificacion()){
                tipoDeIdentificacion0=tipoDeIdentificacion;
                break;
            }
        }
    }
}
