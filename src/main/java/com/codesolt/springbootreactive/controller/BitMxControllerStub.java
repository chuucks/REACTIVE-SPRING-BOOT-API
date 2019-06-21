package com.codesolt.springbootreactive.controller;

import com.codesolt.springbootreactive.model.Book;
import com.codesolt.springbootreactive.model.SingleTicker;
import com.codesolt.springbootreactive.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Profile("test")
@RestController
@RequestMapping("bitmx/api")
public class BitMxControllerStub implements BitMxController {

	@Autowired
	private CoinService service;

	@Override
	@GetMapping("/book")
	public Flux<Book> getBooks() {

	    Book book = Book
				.builder()
                .id(UUID.randomUUID())
				.bookCode("code")
                .bookDescription("description")
                .bookCurrency("mxn")
				.build();

		List<Book> books = new ArrayList<>();
		books.add(book);
		books.add(book);
		books.add(book);

		return Flux.fromIterable(books);
	}

	@Override
	@GetMapping("/book/{id}")
	public Mono<SingleTicker> getBook(@PathVariable String id) {
		return service.getTicker(id);
	}

	@Override
	@GetMapping("/book/{id}/status")
	public Mono<String> getBookStatus(@PathVariable String id) {
        String response = new StringBuilder("Recommend to hold").toString();
		return Mono.just(response);
	}

}
