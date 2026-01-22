package com.xyz.moviebooking.dto;

public class BookingRequest {
    private String showtimeId;
    private String theaterId;
    private String customerName;
    private java.util.List<String> seatNumbers;

    public String getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(String showtimeId) {
        this.showtimeId = showtimeId;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public java.util.List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(java.util.List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }
}
