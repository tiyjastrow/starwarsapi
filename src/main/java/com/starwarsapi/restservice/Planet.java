package com.starwarsapi.restservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Planet(String name, String population) {
    public long getPopulationValue() {
        long result = 0;
        try {
            result = Long.parseLong(this.population);
        }
        catch ( Exception e ) {
            System.out.println("Could not parse '" + this.population + "' as Long");
        }
        return result;
    }
}
