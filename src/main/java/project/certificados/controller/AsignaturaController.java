package project.certificados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.certificados.entities.Asignatura;
import project.certificados.services.AsignaturaServices;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST ASIGNATURAS FUNCIONA!!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Asignatura> getAsignaturas(){
        return services.getAsignaturas();
    }

    @RequestMapping(value = "/{idarea}", method = RequestMethod.GET)
    public List<Asignatura> getAsignaturasByIdArea(@PathVariable("idarea") Integer idarea){
        return services.getAsignaturasByArea(idarea);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postAsignatura(@RequestBody(required = true) Asignatura asignatura){
        services.addAsignatura(asignatura);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
