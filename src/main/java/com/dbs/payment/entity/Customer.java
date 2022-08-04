package com.dbs.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private String customerId;

     @Column(unique = true)
     private String accountHolderName;
     private int overDraftFlag;
     private double clearBalance;
     private String customerAddress;
     private String customerCity;
     private String customerType;

}
