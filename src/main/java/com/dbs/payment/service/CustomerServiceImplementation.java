package com.dbs.payment.service;

import com.dbs.payment.entity.Customer;
import com.dbs.payment.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService{

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
    public Optional<Customer> updateCustomer(String customerId, Customer customer) {
        Optional<Customer> cust1 = customerRepository.findById(customerId);
        if(cust1.isPresent()){
            Customer cust2 = cust1.get();
            cust2.setCustomerCity(customer.getCustomerCity());
            cust2.setCustomerAddress(customer.getCustomerAddress());
            cust2.setCustomerType(customer.getCustomerType());
            cust2.setOverDraftFlag(customer.getOverDraftFlag());
            cust2.setAccountHolderName(customer.getAccountHolderName());
            cust2.setClearBalance(customer.getClearBalance());
            customerRepository.save(cust2);
        }
        return customerRepository.findById(customerId);
    }

    @Override
    public String deleteCustomer(String customerId) {
        Optional<Customer> oCust = customerRepository.findById(customerId);
        if(oCust.isPresent()){
            customerRepository.deleteById(customerId);
            return "customer record deleted successfully!";
        }
        return "unable to delete the customer with the given customer Id";
    }
}
