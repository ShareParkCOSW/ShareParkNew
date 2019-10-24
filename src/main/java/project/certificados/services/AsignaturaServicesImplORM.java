package project.certificados.services;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;
import project.certificados.entities.Asignatura;
import project.certificados.entities.Calificacion;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@Service

public class AsignaturaServicesImplORM implements AsignaturaServices{

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
    public List<Asignatura> getAsignaturas() {
        //TODO
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Criteria criteria = se.createCriteria(Asignatura.class);
        List<Asignatura> ans = criteria.list();
        tx.commit();
        se.close();
        sf.close();
        return ans;
    }

    @Override
    public void addAsignatura(Asignatura Asignatura) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Asignatura", Asignatura);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public Asignatura getAsignatura(Integer id) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        return (Asignatura) se.load("project.certificados.entities.Asignatura", id);
    }

    @Override
    public void updateAsignatura(Asignatura Asignatura) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Asignatura", Asignatura);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public List<Asignatura> getAsignaturasByArea(Integer idArea) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Query query= se.createQuery("from Asignatura where IdArea=:idArea");
        query.setParameter("idArea", idArea);
        return (List<Asignatura>) query.list();
    }
}
