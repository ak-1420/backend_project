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
    public Bank addBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public List<Bank> fetchAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public Optional<Bank> fetchBankById(String id) {
        return bankRepository.findById(id);
    }

    @Override
    public Optional<Bank> updateBank(String id, Bank bank) {
        Optional<Bank> oB = bankRepository.findById(id);
        if(oB.isPresent()){
            Bank b = oB.get();
            b.setBankName(bank.getBankName());
            bankRepository.save(b);
        }
        return bankRepository.findById(id);
    }

    @Override
    public String deleteBank(String id) {
        Optional<Bank> ob = bankRepository.findById(id);
        if(ob.isPresent()){
            bankRepository.deleteById(id);
            return "record deleted successfully!";
        }
        return "unable to delete the record";
    }
}
