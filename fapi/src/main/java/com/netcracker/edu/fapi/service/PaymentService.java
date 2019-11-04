package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAll();
    Payment update(Payment payment);
}
