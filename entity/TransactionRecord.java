package com.example.bank.entity;

import jakarta.persistence.*;

@Entity
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int txn_id;

    private int from_account;
    private int to_account;
    private double amount;
    private String status;

    public TransactionRecord() {}
    public TransactionRecord(int from_account, int to_account, double amount, String status){
        this.from_account = from_account;
        this.to_account = to_account;
        this.amount = amount;
        this.status = status;
    }
}
