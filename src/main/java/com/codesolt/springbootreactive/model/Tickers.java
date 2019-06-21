package com.codesolt.springbootreactive.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
public class Tickers extends CommonModel {

	@Builder
	public Tickers(String success, List<Ticker> payload) {
		super(success);
		this.payload = payload;
	}

	@JsonProperty("payload")
	private List<Ticker> payload;
}