package com.ridehailing.service;

import com.ridehailing.model.Ride;
import com.ridehailing.model.User;
import com.ridehailing.repository.RideRepository;

import java.util.List;

public class RideService {

    private final RideRepository rideRepository = new RideRepository();

    // Save or request a ride
    public boolean saveOrUpdateRide(Ride ride) {
        try {
            if (ride.getRideId() == null) {
                rideRepository.save(ride); // New ride
            } else {
                rideRepository.update(ride); // Existing ride
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get ride by ID
    public Ride getRideById(Long id) {
        return rideRepository.findById(id);
    }

    // Get all rides
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    // Get rides by rider
    public List<Ride> getRidesByRider(User rider) {
        return rideRepository.findAll().stream()
                .filter(r -> r.getRider().getUserId().equals(rider.getUserId()))
                .toList();
    }

    // Get rides by driver
    public List<Ride> getRidesByDriver(User driver) {
        return rideRepository.findAll().stream()
                .filter(r -> r.getDriver().getUserId().equals(driver.getUserId()))
                .toList();
    }

    // Delete ride by ID
    public boolean deleteRide(Long rideId) {
        try {
            Ride ride = rideRepository.findById(rideId);
            if (ride != null) {
                rideRepository.delete(rideId);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
