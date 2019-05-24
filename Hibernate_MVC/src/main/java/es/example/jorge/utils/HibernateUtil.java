package es.example.jorge.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() throws Exception {

        try {
            if (sessionFactory == null) {
                sessionFactory = new Configuration().configure()
                        .buildSessionFactory();
            }
        } catch (Exception ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new Exception(ex);
        }

        return sessionFactory;
    }

    public static Session getSession() throws Exception {
        return getSessionFactory().openSession();
    }

}
