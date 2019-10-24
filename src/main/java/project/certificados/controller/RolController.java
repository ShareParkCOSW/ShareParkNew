package project.certificados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.certificados.entities.Rol;
import project.certificados.services.RolServices;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST ROLES FUNCIONA!!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Rol> getRoles(){
        return services.getRoles();
    }

    @RequestMapping(value = "/{idrol}", method = RequestMethod.GET)
    public Rol getRol(@PathVariable("idrol") Integer idrol){
        return services.getRol(idrol);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postRol(@RequestBody(required = true) Rol rol){
        services.addRol(rol);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
