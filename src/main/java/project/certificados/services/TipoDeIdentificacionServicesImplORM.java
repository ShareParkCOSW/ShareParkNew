package project.certificados.services;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;
import project.certificados.entities.TipoDeIdentificacion;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@Service

public class TipoDeIdentificacionServicesImplORM implements TipoDeIdentificacionServices{

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
    public List<TipoDeIdentificacion> getTiposDeIdentificacion() {
        //TODO
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Criteria criteria = se.createCriteria(TipoDeIdentificacion.class);
        List<TipoDeIdentificacion> ans = criteria.list();
        tx.commit();
        se.close();
        sf.close();
        return ans;
    }

    @Override
    public void addTipoDeIdentificacion(TipoDeIdentificacion TipoDeIdentificacion) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("TipoDeIdentificacion", TipoDeIdentificacion);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public TipoDeIdentificacion getTipoDeIdentificacion(Integer id) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        return (TipoDeIdentificacion) se.load("project.certificados.entities.TipoDeIdentificacion", id);
    }

    @Override
    public void updateTipoDeIdentificacion(TipoDeIdentificacion TipoDeIdentificacion) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("TipoDeIdentificacion", TipoDeIdentificacion);
        tx.commit();
        se.close();
        sf.close();
    }
}
