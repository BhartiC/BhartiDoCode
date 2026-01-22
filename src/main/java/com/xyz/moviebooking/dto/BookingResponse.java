package com.xyz.moviebooking.dto;

import java.time.LocalDateTime;

public class BookingResponse {
    private final String bookingId;
    private final String showtimeId;
    private final String theaterId;
    private final String customerName;
    private final int seatCount;
    private final java.util.List<String> seatNumbers;
    private final LocalDateTime bookedAt;
    private final String paymentId;
    private final String paymentStatus;

    public BookingResponse(String bookingId, String showtimeId, String theaterId, String customerName, int seatCount,
                           java.util.List<String> seatNumbers, LocalDateTime bookedAt, String paymentId,
                           String paymentStatus) {
        this.bookingId = bookingId;
        this.showtimeId = showtimeId;
        this.theaterId = theaterId;
        this.customerName = customerName;
        this.seatCount = seatCount;
        this.seatNumbers = seatNumbers;
        this.bookedAt = bookedAt;
        this.paymentId = paymentId;
        this.paymentStatus = paymentStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getShowtimeId() {
        return showtimeId;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public java.util.List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}
