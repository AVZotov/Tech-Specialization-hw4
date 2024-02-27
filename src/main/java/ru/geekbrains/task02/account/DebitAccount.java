package ru.geekbrains.task02.account;

import ru.geekbrains.errors.IllegalMoneyAmountException;

import java.math.BigDecimal;

public class DebitAccount extends AccountBase{

    private final String accountNumber;

    private DebitAccount(String accountNumber, BigDecimal balance) {
        super(balance);
        this.accountNumber = accountNumber;
    }

    public static DebitAccount CreateAccount(BigDecimal initialAmountOfMoney) throws IllegalMoneyAmountException{
        if (initialAmountOfMoney.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalMoneyAmountException("Account creation canceled. Initial money amount cant be less then 0");
        }

        return new DebitAccount(generateAccountNumber(), initialAmountOfMoney);
    }
    @Override
    public String toString() {
        return String.format("account: balance: %s; balance: %s", accountNumber, getBalance());
    }
}
