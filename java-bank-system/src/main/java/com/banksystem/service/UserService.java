package com.banksystem.service;

import com.banksystem.entity.User;
import com.banksystem.repository.UserRepository;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public void creatUser(int id,String typeofuser, String firstName, String lastName){
        System.out.println("start creating User");
        User user = new User(id,typeofuser,firstName,lastName);
        userRepository.saveUser(user);
        System.out.println("User created successfully");
        System.out.println("First Name of User: " + user.getFirstName() + ", Last Name of User: " + user.getLastName() + ", Type of User : "+user.getTypeOfUser());

    }
}
