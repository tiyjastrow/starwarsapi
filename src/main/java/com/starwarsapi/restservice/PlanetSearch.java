package com.starwarsapi.restservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanetSearch(int count, String next, String previous, ArrayList<Planet> results) {
    public static final String NEXT_PAGE_URI ="https://swapi.dev/api/planets/?page=";

    @Override
    public int count() {
        return count;
    }

    @Override
    public String next() {
        return next;
    }

    @Override
    public String previous() {
        return previous;
    }

    @Override
    public ArrayList<Planet> results() {
        return results;
    }
}
