package com.ridehailing.repository;

import com.ridehailing.model.Payment;
import com.ridehailing.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PaymentRepository {

    public void save(Payment payment) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(payment);
            tx.commit();
        }
    }

    public Payment findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Payment.class, id);
        }
    }

    public List<Payment> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Payment", Payment.class).list();
        }
    }

    public void update(Payment payment) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(payment);
            tx.commit();
        }
    }

    public void delete(Payment payment) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(payment);
            tx.commit();
        }
    }
}
