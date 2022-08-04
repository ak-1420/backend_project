package com.dbs.payment.controller;

import com.dbs.payment.entity.Customer;
import com.dbs.payment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping("/all")
    public List<Customer> fetchAllCustomers(){
        return customerService.fetchAllCustomer();
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> fetchCustomerById(@PathVariable  String customerId){
        return customerService.fetchCustomerById(customerId);
    }

    @PatchMapping("/{customerId}")
    public Optional<Customer> updateCustomer(@PathVariable String customerId ,@RequestBody Customer customer){
        return customerService.updateCustomer(customerId , customer);
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable String customerId){
        return customerService.deleteCustomer(customerId);
    }



}
