package com.starter.pojo;

public class Parameters {

	private double bid,ask;

	
	public Parameters(double bid, double ask) {
		super();
		this.bid = bid;
		this.ask = ask;
	}
	
	
	public Parameters() {
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
