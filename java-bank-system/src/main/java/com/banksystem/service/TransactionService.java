package com.banksystem.service;

import com.banksystem.entity.Account;
import com.banksystem.entity.Transaction;
import com.banksystem.repository.TransactionRepository;

import java.sql.Date;
import java.sql.SQLException;

public class TransactionService {

    AccountService accountService = new AccountService();

    TransactionRepository transactionRepository = new TransactionRepository();

//    public Account getAccount(int accountNo) throws SQLException, ClassNotFoundException {
//        System.out.println("Start Fetching Account..");
//
//        Account account = accountService.getAccount(accountNo);
//        System.out.println("Account Fetched successfully");
//        System.out.println("Account No : " + accountNo);
//        return account;
//    }

    public Account credit(Account account, float txAmount){
        //add trasaction into db
        Transaction transaction = new Transaction();

        transaction.setTxAmount(txAmount);
        transaction.setTxType("credit");
        transaction.setDate(Date.valueOf("2022-09-19"));
        transaction.setAccount(account.getAccountNo());
        //before transaction balance(current balance)
        transaction.setCurrentBalance(account.getBalance());

        //logic for tx amount into current balance
        account = creditAmount(account,txAmount);
        System.out.println("updated account balance="+account.getBalance());

        //set updated balance in transaction
        transaction.setTotalBalance(account.getBalance());

        //save transaction
        saveTransaction(transaction);

        //store update balance into db
        accountService.updateAccount(account);

        //return account with updated balance
        return account;
    }

    public Account debit(Account account, float txAmount){
        //add trasaction into db
        Transaction transaction = new Transaction();

        transaction.setTxAmount(txAmount);
        transaction.setTxType("debit");
        transaction.setDate(Date.valueOf("2022-09-19"));
        transaction.setCurrentBalance(account.getBalance());



        //logic for tx amount into current balance
        account = debitAmount(account,txAmount);
        System.out.println("updated account balance="+account.getBalance());

        //set updated balance in transaction
        transaction.setTotalBalance(account.getBalance());
        transaction.setAccount(account.getAccountNo());

        //save transaction
        saveTransaction(transaction);

        //store update balance into db
        accountService.updateAccount(account);

        System.out.println(account.getBalance());
        //return account with updated balance
        return account;
    }

    private Account creditAmount(Account account, float txAmount) {
        float updatedBal = account.getBalance() + txAmount;
        account.setBalance(updatedBal);
        return account;
    }


    private Account debitAmount(Account account, float txAmount) {
        float updatedBal = account.getBalance() - txAmount;
        account.setBalance(updatedBal);
        return account;
    }

    private Transaction saveTransaction(Transaction transaction){
        return transactionRepository.saveTransaction(transaction);
    }
}