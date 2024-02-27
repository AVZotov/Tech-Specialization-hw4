package ru.geekbrains.task02;

import ru.geekbrains.errors.IllegalMoneyAmountException;
import ru.geekbrains.errors.InsufficientFundsException;
import ru.geekbrains.task02.account.CreditAccount;
import ru.geekbrains.task02.account.DebitAccount;
import ru.geekbrains.task02.services.Transactions;

import java.math.BigDecimal;

public class Program {
    public static void main(String[] args) {
        DebitAccount debitAccount1;
        CreditAccount creditAccount1;
        Transactions transactions = null;
        try {
            debitAccount1 = DebitAccount.CreateAccount(new BigDecimal("5000"));
            creditAccount1 = CreditAccount.CreateAccount(new BigDecimal("0"));
            System.out.println(debitAccount1);
            System.out.println(creditAccount1);
            transactions = new Transactions(debitAccount1, creditAccount1);
        } catch (IllegalMoneyAmountException e) {
            System.out.println(e.getMessage());
        }

        try {
            DebitAccount debitAccount = DebitAccount.CreateAccount(new BigDecimal("-5000"));
            CreditAccount creditAccount = CreditAccount.CreateAccount(new BigDecimal("0"));
        } catch (IllegalMoneyAmountException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (transactions != null){
                transactions.creditToDebitTransaction(new BigDecimal("500"));
            }
        } catch (IllegalMoneyAmountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            assert transactions != null;
            transactions.getCash(new BigDecimal("-1000"));
        } catch (IllegalMoneyAmountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
