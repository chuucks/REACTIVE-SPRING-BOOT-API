package com.codesolt.springbootreactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.codesolt.springbootreactive.model.Coins;
import com.codesolt.springbootreactive.model.SingleTicker;
import com.codesolt.springbootreactive.model.Tickers;

import reactor.core.publisher.Mono;

@Service
@Profile("prod")
public class CoinServiceImp implements CoinService {

    @Autowired
    private WebClient webClient;

    @Value("${app.api.client.uri}")
    private String BASE_URI;

    @Override
    public Mono<Coins> getCoins() {
    	return webClient.get().uri(BASE_URI + "available_books/")
    			.retrieve().bodyToMono(Coins.class);
    }

    @Override
    public Mono<SingleTicker> getTicker(String id) {
    	return webClient.get().uri(BASE_URI + "/ticker/?book={id}", id)
    			.retrieve().bodyToMono(SingleTicker.class);
    }
    
    @Override
    public Mono<Tickers> getTickers() {
    	return webClient.get().uri(BASE_URI + "/ticker/")
    			.retrieve().bodyToMono(Tickers.class);
    }
}
