package com.xyz.moviebooking.dto;

import java.util.List;

public class TheaterShowtimesResponse {
    private final String theaterId;
    private final String theaterName;
    private final String city;
    private final List<ShowtimeResponse> showtimes;

    public TheaterShowtimesResponse(String theaterId, String theaterName, String city, List<ShowtimeResponse> showtimes) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.city = city;
        this.showtimes = showtimes;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public String getCity() {
        return city;
    }

    public List<ShowtimeResponse> getShowtimes() {
        return showtimes;
    }
}
