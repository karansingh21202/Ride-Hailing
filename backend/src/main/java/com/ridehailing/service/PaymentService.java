package com.ridehailing.service;

import com.ridehailing.model.Payment;
import com.ridehailing.repository.PaymentRepository;

import java.util.List;

public class PaymentService {

    private final PaymentRepository paymentRepository = new PaymentRepository();

    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public void updatePayment(Payment payment) {
        paymentRepository.update(payment);
    }

    public void deletePayment(Payment payment) {
        paymentRepository.delete(payment);
    }
}
