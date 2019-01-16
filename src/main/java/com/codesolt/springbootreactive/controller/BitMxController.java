package com.codesolt.springbootreactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesolt.springbootreactive.model.Coins;
import com.codesolt.springbootreactive.model.Tickers;
import com.codesolt.springbootreactive.service.CoinService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("bitmx/")
public class BitMxController {
	
	@Autowired
	private CoinService coinService;
	
	@GetMapping("coin/")
	public Mono<Coins> getCoins() {
		return coinService.getCoins();	
	}
	
	@GetMapping("ticker/")
	public Mono<Tickers> getTickers() {
		return coinService.getTickers();	
	}
}
