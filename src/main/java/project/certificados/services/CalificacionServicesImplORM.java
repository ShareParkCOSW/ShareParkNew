package project.certificados.services;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;
import project.certificados.entities.Calificacion;
import project.certificados.entities.Informe;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@Service

public class CalificacionServicesImplORM implements CalificacionServices{

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
    public List<Calificacion> getCalificaciones() {
        //TODO
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Criteria criteria = se.createCriteria(Calificacion.class);
        List<Calificacion> ans = criteria.list();
        tx.commit();
        se.close();
        sf.close();
        return ans;
    }

    @Override
    public void addCalificacion(Calificacion Calificacion) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Calificacion", Calificacion);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public Calificacion getCalificacion(Integer id) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        return (Calificacion) se.load("project.certificados.entities.Calificacion", id);
    }

    @Override
    public void updateCalificacion(Calificacion Calificacion) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Calificacion", Calificacion);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public List<Calificacion> getCalificacionesByInforme(Integer idInforme) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Query query= se.createQuery("from Calificacion where IdInforme=:idInforme");
        query.setParameter("idInforme", idInforme);
        return (List<Calificacion>) query.list();
    }
}
