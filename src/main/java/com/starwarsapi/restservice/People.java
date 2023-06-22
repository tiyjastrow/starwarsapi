package com.starwarsapi.restservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record People(String name, ArrayList<String> starships) {
    public static final String PEOPLE_URI = "https://swapi.dev/api/people";
    public static final String LUKE_URI = PEOPLE_URI + "/1";

    @Override
    public String name() {
        return name;
    }

    @Override
    public ArrayList<String> starships() {
        return starships;
    }
}
