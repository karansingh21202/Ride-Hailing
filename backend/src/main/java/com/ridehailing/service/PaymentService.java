package com.ridehailing.service;

import com.ridehailing.model.Payment;
import com.ridehailing.repository.PaymentRepository;

import java.util.List;

public class PaymentService {

    private final PaymentRepository paymentRepository = new PaymentRepository();

    // Add a new payment
    public boolean addPayment(Payment payment) {
        try {
            paymentRepository.save(payment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get payment by ID
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Update an existing payment
    public boolean updatePayment(Payment payment) {
        try {
            paymentRepository.update(payment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a payment
    public boolean deletePayment(Payment payment) {
        try {
            paymentRepository.delete(payment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
