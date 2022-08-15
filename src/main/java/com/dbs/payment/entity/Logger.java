package com.dbs.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loggerId;
    private Long userId;
    private Long employeeId;
    private String screenName;
    private String action;
    private String ipAddress;


}
