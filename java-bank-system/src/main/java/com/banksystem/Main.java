package com.banksystem;

import com.banksystem.entity.Account;

import com.banksystem.service.AccountService;

import com.banksystem.service.TransactionService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        UserService userService = new UserService();
//        userService.creatUser(106,"Costomer","Dilipbhai","Solanki");
//        userService.creatUser(107,"Employee","Dinaben","Solanki");

//        AccountService accountService = new AccountService();
//        accountService.createAccount(2000,106,"Saving");

//        AccountService accountService = new AccountService();
//        accountService.createAccount(2001,206,"Current");

//        AccountService accountService = new AccountService();
//        accountService.createAccount(20002,3,"Current");

//        AccountService accountService = new AccountService();
//        accountService.createAccount(20003,2,"Saving");

//        AccountService accountService = new AccountService();
//        accountService.createAccount(20004,101,"Saving",10000);

//        AccountService accountService = new AccountService();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter account Number: ");
//        int accountno = sc.nextInt();
////
//        System.out.println("Enter user id : ");
//        int userid = sc.nextInt();
//
//        System.out.println("Enter Account Type : ");
//        String accounttype = sc.next();
//
//        System.out.println("Enter Amount you want to deposit : ");
//        int balance = sc.nextInt();
//
//        accountService.createAccount(accountno,userid,accounttype,balance);


//        AccountService accountService = new AccountService();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter account Number: ");
//        int accountno = sc.nextInt();
////



        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();

        Account account = accountService.getAccount(20003);

        transactionService.credit(account,500);
//        transactionService.debit(account,3000);






    }
}
