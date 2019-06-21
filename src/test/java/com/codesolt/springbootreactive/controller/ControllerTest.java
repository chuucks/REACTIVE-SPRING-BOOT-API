package com.codesolt.springbootreactive.controller;

import com.codesolt.springbootreactive.model.Book;
import com.codesolt.springbootreactive.model.SingleTicker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(exclude={
		CassandraDataAutoConfiguration.class})
public class ControllerTest {

	@Autowired
	ApplicationContext context;

	private WebTestClient webTestClient;

	@Before
	public void setUp() throws Exception {

		webTestClient = WebTestClient
							.bindToApplicationContext(context)
							.configureClient()
							.baseUrl("/bitmx/api")
							.build();
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void getBooksTest() {

		webTestClient.get()
				.uri("/book")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				.expectBody(String.class)
				.consumeWith(response -> {
					assertNotNull(response.getResponseBody());
				});
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void getBook() {

		webTestClient.get()
				.uri("/book/{id}", "btc_mxn")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				.expectBody()
				.consumeWith(response -> {
					assertNotNull(response.getResponseBody());
				});
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void getBookStatus() {

		webTestClient.get()
				.uri("/book/{id}/status", "btc_mxn")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				.expectBody()
				.consumeWith(response -> {
					assertNotNull(response.getResponseBody());
				});
	}
}

