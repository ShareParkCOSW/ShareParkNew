package project.certificados.services;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;
import project.certificados.entities.Admin;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@Service

public class AdminServicesImplORM implements AdminServices{

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
    public List<Admin> getAdmins() {
        //TODO
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Criteria criteria = se.createCriteria(Admin.class);
        List<Admin> ans = criteria.list();
        tx.commit();
        se.close();
        sf.close();
        return ans;
    }

    @Override
    public void addAdmin(Admin admin) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Admin", admin);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public Admin getAdmin(Integer id) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        return (Admin) se.load("project.certificados.entities.Admin", id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Admin", admin);
        tx.commit();
        se.close();
        sf.close();
    }
}
