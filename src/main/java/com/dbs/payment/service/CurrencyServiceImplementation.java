package com.dbs.payment.service;

import com.dbs.payment.entity.Currency;
import com.dbs.payment.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImplementation implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Currency addCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public List<Currency> fetchAllCurrency() {
        return currencyRepository.findAll();
    }

    @Override
    public Optional<Currency> fetchCurrencyById(String currencyCode) {
        return currencyRepository.findById(currencyCode);
    }

    @Override
    public Optional<Currency> updateCurrency(String currencyCode, Currency currency) {
         Optional<Currency> oC = currencyRepository.findById(currencyCode);
         if(oC.isPresent()){
             Currency cr = oC.get();
             cr.setCurrencyCode(currency.getCurrencyCode());
             cr.setCurrencyName(currency.getCurrencyName());
             cr.setConversionRate(currency.getConversionRate());
             currencyRepository.save(cr);
         }
         return currencyRepository.findById(currencyCode);
    }

    @Override
    public String deleteCurrency(String currencyCode) {
        Optional<Currency> ocr = currencyRepository.findById(currencyCode);
        if(ocr.isPresent()){
            currencyRepository.deleteById(currencyCode);
            return "record deleted successfully";
        }
        return "unable to delete the record!";
    }
}
