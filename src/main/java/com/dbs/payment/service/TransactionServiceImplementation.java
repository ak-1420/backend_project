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

    @Override
    public Optional<Transaction> updateTransaction(Long id, Transaction transaction) {
        Optional<Transaction> oT = transactionRepository.findById(id);
        if(oT.isPresent()){
            Transaction tr = oT.get();

            tr.setCustomerId(transaction.getCustomerId());
            tr.setCurrencyCode(transaction.getCurrencyCode());
            tr.setReceiverBIC(transaction.getReceiverBIC());
            tr.setSenderBIC(tr.getSenderBIC());
            tr.setReceiverAccountHolderNumber(transaction.getReceiverAccountHolderNumber());
            tr.setReceiverAccountHolderName(tr.getReceiverAccountHolderNumber());
            tr.setTransferTypeCode(transaction.getTransferTypeCode());
            tr.setMessageCode(transaction.getMessageCode());
            tr.setCurrencyAmount(transaction.getCurrencyAmount());
            tr.setTransferFees(transaction.getTransferFees());
            tr.setInrAmount(transaction.getInrAmount());
            tr.setTransferDate(transaction.getTransferDate());

            transactionRepository.save(tr);

        }
        return transactionRepository.findById(id);
    }

    @Override
    public String deleteTransaction(Long id) {
        Optional<Transaction> trO = transactionRepository.findById(id);
        if(trO.isPresent()){
            transactionRepository.deleteById(id);
            return "transaction deleted successfully";
        }
        return "unable to delete the transaction record";
    }
}
