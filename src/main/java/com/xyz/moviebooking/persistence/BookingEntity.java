package com.xyz.moviebooking.persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String bookingId;

    @Column(nullable = false)
    private String showtimeId;

    @Column(nullable = false)
    private String theaterId;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private int seatCount;

    @ElementCollection
    @CollectionTable(name = "booking_seats", joinColumns = @JoinColumn(name = "booking_id"))
    @Column(name = "seat_number", nullable = false)
    private List<String> seatNumbers = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime bookedAt;

    protected BookingEntity() {
    }

    public BookingEntity(String bookingId, String showtimeId, String theaterId, String customerName,
                         int seatCount, List<String> seatNumbers, LocalDateTime bookedAt) {
        this.bookingId = bookingId;
        this.showtimeId = showtimeId;
        this.theaterId = theaterId;
        this.customerName = customerName;
        this.seatCount = seatCount;
        this.seatNumbers = seatNumbers;
        this.bookedAt = bookedAt;
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

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }
}
