package com.xyz.moviebooking.controller;

import com.xyz.moviebooking.dto.BookingRequest;
import com.xyz.moviebooking.dto.BookingResponse;
import com.xyz.moviebooking.model.Booking;
import com.xyz.moviebooking.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponse createBooking(@RequestBody BookingRequest request) {
        Booking booking = bookingService.createBooking(
                request.getShowtimeId(),
                request.getTheaterId(),
                request.getCustomerName(),
                request.getSeatNumbers()
        );
        return new BookingResponse(
                booking.getId(),
                booking.getShowtimeId(),
                booking.getTheaterId(),
                booking.getCustomerName(),
                booking.getSeatCount(),
                booking.getSeatNumbers(),
                booking.getBookedAt()
        );
    }
}
