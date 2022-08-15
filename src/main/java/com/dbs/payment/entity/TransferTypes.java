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
    private String transferTypeCode;
    private String transferTypeDescription;

}
