package com.starwarsapi.restservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Film(String title, ArrayList<String> species) {

    @Override
    public String title() {
        return title;
    }

    @Override
    public ArrayList<String> species() {
        return species;
    }
}
