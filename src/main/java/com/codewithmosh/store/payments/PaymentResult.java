package com.codewithmosh.store.payments;

import com.codewithmosh.store.entities.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PaymentResult {
    private long orderId;
    private PaymentStatus paymentStatus;
}
