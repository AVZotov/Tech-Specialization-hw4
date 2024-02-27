package ru.geekbrains.task02.services;

import ru.geekbrains.errors.IllegalMoneyAmountException;
import ru.geekbrains.errors.InsufficientFundsException;
import ru.geekbrains.task02.account.CreditAccount;
import ru.geekbrains.task02.account.DebitAccount;

import java.math.BigDecimal;

public class Transactions {
    private final DebitAccount debitAccount;
    private final CreditAccount creditAccount;

    public Transactions(DebitAccount debitAccount, CreditAccount creditAccount){
        this.debitAccount = debitAccount;
        this.creditAccount = creditAccount;
    }

    public void debitToCreditTransaction(BigDecimal amountOfMoney) throws IllegalMoneyAmountException, InsufficientFundsException {
        debitAccount.withdrawMoney(amountOfMoney);
        creditAccount.addMoney(amountOfMoney);
    }

    public void creditToDebitTransaction(BigDecimal amountOfMoney) throws IllegalMoneyAmountException, InsufficientFundsException {
        creditAccount.withdrawMoney(amountOfMoney);
        debitAccount.addMoney(amountOfMoney);
    }

    public void getCash(BigDecimal amountOfMoney) throws IllegalMoneyAmountException, InsufficientFundsException {
        debitAccount.withdrawMoney(amountOfMoney);
    }

    @Override
    public String toString() {
        return String.format("%s\n%s", debitAccount.toString(), creditAccount.toString());
    }
}
