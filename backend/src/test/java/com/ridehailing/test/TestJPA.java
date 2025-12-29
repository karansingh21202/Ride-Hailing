package com;

import com.ridehailing.util.JPAUtil;
import com.ridehailing.model.*;
import com.ridehailing.repository.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestJPA {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            // ===== USER =====
            User rider = new User();
            rider.setFullName("Test Rider");
            rider.setEmail("rider@test.com");
            rider.setPhone("9000000001");
            rider.setPassword("hashed_password");
            rider.setRole("RIDER");
            em.persist(rider);

            User driver = new User();
            driver.setFullName("Test Driver");
            driver.setEmail("driver@test.com");
            driver.setPhone("9000000002");
            driver.setPassword("hashed_password");
            driver.setRole("DRIVER");
            driver.setLicenseNumber("LIC12345");
            em.persist(driver);

            // ===== VEHICLE =====
            Vehicle vehicle = new Vehicle();
            vehicle.setDriver(driver);
            vehicle.setMake("Toyota");
            vehicle.setModel("Corolla");
            vehicle.setPlateNumber("TN01AB1234");
            vehicle.setColor("Blue");
            vehicle.setYear(2021);
            em.persist(vehicle);

            // ===== RIDE =====
            Ride ride = new Ride();
            ride.setRider(rider);
            ride.setDriver(driver);
            ride.setPickupLocation("MG Road, Patna");
            ride.setDropLocation("Boring Road, Patna");
            ride.setStatus("COMPLETED");
            ride.setStartTime(LocalDateTime.now().minusMinutes(30));
            ride.setEndTime(LocalDateTime.now());
            ride.setFare(new BigDecimal("250.00"));
            em.persist(ride);

            // ===== PAYMENT =====
            Payment payment = new Payment();
            payment.setRide(ride);
            payment.setAmount(new BigDecimal("250.00"));
            payment.setMethod("CASH");
            payment.setStatus("COMPLETED");
            payment.setPaymentDate(LocalDateTime.now());
            em.persist(payment);

            // ===== RATING =====
            Rating rating = new Rating();
            rating.setRide(ride);
            rating.setGivenBy(rider);
            rating.setGivenTo(driver);
            rating.setScore(5);
            rating.setComment("Excellent ride");
            em.persist(rating);

            em.getTransaction().commit();

            System.out.println("✅ JPA TEST SUCCESSFUL — DATA INSERTED");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            JPAUtil.close();
        }
    }
}
