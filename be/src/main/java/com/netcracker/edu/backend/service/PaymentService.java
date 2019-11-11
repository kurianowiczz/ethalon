package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> getAll();
    Payment update(Payment payment);
    Optional<Payment> getById(Long id);
}
