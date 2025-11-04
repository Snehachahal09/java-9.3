package com.example.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private int account_id;
    private String name;
    private double balance;

    public int getAccount_id() { return account_id; }
    public void setAccount_id(int account_id) { this.account_id = account_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
