package com.dbs.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

     @Id
     private String customerId;
     private String accountHolderName;
     private int overDraftFlag;
     private double clearBalance;
     private String transferType;
}
