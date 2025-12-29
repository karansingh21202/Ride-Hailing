package com.ridehailing.model;

import javax.persistence.*;

@Entity
@Table(
    name = "vehicles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "driver_id"),
        @UniqueConstraint(columnNames = "plate_number")
    }
)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;

    // 1:1 with driver (User)
    @OneToOne
    @JoinColumn(
        name = "driver_id",
        nullable = false,
        unique = true,
        foreignKey = @ForeignKey(name = "fk_vehicle_driver")
    )
    private User driver;

    @Column(name = "make", nullable = false, length = 50)
    private String make;

    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @Column(name = "plate_number", nullable = false, length = 20, unique = true)
    private String plateNumber;

    @Column(name = "color", length = 30)
    private String color;

    @Column(name = "year")
    private Integer year;

    /* =====================
       Constructors
       ===================== */
    public Vehicle() {}

    /* =====================
       Getters & Setters
       ===================== */
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
