package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Payment;
import com.netcracker.edu.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Payment> getAllPayments(){
        return paymentService.getAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Payment> getPaymentById(@PathVariable(name = "id") Long id) {
        Optional<Payment> payment = paymentService.getById(id);
        if (payment.isPresent()) {
            return ResponseEntity.ok(payment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Payment updatePayment(@RequestBody Payment payment){
        return paymentService.update(payment);
    }
}
