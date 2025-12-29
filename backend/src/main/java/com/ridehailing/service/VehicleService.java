package com.ridehailing.service;

import com.ridehailing.model.Vehicle;
import com.ridehailing.repository.VehicleRepository;

import java.util.List;

public class VehicleService {

    private final VehicleRepository vehicleRepository = new VehicleRepository();

    // Save or update a vehicle
    public boolean saveOrUpdateVehicle(Vehicle vehicle) {
        try {
            if (vehicle.getVehicleId() == null) {
                vehicleRepository.save(vehicle); // New vehicle
            } else {
                vehicleRepository.update(vehicle); // Existing vehicle
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get vehicle by ID
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    // Get all vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Delete vehicle
    public boolean deleteVehicle(Long vehicleId) {
        try {
            Vehicle vehicle = vehicleRepository.findById(vehicleId);
            if (vehicle != null) {
                vehicleRepository.delete(vehicle);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get vehicle by driver ID (optional convenience method)
    public Vehicle getVehicleByDriverId(Long driverId) {
        return vehicleRepository.findByDriverId(driverId);
    }
}
