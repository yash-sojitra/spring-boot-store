package com.codewithmosh.store.exceptions;

public class OrderNotfoundException extends RuntimeException {
    public OrderNotfoundException() {
        super("order not found");
    }
}
