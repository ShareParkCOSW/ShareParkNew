package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.CreditCard;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;

/**
 * Created by 2101047 on 10/26/16.
 */
@Service
public class CreditCardServicesImplORM implements CreditCardsServices {

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
        public void addCreditCard(CreditCard c) {
            SessionFactory sf=getSessionFactory();
            Session se=sf.openSession();
            Transaction tx=se.beginTransaction();
            se.saveOrUpdate("credit_cards", c);
            tx.commit();
            se.close();
            sf.close();
        }

        @Override
        public CreditCard getCreditCard(Integer id) {
            SessionFactory sf=getSessionFactory();
            Session se=sf.openSession();
            Transaction tx=se.beginTransaction();
            return (CreditCard) se.load("edu.eci.cosw.sharepark.entities.CreditCard", id);
        }

        @Override
        public void updateCreditCard(CreditCard c) {
            SessionFactory sf=getSessionFactory();
            Session se=sf.openSession();
            Transaction tx=se.beginTransaction();
            se.saveOrUpdate("credit_cards", c);
            tx.commit();
            se.close();
            sf.close();
        }

}
