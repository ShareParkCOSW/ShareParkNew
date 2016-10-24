package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.Parking;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alejandra on 27/09/16.
 */
public class ParkingServicesImpl1 implements ParkingServices {

    @Autowired
    private UserServices us;

    public static SessionFactory getSessionFactory() {
        // loads configuration and mappings
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    private List<Parking> parkings=new ArrayList<>();

    @Override
    public void updateParking(Parking p) {
        for (Parking park : parkings) {
            if(park.getAddress().equals(p.getAddress())){
                park=p;
                break;
            }
        }
    }

    @Override
    public List<Parking> getParkings() {
        return parkings;
    }

    @Override
    public void addParking(Parking p) {
        parkings.add(p);
    }

    @Override
    public List<Parking> getParkingsByUserId(Integer userId) {
        return us.getUser(userId).getParkings();
    }
}
