package com.dbs.payment.service;

import com.dbs.payment.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);

    List<Transaction> fetchAllTransactions();

    Optional<Transaction> fetchTransactionById(Long id);

    Optional<Transaction> updateTransaction(Long id, Transaction transaction);

    String deleteTransaction(Long id);
}
