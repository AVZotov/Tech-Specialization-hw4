package ru.geekbrains.errors;

public class IllegalTransactionException extends Exception{
    public IllegalTransactionException(String message) {
        super(message);
    }
}
