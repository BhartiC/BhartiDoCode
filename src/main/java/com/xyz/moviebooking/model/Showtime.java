package com.xyz.moviebooking.model;

import java.time.LocalDateTime;

public class Showtime {
    private final String id;
    private final String movieId;
    private final String theaterId;
    private final String city;
    private final LocalDateTime startTime;
    private final int availableSeats;

    public Showtime(String id, String movieId, String theaterId, String city, LocalDateTime startTime, int availableSeats) {
        this.id = id;
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.city = city;
        this.startTime = startTime;
        this.availableSeats = availableSeats;
    }

    public String getId() {
        return id;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
