package ru.ilia.soap.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by ILIA on 26.01.2017.
 */
public class DAO {

    private static final SessionFactory sessionFactory = configureSessionFactory();

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }






    protected DAO() {
    }

    private  Session session;

    protected  Session getSession() {
        return session;
    }


    protected void begin() {
        session = DAO.getSessionFactory().getCurrentSession();
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
//            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
//            log.log(Level.WARNING, "Cannot close", e);
        }
    }

    public void close() {
        getSession().close();
    }
}
