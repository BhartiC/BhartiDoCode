package com.xyz.moviebooking.service;

import com.xyz.moviebooking.model.Booking;
import com.xyz.moviebooking.model.Showtime;
import com.xyz.moviebooking.persistence.BookingEntity;
import com.xyz.moviebooking.persistence.SeatEntity;
import com.xyz.moviebooking.persistence.SeatStatus;
import com.xyz.moviebooking.repository.BookingRepository;
import com.xyz.moviebooking.repository.SeatRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {
    private final MovieCatalogService catalogService;
    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;
    private final PaymentService paymentService;

    public BookingService(MovieCatalogService catalogService, SeatRepository seatRepository,
                          BookingRepository bookingRepository, PaymentService paymentService) {
        this.catalogService = catalogService;
        this.seatRepository = seatRepository;
        this.bookingRepository = bookingRepository;
        this.paymentService = paymentService;
    }

    @Transactional
    public BookingWithPayment createBooking(String showtimeId, String theaterId, String customerName,
                                            List<String> seatNumbers, String paymentMethod, double amount) {
        Showtime showtime = catalogService.getShowtime(showtimeId);
        if (!showtime.getTheaterId().equals(theaterId)) {
            throw new IllegalArgumentException("Showtime does not belong to selected theater");
        }
        if (seatNumbers == null || seatNumbers.isEmpty()) {
            throw new IllegalArgumentException("Select at least one seat");
        }
        List<String> normalizedSeats = seatNumbers.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        List<SeatEntity> seats = seatRepository.findSeatsForUpdate(showtimeId, normalizedSeats);
        if (seats.size() != normalizedSeats.size()) {
            throw new IllegalArgumentException("One or more seats are invalid");
        }
        for (SeatEntity seat : seats) {
            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new IllegalArgumentException("One or more seats are not available");
            }
        }
        seats.forEach(seat -> seat.setStatus(SeatStatus.BOOKED));
        seatRepository.saveAll(seats);

        int seatCount = normalizedSeats.size();
        String bookingId = UUID.randomUUID().toString();
        BookingEntity bookingEntity = new BookingEntity(
                bookingId,
                showtime.getId(),
                showtime.getTheaterId(),
                customerName,
                seatCount,
                normalizedSeats,
                LocalDateTime.now()
        );
        BookingEntity saved = bookingRepository.save(bookingEntity);
        PaymentResult paymentResult = paymentService.charge(bookingId, paymentMethod, amount);
        Booking booking = new Booking(
                saved.getBookingId(),
                saved.getShowtimeId(),
                saved.getTheaterId(),
                saved.getCustomerName(),
                saved.getSeatCount(),
                saved.getSeatNumbers(),
                saved.getBookedAt()
        );
        return new BookingWithPayment(booking, paymentResult);
    }
}
