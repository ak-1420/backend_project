package com.dbs.payment.entity;

import com.dbs.payment.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomer(){
        Customer customer = Customer.builder()
                .accountHolderName("Kranthi Kumar Kalakuntla")
                .clearBalance(10000)
                .customerAddress("2-91 , siddipet")
                .customerCity("hyderabad")
                .customerType("savings")
                .overDraftFlag(0)
                .build();

        customerRepository.save(customer);
    }


    @Test
    public void printCustomers(){
        List<Customer> data = customerRepository.findAll();
        System.out.println("number of customers:" + data.size());
    }

}