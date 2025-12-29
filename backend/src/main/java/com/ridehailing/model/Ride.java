package com.ridehailing.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rides",
       indexes = {
           @Index(name = "idx_ride_rider", columnList = "rider_id"),
           @Index(name = "idx_ride_driver", columnList = "driver_id"),
           @Index(name = "idx_ride_status", columnList = "status")
       })
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ride_id")
    private Long rideId;

    // Rider (User)
    @ManyToOne
    @JoinColumn(
        name = "rider_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_ride_rider")
    )
    private User rider;

    // Driver (User) — nullable because ride may be requested but not yet accepted
    @ManyToOne
    @JoinColumn(
        name = "driver_id",
        foreignKey = @ForeignKey(name = "fk_ride_driver")
    )
    private User driver;

    @Column(name = "pickup_location", nullable = false, length = 255)
    private String pickupLocation;

    @Column(name = "drop_location", nullable = false, length = 255)
    private String dropLocation;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RideStatus status = RideStatus.REQUESTED;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "fare", precision = 10, scale = 2)
    private Double fare;

    /* =====================
       Constructors
       ===================== */
    public Ride() {}

    /* =====================
       Getters & Setters
       ===================== */
    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public User getRider() {
        return rider;
    }

    public void setRider(User rider) {
        this.rider = rider;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }
}
