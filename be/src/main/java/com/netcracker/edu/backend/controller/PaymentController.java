package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Payment;
import com.netcracker.edu.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    PaymentService paymentService;

    @Autowired
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Payment> getAllPayments(){
        return paymentService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Payment updatePayment(@RequestBody Payment payment){
        return paymentService.update(payment);
    }
}
