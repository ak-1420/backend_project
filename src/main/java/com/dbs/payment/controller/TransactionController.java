package com.dbs.payment.controller;


import com.dbs.payment.entity.Transaction;
import com.dbs.payment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction){
       return transactionService.addTransaction(transaction);
    }

    @GetMapping("/all")
    public List<Transaction> fetchAllTransactions(){
        return transactionService.fetchAllTransactions();
    }

    @GetMapping("/{id}")
    public Optional<Transaction> fetchTransactionById(@PathVariable Long id){
        return transactionService.fetchTransactionById(id);
    }


}
