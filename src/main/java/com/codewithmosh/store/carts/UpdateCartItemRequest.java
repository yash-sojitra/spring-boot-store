package com.codewithmosh.store.carts;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateCartItemRequest {
    @NotNull(message = "Quantity must be provided")
    @Min(value = 1, message = "Quantity must be greater than zero")
    @Max(value = 100, message= "Wuantiy must be less than 100")
    private Integer quantity;
}
