package com.codesolt.springbootreactive.controller;

import com.codesolt.springbootreactive.model.SingleTicker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
				.expectBody(String.class);
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
				.expectBody(SingleTicker.class);
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
				.expectBody(String.class);
	}

}

