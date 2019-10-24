package project.certificados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.certificados.entities.Area;
import project.certificados.services.AreaServices;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@RestController
@RequestMapping("/areas")
public class AreaController {
    @Autowired
    private AreaServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST AREAS FUNCIONA!!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Area> getAreas(){
        return services.getAreas();
    }

    @RequestMapping(value = "/{idarea}", method = RequestMethod.GET)
    public Area getArea(@PathVariable("idarea") Integer idarea){
        return services.getArea(idarea);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postArea(@RequestBody(required = true) Area area){
        services.addArea(area);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
