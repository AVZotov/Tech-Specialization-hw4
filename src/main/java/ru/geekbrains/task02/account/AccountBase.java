package ru.geekbrains.task02.account;

import ru.geekbrains.errors.IllegalMoneyAmountException;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Parent class for all the bank accounts
 */
public abstract class AccountBase {

    private BigDecimal balance;

    protected AccountBase(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Method to add the extra money to the account
     * @param amountOfMoney
     * @throws IllegalMoneyAmountException
     */
    public void addMoney(BigDecimal amountOfMoney) throws IllegalMoneyAmountException {
        if (amountOfMoney.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalMoneyAmountException("Error! Inputted sum is less then zero!");
        }

        balance = balance.add(amountOfMoney);
    }
    public void withdrawMoney(BigDecimal amountOfMoney) throws IllegalMoneyAmountException {
        if (amountOfMoney.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalMoneyAmountException("Error! Inputted sum is less then zero!");
        }

        if (balance.compareTo(amountOfMoney) < 0){
            throw new IllegalMoneyAmountException("No enough money on account");
        }

        balance = balance.subtract(amountOfMoney);
    }
    public String getBalance() { return balance.toString(); }
    protected static String generateAccountNumber(){
        Random random = new Random();
        StringBuilder account = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            account.append(random.nextInt(10));
        }

        return account.toString();
    }
}
