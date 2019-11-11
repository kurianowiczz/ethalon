package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Payment;
import com.netcracker.edu.fapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Value("http://localhost:8080/")
    private String BACKEND_SERVER_URL;


    @Override
    public List<Payment> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Payment[] paymentsResponce = restTemplate.getForObject(BACKEND_SERVER_URL + "/api/payments/all", Payment[].class);
        return paymentsResponce == null ? Collections.emptyList() : Arrays.asList(paymentsResponce);

    }

    @Override
    public Payment update(Payment payment) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(BACKEND_SERVER_URL + "/api/payments/", payment, Payment.class).getBody();

    }

    @Override
    public Payment findById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BACKEND_SERVER_URL + "api/payments/id/" + id, Payment.class);
    }
}
