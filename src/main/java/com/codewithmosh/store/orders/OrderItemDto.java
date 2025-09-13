package com.codewithmosh.store.orders;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class OrderItemDto {
    private OrderItemProductDto product;
    private int quantity;
    private BigDecimal totalPrice;
}
