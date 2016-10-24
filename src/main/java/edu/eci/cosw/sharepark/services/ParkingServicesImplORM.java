package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.Parking;
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
 * Created by alejandra on 23/10/16.
 */
@Service
public class ParkingServicesImplORM implements ParkingServices {

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
    public void addParking(Parking p) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("parkings", p);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public void updateParking(Parking p) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("parkings", p);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public List<Parking> getParkings() {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Criteria criteria = se.createCriteria(Parking.class);
        List<Parking> ans = criteria.list();
        tx.commit();
        se.close();
        sf.close();
        return ans;
    }

    @Override
    public List<Parking> getParkingsByUserId(Integer id) {
        throw new NotYetImplementedException();
    }
}
