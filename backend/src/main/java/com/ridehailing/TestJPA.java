package com.ridehailing;

import com.ridehailing.util.JPAUtil;
import com.ridehailing.model.User;
import com.ridehailing.model.Ride;
import com.ridehailing.model.Role;
import com.ridehailing.model.RideStatus;
import com.ridehailing.model.Vehicle;
import com.ridehailing.model.Payment;
import com.ridehailing.model.PaymentMethod;
import com.ridehailing.model.PaymentStatus;
import com.ridehailing.model.Rating;

// import com.ridehailing.repository.*;

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
            rider.setRole(Role.RIDER);  // ✅ Use enum
            em.persist(rider);

            User driver = new User();
            driver.setFullName("Test Driver");
            driver.setEmail("driver@test.com");
            driver.setPhone("9000000002");
            driver.setPassword("hashed_password");
            driver.setRole(Role.DRIVER);  // ✅ Use enum
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
            ride.setStatus(RideStatus.COMPLETED);  // ✅ Use enum
            ride.setStartTime(LocalDateTime.now().minusMinutes(30));
            ride.setEndTime(LocalDateTime.now());
            ride.setFare(new BigDecimal("250.00").doubleValue());
            em.persist(ride);

            // ===== PAYMENT =====
            Payment payment = new Payment();
            payment.setRide(ride);
            payment.setAmount(new BigDecimal("250.00").doubleValue());
            payment.setMethod(PaymentMethod.CASH); // ✅ Use enum if PaymentMethod exists
            payment.setStatus(PaymentStatus.COMPLETED); // ✅ Use enum if PaymentStatus exists
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
        }
    }
}
