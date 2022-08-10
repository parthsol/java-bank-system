package com.banksystem.repository;

import com.banksystem.entity.Account;
import com.banksystem.entity.Transaction;

import java.sql.*;

public class AccountRepository {


    public void saveAccount(Account account) {
        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankproject", "root", "Parth@198");
            PreparedStatement ps = con.prepareStatement("INSERT INTO account VALUES (?,?,?,?)");
            ps.setInt(1, account.getAccountNo());
            ps.setString(2, account.getAccountType());
            ps.setInt(3, account.getUser().getId());
            ps.setFloat(4, account.getBalance());
            ps.executeUpdate();
            System.out.println("Account added successfully");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Account getAccount(int accountNo) throws SQLException, ClassNotFoundException {
        Connection con = null;

        try {
            System.out.println("try to fetch fetch account sucessfully from db for accountNo" + accountNo);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankproject", "root", "Parth@198");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM account WHERE accountNo=?");
            ps.setInt(1, accountNo);
            System.out.println();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int accountNumber = rs.getInt(1);
                String accountType = rs.getString(2);
                float currentBalance = rs.getFloat(4);
                Account account = new Account();
                account.setAccountNo(accountNumber);
                account.setAccountType(accountType);
                account.setBalance(currentBalance);

                System.out.println("fetch account sucessfully from db " + account);
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    public Account updateAccount(Account account) {

        Connection con = null;
        try {
            System.out.println("try to update account" + account);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankproject", "root", "Parth@198");
            PreparedStatement ps = con.prepareStatement("UPDATE account SET balance=? WHERE accountNo=?");

            ps.setFloat(1, account.getBalance());
            ps.setInt(2, account.getAccountNo());
            ps.executeUpdate();

            System.out.println("account updated successfully" + account);
            return account;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }

    public Account deleteAccount(int accountNo) {
        Connection con = null;
        try {
            System.out.println("try to delete account using accountNo" + accountNo);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankproject", "root", "Parth@198");
            PreparedStatement ps = con.prepareStatement("DELETE FROM account WHERE accountNo=?");
            ps.setInt(1, accountNo);
            int rowCount = ps.executeUpdate();

            System.out.println(accountNo + " accountNo is deleted successfully from db // rowcount " + rowCount );


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
