package com.banksystem.service;

import com.banksystem.entity.Account;
import com.banksystem.entity.Transaction;
import com.banksystem.entity.User;
import com.banksystem.repository.AccountRepository;
import com.banksystem.repository.TransactionRepository;

import java.sql.SQLException;

public class AccountService {
    AccountRepository repository = new AccountRepository();
    TransactionRepository transactionRepository = new TransactionRepository();

    public void createAccount(int accountno  , int userid, String accountType , int balance){
        System.out.println("Start Creating Account");
        User user = new User(userid);
        Account account = new Account(accountno,user,accountType,balance);
        repository.saveAccount(account);
        System.out.println("Account created successfully");
        System.out.println("Account No : " + account.getAccountNo() + ", Account Type : " + account.getAccountType() + ", User ID : "+account.getUser().getId() +", balance : "+ account.getBalance());

    }

    public Account getAccount(int accountNo) throws SQLException, ClassNotFoundException {

        System.out.println("Start Fetching Account, accountNo="+accountNo);

        Account account = repository.getAccount(accountNo);
        System.out.println("Account Fetched successfully for accountNo="+accountNo);

        return account;
    }

    public Account updateAccount(Account account){
        return repository.updateAccount(account);
    }

    public Account deleteAccount(int accountNo) throws SQLException, ClassNotFoundException {

        System.out.println("Start delete Account, accountNo="+accountNo);

        Transaction transaction = transactionRepository.deleteTransaction(accountNo);
        Account account = repository.deleteAccount(accountNo);
        System.out.println("Account deleted successfully for accountNo="+accountNo);

        return account;
    }


}
