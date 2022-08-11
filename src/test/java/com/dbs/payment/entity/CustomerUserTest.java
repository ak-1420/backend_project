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

    @Test
    public void saveCustomerUsers(){
        Customer customer = Customer.builder()
                .accountHolderName("Arun Kumar Kalakuntla")
                .clearBalance(10000)
                .customerAddress("2-91 , siddipet")
                .customerCity("hyderabad")
                .customerType("savings")
                .overDraftFlag(1)
                .build();

        CustomerUser user = CustomerUser
                .builder()
                .userName("arun kumar")
                .userPassword("123456")
                .customer(customer)
                .build();
        customerUserRepository.save(user);
    }


}