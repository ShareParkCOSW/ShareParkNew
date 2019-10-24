package project.certificados.services;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;
import project.certificados.entities.Rol;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@Service

public class RolServicesImplORM implements RolServices{

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
    public List<Rol> getRoles() {
        //TODO
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Criteria criteria = se.createCriteria(Rol.class);
        List<Rol> ans = criteria.list();
        tx.commit();
        se.close();
        sf.close();
        return ans;
    }

    @Override
    public void addRol(Rol Rol) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Rol", Rol);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public Rol getRol(Integer id) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        return (Rol) se.load("project.certificados.entities.Rol", id);
    }

    @Override
    public void updateRol(Rol Rol) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Rol", Rol);
        tx.commit();
        se.close();
        sf.close();
    }
}
