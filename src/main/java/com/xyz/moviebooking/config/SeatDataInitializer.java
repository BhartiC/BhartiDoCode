package com.xyz.moviebooking.config;

import com.xyz.moviebooking.model.Showtime;
import com.xyz.moviebooking.persistence.SeatEntity;
import com.xyz.moviebooking.persistence.SeatStatus;
import com.xyz.moviebooking.repository.SeatRepository;
import com.xyz.moviebooking.service.MovieCatalogService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeatDataInitializer implements CommandLineRunner {
    private final MovieCatalogService catalogService;
    private final SeatRepository seatRepository;

    public SeatDataInitializer(MovieCatalogService catalogService, SeatRepository seatRepository) {
        this.catalogService = catalogService;
        this.seatRepository = seatRepository;
    }

    @Override
    public void run(String... args) {
        for (Showtime showtime : catalogService.listAllShowtimes()) {
            if (seatRepository.countByShowtimeId(showtime.getId()) > 0) {
                continue;
            }
            List<SeatEntity> seats = new ArrayList<>();
            for (char row = 'A'; row <= 'C'; row++) {
                for (int seat = 1; seat <= 5; seat++) {
                    seats.add(new SeatEntity(showtime.getId(), row + String.valueOf(seat), SeatStatus.AVAILABLE));
                }
            }
            seatRepository.saveAll(seats);
        }
    }
}
