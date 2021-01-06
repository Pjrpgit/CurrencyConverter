package com.zero.currency.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

    @JsonProperty("CtryNm")
    String ctryNm;
    @JsonProperty("CcyNm")
    String ccyNm;
    @JsonProperty("Ccy")
    String ccy;
    @JsonProperty("CcyNbr")
    int ccyNbr;
    @JsonProperty("CcyMnrUnts")
    int ccyMnrUnts;

    public Country() {

    }

    public String getCtryNm() {
        return ctryNm;
    }
    public void setCtryNm(String ctryNm) {
        this.ctryNm = ctryNm;
    }
    public String getCcyNm() {
        return ccyNm;
    }
    public void setCcyNm(String ccyNm) {
        this.ccyNm = ccyNm;
    }
    public String getCcy() {
        return ccy;
    }
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }
    public int getCcyNbr() {
        return ccyNbr;
    }
    public void setCcyNbr(int ccyNbr) {
        this.ccyNbr = ccyNbr;
    }
    public int getCcyMnrUnts() {
        return ccyMnrUnts;
    }
    public void setCcyMnrUnts(int ccyMnrUnts) {
        this.ccyMnrUnts = ccyMnrUnts;
    }

    @Override
    public String toString() {
        return "Country{" +
                "ctryNm='" + ctryNm + '\'' +
                ", ccyNm='" + ccyNm + '\'' +
                ", ccy='" + ccy + '\'' +
                ", ccyNbr=" + ccyNbr +
                ", ccyMnrUnts=" + ccyMnrUnts +
                '}';
    }
}