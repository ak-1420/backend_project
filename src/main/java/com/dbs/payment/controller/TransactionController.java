package com.dbs.payment.controller;


import com.dbs.payment.entity.Transaction;
import com.dbs.payment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
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

    @PatchMapping("/{id}")
    public Optional<Transaction> updateTransaction(@PathVariable Long id , @RequestBody Transaction transaction){
        return transactionService.updateTransaction(id , transaction);
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id){
        return transactionService.deleteTransaction(id);
    }


}
