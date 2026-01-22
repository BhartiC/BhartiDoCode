package com.xyz.moviebooking.service;

import com.xyz.moviebooking.model.Movie;
import com.xyz.moviebooking.model.Showtime;
import com.xyz.moviebooking.model.Theater;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MovieCatalogService {
    private final List<Movie> movies;
    private final List<Theater> theaters;
    private final List<Showtime> showtimes;

    public MovieCatalogService() {
        movies = Arrays.asList(
                new Movie("mov-101", "Galaxy Quest", "English", "Sci-Fi", Arrays.asList("Mumbai", "Delhi")),
                new Movie("mov-102", "City Lights", "Hindi", "Drama", Arrays.asList("Delhi", "Bengaluru")),
                new Movie("mov-103", "Ocean Beat", "Tamil", "Action", Arrays.asList("Chennai", "Hyderabad"))
        );

        theaters = Arrays.asList(
                new Theater("theater-01", "Starlight Cinemas", "Mumbai"),
                new Theater("theater-02", "Downtown Screens", "Delhi"),
                new Theater("theater-03", "City Center Multiplex", "Bengaluru"),
                new Theater("theater-04", "Marina PVR", "Chennai")
        );

        showtimes = Arrays.asList(
                new Showtime("show-201", "mov-101", "theater-01", "Mumbai", LocalDateTime.now().plusDays(1).withHour(19).withMinute(30), 120),
                new Showtime("show-202", "mov-101", "theater-02", "Delhi", LocalDateTime.now().plusDays(2).withHour(21).withMinute(0), 75),
                new Showtime("show-203", "mov-102", "theater-02", "Delhi", LocalDateTime.now().plusDays(1).withHour(18).withMinute(0), 60),
                new Showtime("show-204", "mov-102", "theater-03", "Bengaluru", LocalDateTime.now().plusDays(1).withHour(20).withMinute(15), 90),
                new Showtime("show-205", "mov-103", "theater-04", "Chennai", LocalDateTime.now().plusDays(3).withHour(20).withMinute(15), 90)
        );
    }

    public List<Movie> listMovies(String city, String language, String genre) {
        return movies.stream()
                .filter(movie -> city == null || movie.getCities().contains(city))
                .filter(movie -> language == null || movie.getLanguage().equalsIgnoreCase(language))
                .filter(movie -> genre == null || movie.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public List<Showtime> listShowtimes(String movieId, String city, LocalDate date) {
        return showtimes.stream()
                .filter(showtime -> showtime.getMovieId().equals(movieId))
                .filter(showtime -> city == null || showtime.getCity().equalsIgnoreCase(city))
                .filter(showtime -> date == null || showtime.getStartTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    public Showtime getShowtime(String showtimeId) {
        return showtimes.stream()
                .filter(showtime -> showtime.getId().equals(showtimeId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Showtime not found"));
    }

    public Theater getTheater(String theaterId) {
        return theaters.stream()
                .filter(theater -> theater.getId().equals(theaterId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Theater not found"));
    }

    public List<Theater> listTheaters(String city) {
        return theaters.stream()
                .filter(theater -> city == null || theater.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Showtime> listAllShowtimes() {
        return showtimes;
    }

}
