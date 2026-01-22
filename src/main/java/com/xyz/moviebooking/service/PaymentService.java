package com.xyz.moviebooking.service;

import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentResult charge(String bookingId, String paymentMethod, double amount) {
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment method is required");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        String paymentId = "pay-" + UUID.randomUUID();
        return new PaymentResult(paymentId, "SUCCESS");
    }
}
