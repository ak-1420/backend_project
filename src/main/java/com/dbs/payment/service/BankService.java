package com.dbs.payment.service;

import com.dbs.payment.entity.Bank;

import java.util.List;
import java.util.Optional;

public interface BankService {
    Bank addBank(Bank bank);

    List<Bank> fetchAllBanks();

    Optional<Bank> fetchBankById(String id);

    Optional<Bank> updateBank(String id, Bank bank);

    String deleteBank(String id);
}
