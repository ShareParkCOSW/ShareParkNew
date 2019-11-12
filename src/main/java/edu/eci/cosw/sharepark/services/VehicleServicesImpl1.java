package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.Vehicle;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author felipe
 */
public class VehicleServicesImpl1 implements VehicleServices{
    
    @Autowired
    private UserServices us;
    
    private List<Vehicle> vehicles=new ArrayList<>();  

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public void addVehicle(Vehicle v) {
        vehicles.add(v);        
    }

    @Override
    public List<Vehicle> getVehicleUserId(Integer id) {
        return us.getUser(id).getVehicles();
    }

    @Override
    public Vehicle getVehicle(String plate) {
        Vehicle ans=null;
        for (Vehicle u:vehicles) {
            if(u.getPlate().equals(plate)){
                ans=u;
                break;
            }
        }
        return ans;
    }

    /*@Override
    public void deletVehicle(Vehicle v) {
        vehicles.remove(v);
    }*/
}
