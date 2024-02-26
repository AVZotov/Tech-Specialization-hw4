package ru.geekbrains.task01;

import ru.geekbrains.errors.InsufficientFundsException;

import java.math.BigDecimal;

public class Program {
    public static void main(String[] args) {
        try {
            Account account1 = Account.createAccount(new BigDecimal("-456789.65"));
            System.out.println(account1);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            Account account1 = Account.createAccount(new BigDecimal("456789.65"));
            System.out.println(account1);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            Account account1 = Account.createAccount(new BigDecimal("456000"));
            System.out.println(account1);
            account1.addMoney(new BigDecimal("-4000"));
            System.out.println(account1);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            Account account1 = Account.createAccount(new BigDecimal("456000"));
            System.out.println(account1);
            account1.moneyWithdrawal(new BigDecimal("456001"));
            System.out.println(account1);
        } catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }
    }
}
