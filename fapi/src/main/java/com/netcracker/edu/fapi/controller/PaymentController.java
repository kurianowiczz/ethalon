package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Payment;
import com.netcracker.edu.fapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Payment> getAllPayments() {
        return paymentService.getAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Payment> getPaymentById(@PathVariable(name = "id") long id) {
        Payment payment = paymentService.findById(id);
        return payment != null ? ResponseEntity.ok(payment) : ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Payment updatePayment(@RequestBody Payment payment){

        return paymentService.update(payment);
    }
}
