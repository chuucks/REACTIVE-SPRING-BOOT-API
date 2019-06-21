package com.codesolt.springbootreactive.controller;

import com.codesolt.springbootreactive.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesolt.springbootreactive.model.Book;
import com.codesolt.springbootreactive.model.SingleTicker;
import com.codesolt.springbootreactive.service.CoinService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Profile("prod")
@RestController
@RequestMapping("bitmx/api")
public class BitMxControllerImp implements BitMxController {

	@Autowired
	private CoinService service;

	@Autowired
	private BookRepository repository;

	@Override
	@GetMapping("/book")
	public Flux<Book> getBooks() {
		return repository.findAll();
	}

	@Override
	@GetMapping("/book/{id}")
	public Mono<SingleTicker> getBook(@PathVariable String id) {
		return service.getTicker(id);
	}

	@Override
	@GetMapping("/book/{id}/status")
	public Mono<String> getBookStatus(@PathVariable String id) {
		return service.getTicker(id)
			.map(
					ticker -> {
						if(ticker.getPayload().getAsk() > ticker.getPayload().getLast())
							return "Recommend to sell";
						else if(ticker.getPayload().getLast() > ticker.getPayload().getBid())
							return "Recommend to buy";
						else
							return "Recommend to hold";
					});
	}
	
}
