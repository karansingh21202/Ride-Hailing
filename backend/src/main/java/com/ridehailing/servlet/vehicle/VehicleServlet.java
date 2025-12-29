package com.ridehailing.servlet.vehicle;

import com.ridehailing.service.VehicleService;
import com.ridehailing.model.Vehicle;
import com.ridehailing.util.JsonUtil;
import com.ridehailing.dto.response.ApiResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/vehicle/*")
public class VehicleServlet extends HttpServlet {

    private final VehicleService vehicleService = new VehicleService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create or update vehicle
        Vehicle vehicle = JsonUtil.fromJson(request.getReader(), Vehicle.class);
        boolean saved = vehicleService.saveOrUpdateVehicle(vehicle);

        ApiResponse apiResponse = saved ?
                new ApiResponse(true, "Vehicle saved successfully") :
                new ApiResponse(false, "Failed to save vehicle");

        JsonUtil.sendJson(response, apiResponse);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get vehicle(s)
        String driverIdParam = request.getParameter("driverId");
        if (driverIdParam != null) {
            Long driverId = Long.parseLong(driverIdParam);
            Vehicle vehicle = vehicleService.getVehicleByDriverId(driverId);
            JsonUtil.sendJson(response, vehicle);
        } else {
            List<Vehicle> vehicles = vehicleService.getAllVehicles();
            JsonUtil.sendJson(response, vehicles);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Delete vehicle
        String vehicleIdParam = request.getParameter("vehicleId");
        boolean deleted = false;
        if (vehicleIdParam != null) {
            Long vehicleId = Long.parseLong(vehicleIdParam);
            deleted = vehicleService.deleteVehicle(vehicleId);
        }

        ApiResponse apiResponse = deleted ?
                new ApiResponse(true, "Vehicle deleted successfully") :
                new ApiResponse(false, "Failed to delete vehicle");

        JsonUtil.sendJson(response, apiResponse);
    }
}
