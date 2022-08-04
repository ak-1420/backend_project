package com.dbs.payment.service;

import com.dbs.payment.entity.CustomerUser;
import com.dbs.payment.repository.CustomerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerUserServiceImplementation implements  CustomerUserService{

    @Autowired
    private CustomerUserRepository customerUserRepository;

    @Override
    public CustomerUser addCustomerUser(CustomerUser user) {
        return customerUserRepository.save(user);
    }

    @Override
    public List<CustomerUser> fetchAllCustomerUser() {
        return customerUserRepository.findAll();
    }

    @Override
    public Optional<CustomerUser> fetchCustomerUserById(Long id) {
        return customerUserRepository.findById(id);
    }

    @Override
    public Optional<CustomerUser> updateCustomerUser(Long id, CustomerUser user) {
         Optional<CustomerUser> u = customerUserRepository.findById(id);

         if(u.isPresent()){
             CustomerUser oldUser = u.get();
             oldUser.setUserName(user.getUserName());
             oldUser.setUserPassword(user.getUserPassword());
             customerUserRepository.save(oldUser);
         }

         return customerUserRepository.findById(id);
    }

    @Override
    public String deleteCustomerUser(Long id) {
        Optional<CustomerUser> u = customerUserRepository.findById(id);

        if(u.isPresent()){
            customerUserRepository.deleteById(id);
            return "record deleted successfully!";
        }
        return "Unable to delete CustomerUser with given id";
    }

}
