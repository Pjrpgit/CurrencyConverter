package com.zero.currency.models;

public class ConversionOperation {

    String currencyBase;
    String currencyXchange;
    float amount;

    public ConversionOperation() {

    }

    public String getCurrencyBase() {
        return currencyBase;
    }

    public void setCurrencyBase(String currencyBase) {
        this.currencyBase = currencyBase;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrencyXchange() {
        return currencyXchange;
    }

    public void setCurrencyXchange(String currencyXchange) {
        this.currencyXchange = currencyXchange;
    }




}
