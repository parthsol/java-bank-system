package com.banksystem.entity;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String typeOfUser;

    public User(int id, String typeOfUser,String firstname, String lastname) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.typeOfUser = typeOfUser;
    }

    public User(int userid) {
        this.id = userid;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String setLastName(String lastName) {
        this.lastName = lastName;
        return lastName;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type_of_user='" + typeOfUser + '\'' +
                '}';
    }
}
