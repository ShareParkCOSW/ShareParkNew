package edu.eci.cosw.sharepark.controller;

import edu.eci.cosw.sharepark.entities.Parking;
import edu.eci.cosw.sharepark.services.ParkingServices;
import edu.eci.cosw.sharepark.services.ParkingServicesImpl1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alejandra on 28/09/16.
 */
@RestController
@RequestMapping("/parkings")
public class ParkingController {

    @Autowired
    private ParkingServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST ESTACIONAMIENTOS FUNCIONA!!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Parking> getParkings(){
        return services.getParkings();
    }

    @RequestMapping(value = "/{iduser}", method = RequestMethod.GET)
    public List<Parking> getParkingsByUserID(@PathVariable("iduser") Integer iduser){
        return services.getParkingsByUserId(iduser);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postParking(@RequestBody(required = true) Parking p){
        services.addParking(p);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
