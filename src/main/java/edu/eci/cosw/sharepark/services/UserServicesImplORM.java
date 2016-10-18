
package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.User;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Andrés Felipe on 18/10/2016.
 */
//@Service
/**
public class UserServicesImplORM implements UserServices{
    @Autowired
    UsersRepository repo;
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
    public List<User> getUsers() {
        return repo.findAll();
    }

    @Override
    public void addUser(User u) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("users", u);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public User getUser(Integer id) {
        return repo.findOne(id);
    }

    @Override
    public void updateUser(User u) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("users", u);
        tx.commit();
        se.close();
        sf.close();
    }
}
*/
