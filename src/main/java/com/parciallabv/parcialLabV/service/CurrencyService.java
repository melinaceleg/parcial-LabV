package com.parciallabv.parcialLabV.service;

import com.parciallabv.parcialLabV.model.Currency;
import com.parciallabv.parcialLabV.repository.CurrencyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CurrencyService {
    private CurrencyRepository currencyRepository;



    public List<Currency> getAllCurrencies() {

        return currencyRepository.findAll();

    }

    public void addCurrency(Currency currency) {
        currencyRepository.save(currency);
    }

    public Currency getCurrencyById(Integer currencyId) {
        return currencyRepository.findById(currencyId).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

    }

    public void deleteCurrency(Currency currency) {
        currencyRepository.delete(currency);

    }
}
