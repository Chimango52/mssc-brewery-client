package com.wagner.fernando.udemy.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.wagner.fernando.udemy.springframework.msscbreweryclient.web.model.BeerDto;


@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {
	
	public final String BEER_PATH_V1 = "/api/v1/beer/";
	private String apihost;

    private final RestTemplate restTemplate;

    @Autowired
    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto){
        restTemplate.put(apihost + BEER_PATH_V1 + "/" + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apihost + BEER_PATH_V1 + "/" + uuid );
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

}