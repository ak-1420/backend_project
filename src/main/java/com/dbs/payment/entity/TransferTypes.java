package com.dbs.payment.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String transferTypeCode;
    private String transferTypeDescription;

    @OneToMany(mappedBy = "transferTypes")
    private List<Transaction> transactions;
}
