package com.codesolt.springbootreactive.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SingleTicker extends CommonModel {

	@Builder
	public SingleTicker(String success, Ticker payload) {
		super(success);
		this.payload = payload;
	}

	@JsonProperty("payload")
	private Ticker payload;		
	
	@Data
	public class Ticker {
		
		@JsonProperty("book")
		private String book;
		
		@JsonProperty("high")
	    private String high;
		
		@JsonProperty("low")
	    private String low;
		
		@JsonProperty("last")
	    private String last;
		
		@JsonProperty("volume")
	    private String volume;		
		
		@JsonProperty("vwap")
	    private String vwap;
		
		@JsonProperty("ask")
	    private String ask;
		
		@JsonProperty("bid")
	    private String bid;
				
		@JsonProperty("change_24")
	    private String change;
	
		@JsonProperty("created_at")
	    private String createdAt;
		
		public double getBid() {
			return Double.valueOf(bid);
		}
		
		public double getAsk() {
			return Double.valueOf(bid);
		}
		
		public double getLast() {
			return Double.valueOf(last);
		}
	
	}
}
