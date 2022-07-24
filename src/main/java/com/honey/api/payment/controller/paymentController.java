package com.honey.api.payment.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.honey.api.payment.entity.Payment;
import com.honey.api.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class paymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/doPayment")
    public Payment bookOrder(@RequestBody Payment payment) throws JsonProcessingException {

        return service.savePayment(payment);
    }

    @GetMapping("/getPayments")
    public List<Payment> getAllOrders(){
        return service.getPayments();
    }


}
