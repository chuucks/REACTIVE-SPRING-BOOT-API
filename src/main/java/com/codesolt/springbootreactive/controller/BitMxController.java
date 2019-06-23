package com.codesolt.springbootreactive.controller;

import com.codesolt.springbootreactive.model.Book;
import com.codesolt.springbootreactive.model.CommonResponse;
import com.codesolt.springbootreactive.model.SingleTicker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BitMxController {

	Flux<Book> getBooks();
	Mono<SingleTicker> getBook(String id);
	Mono<CommonResponse> getBookStatus(String id);
}
