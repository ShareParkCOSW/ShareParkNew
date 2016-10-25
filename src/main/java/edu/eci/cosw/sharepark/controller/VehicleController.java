/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.sharepark.controller;

import edu.eci.cosw.sharepark.entities.Vehicle;
import edu.eci.cosw.sharepark.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author felipe
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    
    @Autowired
    private VehicleServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST VEHICULOS FUNCIONA!!";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> getVehicles(){
        return services.getVehicles();
    }
    
    @RequestMapping(value = "/{iduser}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleUserId(@PathVariable("iduser") Integer iduser){
        return services.getVehicleUserId(iduser);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postParking(@RequestBody(required = true) Vehicle v){
        services.addVehicle(v);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
