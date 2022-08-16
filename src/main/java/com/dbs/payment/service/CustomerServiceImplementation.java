package com.dbs.payment.service;

import com.dbs.payment.entity.Customer;
import com.dbs.payment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ResourceLoader resourceLoader;

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

    @Override
    public Boolean searchSDN(String name) throws IOException {

      final Resource fileResource = resourceLoader.getResource("classpath:sdnlist.txt");
        Reader reader = new InputStreamReader(fileResource.getInputStream());
        String sdnlist =  FileCopyUtils.copyToString(reader);
        String[] words = sdnlist.split(" ");

        for(String word : words){
            if(word.equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }


}
