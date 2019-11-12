package project.certificados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.certificados.entities.TipoDeIdentificacion;
import project.certificados.services.TipoDeIdentificacionServices;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@RestController
@RequestMapping("/tiposdeidentificacion")
public class TipoDeIdentificacionController {
    @Autowired
    private TipoDeIdentificacionServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST TIPOS DE IDENTIFICACION FUNCIONA!!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TipoDeIdentificacion> getTiposDeIdentificacion(){
        return services.getTiposDeIdentificacion();
    }

    @RequestMapping(value = "/{idtipodeidentificacion}", method = RequestMethod.GET)
    public TipoDeIdentificacion getTipoDeIdentificacion(@PathVariable("idtipodeidentificacion") Integer idtipodeidentificacion){
        return services.getTipoDeIdentificacion(idtipodeidentificacion);
    }

    @RequestMapping(value = "/sigla/{sigla}", method = RequestMethod.GET)
    public TipoDeIdentificacion getTipoDeIdentificacion(@PathVariable("sigla") String sigla){
        return services.getTipoDeIdentificacion(sigla);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> postTipoDeIdentificacion(@RequestBody(required = true) TipoDeIdentificacion tipoDeIdentificacion){
        services.addTipoDeIdentificacion(tipoDeIdentificacion);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateTipoDeIdentificacion(@RequestBody(required = true) TipoDeIdentificacion tipoDeIdentificacion){
        services.updateTipoDeIdentificacion(tipoDeIdentificacion);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
