package com.codesolt.springbootreactive.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
public class Coins extends CommonModel {

	@Builder
	public Coins(String success, List<Coin> payload) {
		super(success);
		this.payload = payload;
	}

	@JsonProperty("payload")
	private List<Coin> payload;
}