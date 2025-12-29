package com.ridehailing.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ridehailing.model.User;
import com.ridehailing.model.Vehicle;
import com.ridehailing.model.Ride;
import com.ridehailing.model.Payment;
import com.ridehailing.model.Rating;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            // Load hibernate.cfg.xml
            configuration.configure("hibernate.cfg.xml");

            // Register entity classes
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Vehicle.class);
            configuration.addAnnotatedClass(Ride.class);
            configuration.addAnnotatedClass(Payment.class);
            configuration.addAnnotatedClass(Rating.class);

            return configuration.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
