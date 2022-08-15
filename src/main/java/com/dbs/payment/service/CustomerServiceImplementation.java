package com.dbs.payment.service;

import com.dbs.payment.entity.Customer;
import com.dbs.payment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> fetchCustomerById(String customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Optional<Customer> updateCustomer(String customerId , Customer cust) {
        Optional<Customer> oCust = customerRepository.findById(customerId);

        if(oCust.isPresent()){
            Customer customer = oCust.get();
            customer.setClearBalance(cust.getClearBalance());
            customerRepository.save(customer);
        }
        return customerRepository.findById(customerId);
    }


}
