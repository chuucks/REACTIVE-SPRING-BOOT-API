package com.codesolt.springbootreactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.codesolt.springbootreactive.model.Coins;
import com.codesolt.springbootreactive.model.Tickers;

import reactor.core.publisher.Mono;

@Service
public class CoinServiceImp implements CoinService {

    @Autowired
    private WebClient webClient;
	
    @Override
    public Mono<Coins> getCoins() {
    	return webClient.get().uri("https://api.bitso.com/v3/available_books/")
    			.retrieve().bodyToMono(Coins.class);
    }
    
    @Override
    public Mono<Tickers> getTickers() {
    	return webClient.get().uri("https://api.bitso.com/v3/ticker/")
    			.retrieve().bodyToMono(Tickers.class);
    }   
}
