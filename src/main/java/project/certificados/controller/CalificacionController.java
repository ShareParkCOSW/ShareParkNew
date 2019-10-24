package project.certificados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.certificados.entities.Calificacion;
import project.certificados.services.CalificacionServices;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST CALIFICACIONES FUNCIONA!!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Calificacion> getCalificaciones(){
        return services.getCalificaciones();
    }

    @RequestMapping(value = "/{idinforme}", method = RequestMethod.GET)
    public List<Calificacion> getCalificacionesByIdInforme(@PathVariable("idinforme") Integer idinforme){
        return services.getCalificacionesByInforme(idinforme);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postCalificacion(@RequestBody(required = true) Calificacion calificacion){
        services.addCalificacion(calificacion);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
