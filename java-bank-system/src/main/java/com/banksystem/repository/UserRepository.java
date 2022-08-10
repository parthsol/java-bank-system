package com.banksystem.repository;

import com.banksystem.entity.User;

import java.sql.*;

public class UserRepository {

    public void saveUser(User user){


        System.out.println("Start saving user in database");

        Connection con = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankproject","root","Parth@198");
            PreparedStatement ps = con.prepareStatement("INSERT INTO user VALUES (?,?,?,?)");
            ps.setInt(1,user.getId());
            ps.setString(2,user.getTypeOfUser());
            ps.setString(3,user.getFirstName());
            ps.setString(4,user.getLastName());
            ps.executeUpdate();
            System.out.println("User added successfully");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
