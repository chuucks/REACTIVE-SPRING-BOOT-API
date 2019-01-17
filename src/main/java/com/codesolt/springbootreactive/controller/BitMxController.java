package com.codesolt.springbootreactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesolt.springbootreactive.model.Books;
import com.codesolt.springbootreactive.model.SingleTicker;
import com.codesolt.springbootreactive.service.CoinService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("bitmx/api")
public class BitMxController {

	@Autowired
	private CoinService service;
	
	@GetMapping("/book")
	public Flux<Books> getBooks() {
		return Flux.fromArray(Books.values());
	}
	

	@GetMapping("/book/{id}")
	public Mono<SingleTicker> getBook(@PathVariable String id) {
		return service.getTicker(id.toString());
	}
	
	@GetMapping("/book/{id}/status")
	public Mono<String> getBookStatus(@PathVariable String id) {
		return service.getTicker(id.toString())
			.map(
					ticker -> {
						if(ticker.getPayload().getAsk() > ticker.getPayload().getLast())
							return "Recommend to sell";
						else if(ticker.getPayload().getLast() > ticker.getPayload().getBid())
							return "Recommend to buy";
						else
							return "Recommend to wait";
					});
	}
	
}
