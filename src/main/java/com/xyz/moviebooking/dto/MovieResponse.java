package com.xyz.moviebooking.dto;

import java.util.List;

public class MovieResponse {
    private final String id;
    private final String title;
    private final String language;
    private final String genre;
    private final List<String> cities;

    public MovieResponse(String id, String title, String language, String genre, List<String> cities) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.genre = genre;
        this.cities = cities;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public List<String> getCities() {
        return cities;
    }
}
