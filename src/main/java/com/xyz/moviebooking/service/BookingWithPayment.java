package com.xyz.moviebooking.service;

import com.xyz.moviebooking.model.Booking;

public class BookingWithPayment {
    private final Booking booking;
    private final PaymentResult paymentResult;

    public BookingWithPayment(Booking booking, PaymentResult paymentResult) {
        this.booking = booking;
        this.paymentResult = paymentResult;
    }

    public Booking getBooking() {
        return booking;
    }

    public PaymentResult getPaymentResult() {
        return paymentResult;
    }
}
