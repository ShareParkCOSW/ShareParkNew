package project.certificados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.certificados.entities.Estudiante;
import project.certificados.services.EstudianteServices;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST ESTUDIANTES FUNCIONA!!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Estudiante> getEstudiantes(){
        return services.getEstudiantes();
    }

    @RequestMapping(value = "/{idestudiante}", method = RequestMethod.GET)
    public Estudiante getEstudiante(@PathVariable("idestudiante") String idestudiante){
        return services.getEstudiante(idestudiante);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> postEstudiante(@RequestBody(required = true) Estudiante estudiante){
        services.addEstudiante(estudiante);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateEstudiante(@RequestBody(required = true) Estudiante estudiante){
        services.updateEstudiante(estudiante);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
