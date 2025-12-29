package com.ridehailing.service;

import com.ridehailing.model.Ride;
import com.ridehailing.model.User;
import com.ridehailing.repository.RideRepository;

import java.util.List;

public class RideService {

    private final RideRepository rideRepository = new RideRepository();

    public void requestRide(Ride ride) {
        rideRepository.save(ride);
    }

    public Ride getRideById(Long id) {
        return rideRepository.findById(id);
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public List<Ride> getRidesByRider(User rider) {
        return rideRepository.findAll().stream()
                .filter(r -> r.getRider().getUserId().equals(rider.getUserId()))
                .toList();
    }

    public List<Ride> getRidesByDriver(User driver) {
        return rideRepository.findAll().stream()
                .filter(r -> r.getDriver().getUserId().equals(driver.getUserId()))
                .toList();
    }

    public void updateRide(Ride ride) {
        rideRepository.update(ride);
    }

    public void deleteRide(Ride ride) {
        rideRepository.delete(ride);
    }
}
