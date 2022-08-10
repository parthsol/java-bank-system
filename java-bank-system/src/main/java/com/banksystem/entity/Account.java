package com.banksystem.entity;

public class Account {
    private int accountNo;
    private String accountType;
    private User user;


    private float balance;


    public Account(){

    }

    public Account(int accountNo,User user,String accountType,int balance){
        if (user == null){
            throw new RuntimeException("Please Enter User than Create Account.");
        }

        this.setAccountNo(accountNo);
        this.setUser(user);
        this.setAccountType(accountType);
        this.setBalance(balance);
    }

    public Account(int accountNo) {
        this.accountNo = accountNo;
    }


    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", balance=" + balance +
                '}';
    }
}
