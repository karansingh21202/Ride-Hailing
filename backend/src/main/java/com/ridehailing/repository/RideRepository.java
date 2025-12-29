package com.ridehailing.repository;

import com.ridehailing.model.Ride;
import com.ridehailing.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RideRepository {

    public void save(Ride ride) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(ride);
            tx.commit();
        }
    }

    public Ride findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Ride.class, id);
        }
    }

    public List<Ride> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Ride", Ride.class).list();
        }
    }

    public void update(Ride ride) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(ride);
            tx.commit();
        }
    }

    public void delete(Ride ride) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(ride);
            tx.commit();
        }
    }
}
