package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.Vehicle;

import java.util.List;

/**
 *
 * @author felipe
 */
public interface VehicleServices {
    
    public List<Vehicle> getVehicles();
    public void addVehicle(Vehicle v);
    public List<Vehicle> getVehicleUserId(Integer id);
    //public void deletVehicle(Vehicle v);
    
}
