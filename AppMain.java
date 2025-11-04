package com.example.bank;

import com.example.bank.service.BankService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BankService bankService = ctx.getBean(BankService.class);

        bankService.transferMoney(101, 102, 2000);
    }
}
