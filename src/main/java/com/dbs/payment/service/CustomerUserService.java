package com.dbs.payment.service;

import com.dbs.payment.entity.CustomerUser;

import java.util.List;
import java.util.Optional;

public interface CustomerUserService {
    
    CustomerUser addCustomerUser(CustomerUser user);

    List<CustomerUser> fetchAllCustomerUser();

    Optional<CustomerUser> fetchCustomerUserById(Long id);

    Optional<CustomerUser> updateCustomerUser(Long id, CustomerUser user);

    String deleteCustomerUser(Long id);
}
