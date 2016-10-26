package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.Parking;
import edu.eci.cosw.sharepark.entities.Vehicle;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author felipe
 */
@Service
public class VehicleSevicesImplORM implements VehicleServices{
    
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

    @Override
    public List<Vehicle> getVehicles() {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Criteria criteria = se.createCriteria(Vehicle.class);
        List<Vehicle> ans = criteria.list();
        tx.commit();
        se.close();
        sf.close();
        return ans;
    }

    @Override
    public void addVehicle(Vehicle v) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("vehicles", v);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public List<Vehicle> getVehicleUserId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehicle getVehicle(String plate) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        return (Vehicle) se.load("edu.eci.cosw.sharepark.entities.Vehicle", plate);}

    /*@Override
    public void deletVehicle(Vehicle v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
