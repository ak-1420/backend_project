package com.dbs.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

     @Id
     @GeneratedValue(generator="system-uuid")
     @GenericGenerator(name="system-uuid", strategy = "uuid")
     private String customerId;

     @Column(unique = true)
     private String accountHolderName;
     private int overDraftFlag;
     private double clearBalance;
     private String customerAddress;
     private String customerCity;
     private String customerType;

     @OneToOne(mappedBy = "customer")
     private CustomerUser customerUser;

     @OneToMany(mappedBy = "customer")
     private List<Logger> logs;

     @OneToMany(mappedBy = "customer")
     private List<Transaction> transactions;

}
