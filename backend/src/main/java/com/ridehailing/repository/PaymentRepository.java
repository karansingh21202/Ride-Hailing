package com.ridehailing.repository;

import com.ridehailing.util.JPAUtil;
import com.ridehailing.model.Payment;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PaymentRepository {

    public void save(Payment payment) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(payment);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Payment findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Payment.class, id);
        } finally {
            em.close();
        }
    }

    public List<Payment> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Payment> query =
                    em.createQuery("SELECT p FROM Payment p", Payment.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Payment payment) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(payment);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Updated to accept Payment object
    public void delete(Payment payment) {
        if (payment == null) return;
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Payment managedPayment = em.find(Payment.class, payment.getPaymentId());
            if (managedPayment != null) {
                em.remove(managedPayment);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
