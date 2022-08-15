package com.dbs.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String receiverBIC;
    private String receiverAccountHolderNumber;
    private String receiverAccountHolderName;
    private String transferTypeCode;
    private String messageCode;
    private double transferFees;
    private double inrAmount;
    private String transferDate;
    private Boolean status;

}
