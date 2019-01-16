package com.codesolt.springbootreactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.codesolt.springbootreactive.model.Coins;
import com.codesolt.springbootreactive.model.Tickers;
import com.codesolt.springbootreactive.service.CoinService;

import reactor.core.publisher.Mono;

public class BitMxHandler {

	@Autowired
	private CoinService coinService;
	
	public Mono<ServerResponse> getCoins(ServerRequest serverRequest) {
	    final Mono<Coins> coins = coinService.getCoins();	            
	    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(coins, Coins.class);
	}
	
	public Mono<ServerResponse> getTickers(ServerRequest serverRequest) {
	    final Mono<Tickers> tickers = coinService.getTickers();	            
	    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(tickers, Tickers.class);
	}
}
