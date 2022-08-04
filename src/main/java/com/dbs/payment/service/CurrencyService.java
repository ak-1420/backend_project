package com.dbs.payment.service;

import com.dbs.payment.entity.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {
    Currency addCurrency(Currency currency);

    List<Currency> fetchAllCurrency();

    Optional<Currency> fetchCurrencyById(String currencyCode);

    Optional<Currency> updateCurrency(String currencyCode, Currency currency);

    String deleteCurrency(String currencyCode);
}
