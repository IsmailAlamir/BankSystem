package com.example.banksystem.data.model;

public class RegisterRequest {

    private String username;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String id_number;
    private String phone_number;
    private Integer account_amount; // Using Integer instead of int to allow for null
    private String role;

    public RegisterRequest(String username, String email, String password, String first_name, String last_name, String id_number, String phone_number, Integer account_amount, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.id_number = id_number;
        this.phone_number = phone_number;
        this.account_amount = account_amount;
        this.role = role;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", id_number='" + id_number + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", account_amount=" + account_amount +
                ", role='" + role + '\'' +
                '}';
    }
}
