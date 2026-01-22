package com.xyz.moviebooking.controller;

import com.xyz.moviebooking.dto.MovieResponse;
import com.xyz.moviebooking.dto.ShowtimeResponse;
import com.xyz.moviebooking.dto.TheaterShowtimesResponse;
import com.xyz.moviebooking.model.Showtime;
import com.xyz.moviebooking.model.Theater;
import com.xyz.moviebooking.service.MovieCatalogService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieCatalogService catalogService;

    public MovieController(MovieCatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public List<MovieResponse> listMovies(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String genre
    ) {
        return catalogService.listMovies(city, language, genre).stream()
                .map(movie -> new MovieResponse(
                        movie.getId(),
                        movie.getTitle(),
                        movie.getLanguage(),
                        movie.getGenre(),
                        movie.getCities()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{movieId}/theaters")
    public List<TheaterShowtimesResponse> listTheatersForMovie(
            @PathVariable String movieId,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String date
    ) {
        LocalDate selectedDate = date == null ? null : LocalDate.parse(date);
        List<Showtime> showtimes = catalogService.listShowtimes(movieId, city, selectedDate);
        Map<String, List<Showtime>> byTheater = showtimes.stream()
                .collect(Collectors.groupingBy(Showtime::getTheaterId));

        return byTheater.entrySet().stream()
                .map(entry -> {
                    Theater theater = catalogService.getTheater(entry.getKey());
                    List<ShowtimeResponse> responses = entry.getValue().stream()
                            .map(showtime -> new ShowtimeResponse(
                                    showtime.getId(),
                                    showtime.getTheaterId(),
                                    showtime.getCity(),
                                    showtime.getStartTime(),
                                    showtime.getAvailableSeats()
                            ))
                            .collect(Collectors.toList());
                    return new TheaterShowtimesResponse(
                            theater.getId(),
                            theater.getName(),
                            theater.getCity(),
                            responses
                    );
                })
                .collect(Collectors.toList());
    }
}
