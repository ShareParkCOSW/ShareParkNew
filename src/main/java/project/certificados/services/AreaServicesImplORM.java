package project.certificados.services;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;
import project.certificados.entities.Area;
import project.certificados.entities.Asignatura;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@Service

public class AreaServicesImplORM implements AreaServices{

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
    public List<Area> getAreas() {
        //TODO
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Criteria criteria = se.createCriteria(Area.class);
        List<Area> ans = criteria.list();
        tx.commit();
        se.close();
        sf.close();
        return ans;
    }

    @Override
    public void addArea(Area Area) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Area", Area);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public Area getArea(Integer id) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        return (Area) se.load("project.certificados.entities.Area", id);
    }

    @Override
    public Area getArea(String nombre) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Query query= se.createQuery("from Area where Nombre=:nombre");
        query.setParameter("nombre", nombre);
        return (Area) query.list().get(0);
    }

    @Override
    public void updateArea(Area Area) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Area", Area);
        tx.commit();
        se.close();
        sf.close();
    }
}
