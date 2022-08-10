package com.banksystem.repository;

import com.banksystem.entity.Account;
import com.banksystem.entity.Transaction;

import java.sql.*;

public class TransactionRepository {


    public Transaction saveTransaction(Transaction transaction) {
        Connection con = null;
        try {
            System.out.println("try to save transaction on db" + transaction);
            System.out.println("Start Saving Transaction...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankproject", "root", "Parth@198");
            PreparedStatement ps = con.prepareStatement("INSERT INTO transaction (currentBal,txAmount,txType,Date,tBalance,accountNo) values (?,?,?,?,?,?)");
            ps.setFloat(1, transaction.getCurrentBalance());
            ps.setFloat(2, transaction.getTxAmount());
            ps.setString(3, transaction.getTxType());
            ps.setDate(4, transaction.getDate());
            ps.setFloat(5, transaction.getTotalBalance());
            ps.setInt(6, transaction.getAccount());
            ps.executeUpdate();
            System.out.println("transaction saved into Database successfully" + transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Transaction deleteTransaction(int accountNo) {
        Connection con = null;
        try {
            System.out.println("try to delete transaction on db" + accountNo);
            System.out.println("Start Saving Transaction...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankproject", "root", "Parth@198");
            PreparedStatement ps = con.prepareStatement("DELETE FROM transaction WHERE accountNo=?");
            ps.setInt(1,accountNo);
            ps.executeUpdate();
            System.out.println("transaction deleted into Database successfully" + accountNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}