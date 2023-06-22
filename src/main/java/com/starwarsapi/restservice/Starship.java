package com.starwarsapi.restservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Starship(String name) {

    public static String shipNames(ArrayList<String> ships) {

        return null;
    }
}
