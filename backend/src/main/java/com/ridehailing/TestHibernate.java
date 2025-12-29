package com.ridehailing;

import com.ridehailing.util.HibernateUtil;
import com.ridehailing.model.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

public class TestHibernate {

    public static void main(String[] args) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            // ================= User =================
            User rider = new User();
            rider.setFullName("Test Rider");
            rider.setEmail("rider@test.com");
            rider.setPhone("9000000001");
            rider.setPassword("hashed_password");
            rider.setRole(Role.RIDER);   // ✅ enum
            session.save(rider);

            User driver = new User();
            driver.setFullName("Test Driver");
            driver.setEmail("driver@test.com");
            driver.setPhone("9000000002");
            driver.setPassword("hashed_password");
            driver.setRole(Role.DRIVER); // ✅ enum
            driver.setLicenseNumber("LIC12345");
            session.save(driver);

            // ================= Vehicle =================
            Vehicle vehicle = new Vehicle();
            vehicle.setDriver(driver);
            vehicle.setMake("Toyota");
            vehicle.setModel("Corolla");
            vehicle.setPlateNumber("TN01AB1234");
            vehicle.setColor("Blue");
            vehicle.setYear(2021);
            session.save(vehicle);

            // ================= Ride =================
            Ride ride = new Ride();
            ride.setRider(rider);
            ride.setDriver(driver);
            ride.setPickupLocation("MG Road, Patna");
            ride.setDropLocation("Boring Road, Patna");
            ride.setStatus(RideStatus.COMPLETED); // ✅ enum
            ride.setStartTime(LocalDateTime.of(2025, 12, 29, 10, 0));
            ride.setEndTime(LocalDateTime.of(2025, 12, 29, 10, 30));
            ride.setFare(250.00); // ✅ Double
            session.save(ride);

            // ================= Payment =================
            Payment payment = new Payment();
            payment.setRide(ride);
            payment.setAmount(250.00);                 // ✅ Double
            payment.setMethod(PaymentMethod.CASH);     // ✅ enum
            payment.setStatus(PaymentStatus.COMPLETED);// ✅ enum
            session.save(payment);

            // ================= Rating =================
            Rating rating = new Rating();
            rating.setRide(ride);
            rating.setGivenBy(rider);
            rating.setGivenTo(driver);
            rating.setScore(5);
            rating.setComment("Excellent ride!");
            session.save(rating);

            tx.commit();
            System.out.println("✅ Data inserted successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}
