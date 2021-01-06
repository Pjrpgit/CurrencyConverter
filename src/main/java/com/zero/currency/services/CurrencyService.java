package com.zero.currency.services;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {


    public CurrencyUnit getCurrencyUnit(String selectedCurrency) {
        return Monetary.getCurrency(selectedCurrency);
    }


    public Money getMoney(Float amount,CurrencyUnit currencyUnit) {
        return Money.of(amount, currencyUnit);
    }

    public Money makeConversion(Money money,CurrencyUnit currencyUnit) {
        return money.with(MonetaryConversions.getConversion(currencyUnit));
    }


}
