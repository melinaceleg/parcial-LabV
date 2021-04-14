package com.parciallabv.parcialLabV.controller;

import com.parciallabv.parcialLabV.model.Currency;
import com.parciallabv.parcialLabV.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("")
    public List<Currency> getAllCurrencies()
    {
        return currencyService.getAllCurrencies();
    }

    @PostMapping("")
    public void addCurrency(@RequestBody Currency currency)
    {
        currencyService.addCurrency(currency);
    }


    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Integer currencyId)
    {
        return currencyService.getCurrencyById(currencyId);
    }


    @DeleteMapping("")
    public void deleteCurrency(@RequestBody Currency currency)
    {
        currencyService.deleteCurrency(currency);
    }


}
