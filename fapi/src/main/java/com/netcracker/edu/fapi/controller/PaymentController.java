package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Payment;
import com.netcracker.edu.fapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Payment> getAllPayments() {
        return paymentService.getAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Payment updatePayment(@RequestBody Payment payment){

        return paymentService.update(payment);
    }
}
