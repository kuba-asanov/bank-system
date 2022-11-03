package com.example.banksystem.model;

import org.springframework.stereotype.Component;

@Component
public class TransactionModel {
    private String id;
    private int balance;

    public TransactionModel() {

    }

    public TransactionModel(String id, int balance) {
        super();
        this.id = id;
        this.balance = balance;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }


}
