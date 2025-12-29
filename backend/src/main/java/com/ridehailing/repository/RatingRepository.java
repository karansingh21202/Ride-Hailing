package com.ridehailing.repository;

import com.ridehailing.model.Rating;
import com.ridehailing.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RatingRepository {

    public void save(Rating rating) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(rating);
            tx.commit();
        }
    }

    public Rating findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Rating.class, id);
        }
    }

    public List<Rating> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Rating", Rating.class).list();
        }
    }

    public void update(Rating rating) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(rating);
            tx.commit();
        }
    }

    public void delete(Rating rating) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(rating);
            tx.commit();
        }
    }
}
