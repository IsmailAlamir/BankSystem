package com.example.banksystem.data.model;

public class RegisterRequest {

    private String firstName, lastName, phone, email, username, password;

    public RegisterRequest(String firstName, String lastName, String phone, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
