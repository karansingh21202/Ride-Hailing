package com.ridehailing.repository;

import com.ridehailing.util.JPAUtil;
import com.ridehailing.model.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class VehicleRepository {

    // Save a vehicle
    public void save(Vehicle vehicle) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(vehicle);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Find vehicle by ID
    public Vehicle findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Vehicle.class, id);
        } finally {
            em.close();
        }
    }

    // Find all vehicles
    public List<Vehicle> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Vehicle> query = em.createQuery("SELECT v FROM Vehicle v", Vehicle.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Find vehicle by driver ID
    public Vehicle findByDriverId(Long driverId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Vehicle> query = em.createQuery(
                    "SELECT v FROM Vehicle v WHERE v.driver.userId = :driverId",
                    Vehicle.class
            );
            query.setParameter("driverId", driverId);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    // Update a vehicle
    public void update(Vehicle vehicle) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(vehicle);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Delete a vehicle by object
    public void delete(Vehicle vehicle) {
        if (vehicle == null) return;
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            // Attach the entity if it's detached
            if (!em.contains(vehicle)) {
                vehicle = em.merge(vehicle);
            }
            em.remove(vehicle);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
