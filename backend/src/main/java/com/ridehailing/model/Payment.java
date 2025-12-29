package com.ridehailing.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "payments",
    indexes = {
        @Index(name = "idx_payment_ride", columnList = "ride_id"),
        @Index(name = "idx_payment_status", columnList = "status")
    }
)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    // 1:1 relationship with Ride
    @OneToOne
    @JoinColumn(
        name = "ride_id",
        nullable = false,
        unique = true,
        foreignKey = @ForeignKey(name = "fk_payment_ride")
    )
    private Ride ride;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "method", nullable = false)
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    /* =====================
       Constructors
       ===================== */
    public Payment() {}

    @PrePersist
    protected void onCreate() {
        this.paymentDate = LocalDateTime.now();
    }

    /* =====================
       Getters & Setters
       ===================== */
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }
}
