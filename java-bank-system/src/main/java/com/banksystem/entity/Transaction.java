package com.banksystem.entity;

import java.sql.Date;

public class Transaction {

    private float txAmount;
    private String txType;

    @Override
    public String toString() {
        return "Transaction{" +
                "txAmount=" + txAmount +
                ", txType='" + txType + '\'' +
                ", date=" + date +
                ", currentBalance=" + currentBalance +
                ", totalBalance=" + totalBalance +
                ", account=" + account +
                '}';
    }

    private Date date;

    private Float currentBalance;
    private float totalBalance;


    private int account;

    public Transaction(){

    }

    public float getTxAmount() {
        return txAmount;
    }

    public void setTxAmount(float txAmount) {
        this.txAmount = txAmount;
    }

    public String getTxType() {
        return txType;
    }

    public void setTxType(String txType) {
        this.txType = txType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public float getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(float totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Float currentBalance) {
        this.currentBalance = currentBalance;
    }


}