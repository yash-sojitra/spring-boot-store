package com.codewithmosh.store.orders;

public class OrderNotfoundException extends RuntimeException {
    public OrderNotfoundException() {
        super("order not found");
    }
}
