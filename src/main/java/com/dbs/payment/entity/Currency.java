package com.dbs.payment.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String currencyCode;
    private String currencyName;
    private double conversionRate;


    @OneToMany(mappedBy = "currency")
    private List<Transaction> transactions;

}
