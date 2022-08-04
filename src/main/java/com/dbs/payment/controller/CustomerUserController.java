package com.dbs.payment.controller;

import com.dbs.payment.entity.CustomerUser;
import com.dbs.payment.service.CustomerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customer-user")
public class CustomerUserController {

    @Autowired
    private CustomerUserService customerUserService;


    // to add a new customerUser
    @PostMapping("/add")
    public CustomerUser addCustomerUser(@RequestBody CustomerUser user){
        return customerUserService.addCustomerUser(user);
    }

    // to get all CustomerUsers
    @GetMapping("/all")
    public List<CustomerUser> fetchAllCustomerUsers(){
        return customerUserService.fetchAllCustomerUser();
    }

    // to get a customerUser by Id
    @GetMapping("/{Id}")
    public Optional<CustomerUser> fetchCustomerUserById(@PathVariable Long Id){
        return customerUserService.fetchCustomerUserById(Id);
    }

    // to update a customerUser
    @PatchMapping("/{Id}")
    public Optional<CustomerUser> updateCustomerUser(@PathVariable Long Id ,@RequestBody CustomerUser user){
        return customerUserService.updateCustomerUser(Id , user);
    }

    // to delete a customerUser
    @DeleteMapping("/{Id}")
    public String deleteCustomerUser(@PathVariable  Long Id){
        return customerUserService.deleteCustomerUser(Id);
    }



}
