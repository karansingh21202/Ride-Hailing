package com.ridehailing.repository;

import com.ridehailing.model.Vehicle;
import com.ridehailing.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehicleRepository {

    public void save(Vehicle vehicle) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(vehicle);
            tx.commit();
        }
    }

    public Vehicle findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Vehicle.class, id);
        }
    }

    public List<Vehicle> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Vehicle", Vehicle.class).list();
        }
    }

    public Vehicle findByDriverId(Long driverId) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Vehicle vehicle = session.createQuery("FROM Vehicle WHERE driver.userId = :driverId", Vehicle.class)
                             .setParameter("driverId", driverId)
                             .uniqueResult();
    session.close();
    return vehicle;
}

    public void update(Vehicle vehicle) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(vehicle);
            tx.commit();
        }
    }

    public void delete(Vehicle vehicle) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(vehicle);
            tx.commit();
        }
    }
}
