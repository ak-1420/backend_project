package com.dbs.payment.controller;

import com.dbs.payment.entity.Bank;
import com.dbs.payment.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/bank")
public class BankController {

     @Autowired
     private BankService bankService;

     @GetMapping("/all")
     public List<Bank> fetchAllBanks(){
         return bankService.fetchAllBanks();
     }

     @GetMapping("/{id}")
     public Optional<Bank> fetchBankById(@PathVariable String id){
         return bankService.fetchBankById(id);
     }

}
