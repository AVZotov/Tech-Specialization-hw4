package ru.geekbrains.errors;

public class InsufficientFundsException extends Exception{

    public InsufficientFundsException() {
    }

    @Override
    public String getMessage() {
        return "Insufficient amount of money on your bank account";
    }
}
