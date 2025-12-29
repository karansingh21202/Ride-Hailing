package com.ridehailing.repository;

import com.ridehailing.util.JPAUtil;
import com.ridehailing.model.Rating;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class RatingRepository {

    // Save a new rating
    public void save(Rating rating) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rating);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Find rating by ID
    public Rating findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Rating.class, id);
        } finally {
            em.close();
        }
    }

    // Get all ratings
    public List<Rating> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Rating> query = em.createQuery("SELECT r FROM Rating r", Rating.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Update rating
    public void update(Rating rating) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(rating);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Delete rating by ID
    public void delete(Long ratingId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Rating rating = em.find(Rating.class, ratingId);
            if (rating != null) {
                em.remove(rating);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
