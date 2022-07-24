package com.honey.api.payment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.honey.api.payment.entity.Payment;
import com.honey.api.payment.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;
    private Logger log = LoggerFactory.getLogger(PaymentService.class);


    public Payment savePayment(Payment payment) throws JsonProcessingException {
        payment.setPaymentStatus(paymentProcessing());
        log.info("OrderService request: {}",new ObjectMapper().writeValueAsString(payment));
        return repository.save(payment);
    }
    public String paymentProcessing(){
        return new Random().nextBoolean()?"Success":"Fail";

    }
    public List<Payment> getPayments(){
        return repository.findAll();
    }
}
