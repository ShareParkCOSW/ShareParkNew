package project.certificados.services;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;
import project.certificados.entities.Informe;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@Service

public class InformeServicesImplORM implements InformeServices{

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
    public List<Informe> getInformes() {
        //TODO
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Criteria criteria = se.createCriteria(Informe.class);
        List<Informe> ans = criteria.list();
        tx.commit();
        se.close();
        sf.close();
        return ans;
    }

    @Override
    public void addInforme(Informe Informe) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Informe", Informe);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public Informe getInforme(Integer id) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        return (Informe) se.load("project.certificados.entities.Informe", id);
    }

    @Override
    public void updateInforme(Informe Informe) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Informe", Informe);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public Informe getInformeSpecific(Integer idEstudiante, Integer año, String curso) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Query query= se.createQuery("from Informe where IdEstudiante=:idEstudiante AND Anio=:anio AND Curso=:curso");
        query.setParameter("idEstudiante", idEstudiante);
        query.setParameter("anio", año);
        query.setParameter("curso", curso);
        return (Informe) query.list().get(0);
    }
}
