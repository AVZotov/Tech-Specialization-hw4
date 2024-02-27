package ru.geekbrains.task02.account;

import ru.geekbrains.errors.IllegalMoneyAmountException;
import ru.geekbrains.errors.InsufficientFundsException;

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
     * Method to add money to the account
     * @param amountOfMoney money quantity to be added to the account
     * @throws IllegalMoneyAmountException exception appears if amount of money is less then 0
     */
    public void addMoney(BigDecimal amountOfMoney) throws IllegalMoneyAmountException {
        if (amountOfMoney.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalMoneyAmountException("Error! Inputted sum is less then zero!");
        }

        balance = balance.add(amountOfMoney);
    }

    /**
     * Method to withdraw money from account
     * @param amountOfMoney amount of money to withdraw
     * @throws IllegalMoneyAmountException exception throws if amount of money is less then 0
     * @throws InsufficientFundsException exception throws if amount of money requested is bigger then balance
     */
    public void withdrawMoney(BigDecimal amountOfMoney) throws IllegalMoneyAmountException, InsufficientFundsException {
        if (amountOfMoney.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalMoneyAmountException("Error! Inputted sum is less then zero!");
        }

        if (balance.compareTo(amountOfMoney) < 0){
            throw new InsufficientFundsException();
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
