package com.dbs.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uid", strategy = "uuid")
    private String bic;
    private String bankName;

    @OneToMany(mappedBy = "bank")
    private List<Transaction> transactions;

}
