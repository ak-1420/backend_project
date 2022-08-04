package com.dbs.payment.service;

import com.dbs.payment.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    List<Customer> fetchAllCustomer();

    Optional<Customer> fetchCustomerById(String customerId);

    Optional<Customer> updateCustomer(String customerId, Customer customer);

    String deleteCustomer(String customerId);
}
