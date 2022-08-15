package com.dbs.payment.service;

import com.dbs.payment.entity.Transaction;
import com.dbs.payment.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImplementation implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> fetchAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> fetchTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

}
