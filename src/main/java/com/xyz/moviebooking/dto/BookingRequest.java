package com.xyz.moviebooking.dto;

public class BookingRequest {
    private String showtimeId;
    private String theaterId;
    private String customerName;
    private String paymentMethod;
    private double amount;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public java.util.List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(java.util.List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }
}
