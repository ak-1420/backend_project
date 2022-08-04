package com.dbs.payment.controller;

import com.dbs.payment.entity.Currency;
import com.dbs.payment.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/add")
    public Currency addCurrency(@RequestBody Currency currency){
         return currencyService.addCurrency(currency);
    }

    @GetMapping("/all")
    public List<Currency> fetchAllCurrency(){
        return currencyService.fetchAllCurrency();
    }

    @GetMapping("/{currencyCode}")
    public Optional<Currency> fetchCurrencyById(@PathVariable String currencyCode){
        return currencyService.fetchCurrencyById(currencyCode);
    }

    @PatchMapping("/{currencyCode}")
    public Optional<Currency> updateCurrency(@PathVariable String currencyCode , @RequestBody Currency currency){
        return currencyService.updateCurrency(currencyCode , currency);
    }

    @DeleteMapping("/{currencyCode}")
    public String deleteCurrency(@PathVariable String currencyCode){
        return currencyService.deleteCurrency(currencyCode);
    }
}
