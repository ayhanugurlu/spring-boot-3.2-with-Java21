package com.au.example.springboot32withjava21.client.rest;

import org.springframework.web.client.RestClient;

public class RestClientExample {

    private final RestClient restClient;

    public RestClientExample(RestClient.Builder builder) {
        //http factory can configurable
        this.restClient = builder.build();
    }

    public CatFact getCatFact() {
        return restClient.get()
                .uri("https://cat-fact.herokuapp.com/facts/random")
                .retrieve()
                .body(CatFact.class);
    }
}


record CatFact(String fact) {
}