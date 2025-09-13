package com.codewithmosh.store.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class CartDto {
    private UUID Id;
    private List<CartItemDto> items = new ArrayList<>();
    private BigDecimal price = BigDecimal.ZERO;
}
