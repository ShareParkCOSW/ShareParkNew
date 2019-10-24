package project.certificados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.certificados.entities.Informe;
import project.certificados.services.InformeServices;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@RestController
@RequestMapping("/informes")
public class InformeController {

    @Autowired
    private InformeServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST INFORMES FUNCIONA!!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Informe> getInformes(){
        return services.getInformes();
    }

    @RequestMapping(value = "/{idestudiante}/{anio}/{curso}", method = RequestMethod.GET)
    public Informe getInformeSpecific(@PathVariable("idestudiante") Integer idestudiante,@PathVariable("anio") Integer anio,@PathVariable("curso") String curso){
        return services.getInformeSpecific(idestudiante,anio,curso);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postInforme(@RequestBody(required = true) Informe informe){
        services.addInforme(informe);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
