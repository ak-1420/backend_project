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

    @ManyToOne(optional = false , cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id" , referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne(optional = false , cascade = CascadeType.ALL)
    @JoinColumn(name="currency_code" , referencedColumnName = "currencyCode")
    private Currency currency;

    @ManyToOne(optional = false , cascade = CascadeType.ALL)
    @JoinColumn(name="bic" , referencedColumnName = "bic")
    private Bank bank;


    @ManyToOne(optional = false , cascade = CascadeType.ALL)
    @JoinColumn(name="message_code" , referencedColumnName = "messageCode")
    private Message message;

    @ManyToOne(optional = false , cascade = CascadeType.ALL)
    @JoinColumn(name="transfer_type_code" , referencedColumnName = "transferTypeCode")
    private TransferTypes transferTypes;
}
