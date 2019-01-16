package com.codesolt.springbootreactive.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Coin {
	 
	@JsonProperty("book")
	private String book;
	 
	@JsonProperty("minimum_amount")
	private String minimumAmount;
	 
	@JsonProperty("maximum_amount")
	private String maximumAmount;
	 
	@JsonProperty("minimum_price")
	private String minimumPrice;
	 
	@JsonProperty("maximum_price")
	private String maximumPrice;
	 
	@JsonProperty("minimum_value")
	private String minimumValue;
	 
	@JsonProperty("maximum_value")
	private String maximumValue;
}