package com.dbs.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private String customerId;
    private String currencyCode;
    private String senderBIC;
    private String receiverBIC;
    private String receiverAccountHolderNumber;
    private String receiverAccountHolderName;
    private String transferTypeCode;
    private String messageCode;
    private double currencyAmount;
    private double transferFees;
    private double inrAmount;
    private Date transferDate;



}
