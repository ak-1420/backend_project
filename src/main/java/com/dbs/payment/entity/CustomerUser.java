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
public class CustomerUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(unique = true)
    private String userName;

    private String userPassword;

    @OneToOne(optional = false , cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id" , referencedColumnName = "customerId")
    private Customer customer;


}
