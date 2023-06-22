package com.starwarsapi.restservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Planet(String name, String population) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public String population() {
        return population;
    }
}
