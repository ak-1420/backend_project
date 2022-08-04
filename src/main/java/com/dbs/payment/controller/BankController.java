package com.dbs.payment.controller;

import com.dbs.payment.entity.Bank;
import com.dbs.payment.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

     @Autowired
     private BankService bankService;

     @PostMapping("/add")
     public Bank addBank(@RequestBody Bank bank){
         return bankService.addBank(bank);
     }

     @GetMapping("/all")
     public List<Bank> fetchAllBanks(){
         return bankService.fetchAllBanks();
     }

     @GetMapping("/{id}")
     public Optional<Bank> fetchBankById(@PathVariable String id){
         return bankService.fetchBankById(id);
     }

     @PatchMapping("/{id}")
     public Optional<Bank> updateBank(@PathVariable String id , @RequestBody Bank bank){
         return bankService.updateBank(id , bank);
     }

     @DeleteMapping("/{id}")
     public String deleteBank(@PathVariable String id){
         return bankService.deleteBank(id);
     }
}
