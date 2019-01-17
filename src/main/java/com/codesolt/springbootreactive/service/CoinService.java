package com.codesolt.springbootreactive.service;

import com.codesolt.springbootreactive.model.Coins;
import com.codesolt.springbootreactive.model.SingleTicker;
import com.codesolt.springbootreactive.model.Tickers;

import reactor.core.publisher.Mono;

public interface CoinService {

	Mono<Coins> getCoins();
	Mono<SingleTicker> getTicker(String id);
	Mono<Tickers> getTickers();	
}
