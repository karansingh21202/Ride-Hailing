package com.ridehailing.repository;

import com.ridehailing.util.JPAUtil;
import com.ridehailing.model.Ride;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class RideRepository {

    // Save a new ride
    public void save(Ride ride) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ride);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Find ride by ID
    public Ride findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Ride.class, id);
        } finally {
            em.close();
        }
    }

    // Get all rides
    public List<Ride> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Ride> query = em.createQuery("SELECT r FROM Ride r", Ride.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Update ride
    public void update(Ride ride) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ride);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Delete ride by ID
    public void delete(Long rideId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Ride ride = em.find(Ride.class, rideId);
            if (ride != null) {
                em.remove(ride);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
