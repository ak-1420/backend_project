package com.dbs.payment.controller;

import com.dbs.payment.entity.Customer;
import com.dbs.payment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
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
    public Optional<Customer> updateCustomer(@PathVariable String customerId , @RequestBody Customer customer){
        return customerService.updateCustomer(customerId , customer);
    }


    @GetMapping("/sdn/{name}")
    public Boolean searchSDN (@PathVariable String name) throws IOException {
        return customerService.searchSDN(name);
    }



}
