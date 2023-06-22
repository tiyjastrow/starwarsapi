package com.starwarsapi.restservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Species(String name, String classification) {
    public static final String SPECIES_URI = "https://swapi.dev/api/species";

    @Override
    public String name() {
        return name;
    }

    @Override
    public String classification() {
        return classification;
    }
}
