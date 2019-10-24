package project.certificados.services;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;
import project.certificados.entities.Funcionario;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@Service

public class FuncionarioServicesImplORM implements FuncionarioServices{

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
    public List<Funcionario> getFuncionarios() {
        //TODO
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        Criteria criteria = se.createCriteria(Funcionario.class);
        List<Funcionario> ans = criteria.list();
        tx.commit();
        se.close();
        sf.close();
        return ans;
    }

    @Override
    public void addFuncionario(Funcionario Funcionario) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Funcionario", Funcionario);
        tx.commit();
        se.close();
        sf.close();
    }

    @Override
    public Funcionario getFuncionario(Integer id) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        return (Funcionario) se.load("project.certificados.entities.Funcionario", id);
    }

    @Override
    public void updateFuncionario(Funcionario Funcionario) {
        SessionFactory sf=getSessionFactory();
        Session se=sf.openSession();
        Transaction tx=se.beginTransaction();
        se.saveOrUpdate("Funcionario", Funcionario);
        tx.commit();
        se.close();
        sf.close();
    }
}
