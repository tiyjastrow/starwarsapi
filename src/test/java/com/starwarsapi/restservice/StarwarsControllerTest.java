package com.starwarsapi.restservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class StarwarsControllerTest {

    @Autowired
    private StarwarsController starwarsController;

    @Autowired
    private RestTemplate restTemplate;

    final String BASE_URL = "http://localhost:8080/";

    @Test
    public void contextLoads() throws Exception {
        assertThat(starwarsController).isNotNull();
    }

    @Test
    @DisplayName("People_test")
    public void testStarshipsRelatedToLuke() {
        String uri = BASE_URL + "starships";
        assertThat(this.restTemplate.getForObject(uri, String.class))
                .contains("Luke")
                .contains("star ships")
                .contains("X-wing");
    }

    @Test
    @DisplayName("Hello_test")
    public void testHello() throws Exception {
        String uri = BASE_URL + "hello";
        assertThat(this.restTemplate.getForObject(uri, String.class))
                .contains("Hello Star Wars API demo code");
    }
}