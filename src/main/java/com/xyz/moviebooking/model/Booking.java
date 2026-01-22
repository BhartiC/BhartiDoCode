package com.xyz.moviebooking.model;

import java.time.LocalDateTime;

public class Booking {
    private final String id;
    private final String showtimeId;
    private final String theaterId;
    private final String customerName;
    private final int seatCount;
    private final java.util.List<String> seatNumbers;
    private final LocalDateTime bookedAt;

    public Booking(String id, String showtimeId, String theaterId, String customerName, int seatCount,
                   java.util.List<String> seatNumbers, LocalDateTime bookedAt) {
        this.id = id;
        this.showtimeId = showtimeId;
        this.theaterId = theaterId;
        this.customerName = customerName;
        this.seatCount = seatCount;
        this.seatNumbers = seatNumbers;
        this.bookedAt = bookedAt;
    }

    public String getId() {
        return id;
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
}
