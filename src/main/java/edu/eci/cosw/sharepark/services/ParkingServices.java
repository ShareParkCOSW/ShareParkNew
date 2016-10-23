package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.Parking;

import java.util.List;

/**
 * Created by alejandra on 27/09/16.
 */
public interface ParkingServices {

    public List<Parking> getParkings();
    public void addParking(Parking p);
    public List<Parking> getParkingsByUserId(Integer id);
}
