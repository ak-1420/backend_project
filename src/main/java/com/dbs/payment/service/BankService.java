package com.dbs.payment.service;

import com.dbs.payment.entity.Bank;

import java.util.List;
import java.util.Optional;

public interface BankService {

    List<Bank> fetchAllBanks();

    Optional<Bank> fetchBankById(String id);

}
