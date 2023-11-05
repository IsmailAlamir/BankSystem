package com.example.banksystem.data.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

    private String name;
    private String date;
    private BigDecimal amount;

    public Transaction(String name, String date, BigDecimal amount) {
        this.name = name;
        this.date = date;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


}
