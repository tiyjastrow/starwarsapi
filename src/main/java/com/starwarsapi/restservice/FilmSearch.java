package com.starwarsapi.restservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FilmSearch(ArrayList<Film> results) {
    public static final String SEARCH_URI = "https://swapi.dev/api/films/?search=";

    @Override
    public ArrayList<Film> results() {
        return results;
    }
}
