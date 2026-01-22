package com.xyz.moviebooking.dto;

import java.time.LocalDateTime;

public class ShowtimeResponse {
    private final String id;
    private final String theaterId;
    private final String city;
    private final LocalDateTime startTime;
    private final int availableSeats;

    public ShowtimeResponse(String id, String theaterId, String city, LocalDateTime startTime, int availableSeats) {
        this.id = id;
        this.theaterId = theaterId;
        this.city = city;
        this.startTime = startTime;
        this.availableSeats = availableSeats;
    }

    public String getId() {
        return id;
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
