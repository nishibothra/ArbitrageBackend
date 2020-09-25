package com.pojo;

public class parameters {

	private double bid,ask;

	
	public parameters(double bid, double ask) {
		super();
		this.bid = bid;
		this.ask = ask;
	}
	
	
	public parameters() {
		super();
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}
	
	
	
}
