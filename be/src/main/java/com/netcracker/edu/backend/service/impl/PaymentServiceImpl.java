package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Payment;
import com.netcracker.edu.backend.repository.PaymentRepository;
import com.netcracker.edu.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    @Autowired
    public PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAll() {
        return (List<Payment>) paymentRepository.findAll();
    }

    @Override
    public Payment update(Payment payment) {
        return paymentRepository.save(payment);
    }


}
