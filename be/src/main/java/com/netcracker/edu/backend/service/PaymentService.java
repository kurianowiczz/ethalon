package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAll();
    Payment update(Payment payment);
}
