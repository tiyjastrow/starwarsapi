package com.starwarsapi.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
public class StarwarsController {
    private static final String HELLO = "Hello Star Wars API demo code!";
    private RestTemplate restTemplate = new RestTemplate();


    /**
     * Endpoints to build
     *  1. Return a list of the Starships related to Luke Skywalker
     *  2. Return the classification of all species in the 1st episode
     *  3. Return the total population of all planets in the Galaxy
     */

    // Galaxy population
    @GetMapping("/population")
    @ResponseBody
    public String population() {
        long population = 0;
        int pageNum = 1;

        while (true) {
            PlanetSearch planetSearch = getNextPlanetSearch(pageNum);
            population += planetSearch.results().stream()
                    .mapToLong( Planet::getPopulationValue )
                    .sum();
            if (planetSearch.next() == null) break;
            pageNum++;
        }

        return "Galaxy's Population of all planets: " + NumberFormat.getInstance().format(population);
    }

    private PlanetSearch getNextPlanetSearch(int pageNum) {
        return restTemplate.getForObject(PlanetSearch.NEXT_PAGE_URI + pageNum, PlanetSearch.class);
    }

    // 1st episode species types
    @GetMapping("/speciesTypes")
    @ResponseBody
    public String speciesTypes() {
        // get the list of species from "A New Hope"
        Film film = restTemplate.getForObject(FilmSearch.SEARCH_URI + "Hope", FilmSearch.class).results().get(0);
        // TODO: Expect only 1 result; later validate or improve search keyword
        ArrayList<String> speciesTypes = new ArrayList<>();
        for (String s : film.species()) {
            String newSpeciesType = restTemplate.getForObject(s, Species.class).classification();
            if (!speciesTypes.contains(newSpeciesType)) speciesTypes.add(newSpeciesType);
        }
        String str = "A New Hope's species types: " + speciesTypes.stream()
                .map(s -> s + ", ")
                .collect(Collectors.joining("", "", ""));
        return (str.endsWith(", ")) ? str.substring(0, str.length() - 2) : str;
    }

    // Starships related to Luke Skywalker
    @GetMapping("/starships")
    @ResponseBody
    public String starships() {
        People luke = restTemplate.getForObject(People.LUKE_URI, People.class);
        String starshipNames = "";

        for (String s : luke.starships())
            starshipNames += restTemplate.getForObject(s, Starship.class).name() + ", ";

        if (starshipNames.endsWith(", "))
            starshipNames = starshipNames.substring(0, starshipNames.length() - 2);

        return luke.name() + "'s star ships: " + starshipNames;
    }


    @GetMapping("/hello")
    public String hello() {
        return HELLO;
    }

}
