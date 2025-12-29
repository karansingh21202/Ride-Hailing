package com.ridehailing.repository;

import com.ridehailing.model.User;
import com.ridehailing.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserRepository {

    public void save(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        }
    }

    public User findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        }
    }

    public User findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    public List<User> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).list();
        }
    }

    public void update(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(user);
            tx.commit();
        }
    }

    public void delete(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(user);
            tx.commit();
        }
    }
}
