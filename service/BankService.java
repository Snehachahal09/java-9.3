package com.example.bank.service;

import com.example.bank.dao.AccountDAO;
import com.example.bank.entity.Account;
import com.example.bank.entity.TransactionRecord;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void transferMoney(int fromAcc, int toAcc, double amount) {

        Account sender = accountDAO.getAccount(fromAcc);
        Account receiver = accountDAO.getAccount(toAcc);

        if(sender.getBalance() < amount){
            sessionFactory.getCurrentSession().save(new TransactionRecord(fromAcc,toAcc,amount,"Failed"));
            throw new RuntimeException("Insufficient balance!");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountDAO.updateAccount(sender);
        accountDAO.updateAccount(receiver);

        sessionFactory.getCurrentSession().save(new TransactionRecord(fromAcc,toAcc,amount,"Success"));
        System.out.println("✅ Transfer Successful");
    }
}
