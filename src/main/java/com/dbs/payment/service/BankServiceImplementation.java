package com.dbs.payment.service;

import com.dbs.payment.entity.Bank;
import com.dbs.payment.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImplementation implements  BankService{

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<Bank> fetchAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public Optional<Bank> fetchBankById(String id) {
        return bankRepository.findById(id);
    }

}
