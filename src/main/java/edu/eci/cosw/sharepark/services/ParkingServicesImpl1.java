package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.Parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alejandra on 27/09/16.
 */
public class ParkingServicesImpl1 implements ParkingServices {

    private List<Parking> parkings=new ArrayList<>();

    @Override
    public List<Parking> getParkings() {
        return parkings;
    }

    @Override
    public void addParking(Parking p) {
        parkings.add(p);
    }

    @Override
    public Parking getParkingByUserId(Integer userId) {
        Parking ans=null;
        for (Parking u:parkings) {
            if(u.getOwnerId()==userId){
                ans=u;
                break;
            }
        }
        return ans;
    }
}
