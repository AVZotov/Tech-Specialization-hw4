package ru.geekbrains.task01;

import ru.geekbrains.errors.InsufficientFundsException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;

public class Account {
    private final String accountNumber;
    private BigDecimal paymentAccount;

    private Account(String accountNumber, BigDecimal paymentAccount) {
        this.accountNumber = accountNumber;
        this.paymentAccount = paymentAccount;
    }

    public static Account createAccount(BigDecimal initialValue) throws IllegalArgumentException {
        if (initialValue.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Initial account balance is less than zero! Operation canceled");
        }
        return new Account(generateAccountNumber(), new BigDecimal(String.valueOf(initialValue)));
    }

    public void addMoney(BigDecimal moneyAmount){
        if (moneyAmount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Operation canceled, entered money amount is less then zero!");
        }

        paymentAccount = paymentAccount.add(moneyAmount);
    }

    public void moneyWithdrawal(BigDecimal moneyAmount) throws InsufficientFundsException{
        if (paymentAccount.compareTo(moneyAmount) < 0){
            throw new InsufficientFundsException();
        }

        paymentAccount = paymentAccount.subtract(moneyAmount);
    }

    @Override
    public String toString() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        String pattern = "$#,##0.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);

        return String.format("account: %s; payment account: %s;", accountNumber, decimalFormat.format(paymentAccount));
    }

    private static String generateAccountNumber(){
        Random random = new Random();
        StringBuilder account = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            account.append(random.nextInt(10));
        }

        return account.toString();
    }
}
