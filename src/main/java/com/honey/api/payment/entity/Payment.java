package com.honey.api.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="PAYMENT_TB")
@AllArgsConstructor
@NoArgsConstructor

public class Payment {
    @Id
    @GeneratedValue
    private int paymentId;
    private int orderId;
    private double amount;
    private String paymentStatus;
}
