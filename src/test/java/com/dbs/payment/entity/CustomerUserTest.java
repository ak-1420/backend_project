package com.dbs.payment.entity;

import com.dbs.payment.repository.CustomerUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerUserTest {

    @Autowired
    private CustomerUserRepository customerUserRepository;

}