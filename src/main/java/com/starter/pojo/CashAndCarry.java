package com.starter.pojo;

public class CashAndCarry {
	private double bid_spotPrice, ask_spotPrice,bid_futurePrice, ask_futurePrice;
	private double duration;
	private double bid_rfr,ask_rfr ;
	private double lot_size; 
	private double brokerage;
	private String arbitrage=new String();
	private double profit;
	
	

	public CashAndCarry() {

	}

	public CashAndCarry(double bsp, double asp,double bfp, double afp, double d,double brate,double arate,double lotsize,double brk) {
		bid_spotPrice= bsp;
		ask_spotPrice=asp;
		bid_futurePrice = bfp;
		ask_futurePrice=afp;
		duration=d;
		bid_rfr=brate;
		ask_rfr=arate;
		lot_size=lotsize;
		brokerage=brk;
	  }
	
	public double getBid_spotPrice() {
		return bid_spotPrice;
	}

	public void setBid_spotPrice(double bid_spotPrice) {
		this.bid_spotPrice = bid_spotPrice;
	}

	public double getBid_futurePrice() {
		return bid_futurePrice;
	}

	public void setBid_futurePrice(double bid_futurePrice) {
		this.bid_futurePrice = bid_futurePrice;
	}

	public double getAsk_spotPrice() {
		return ask_spotPrice;
	}

	public void setAsk_spotPrice(double ask_spotPrice) {
		this.ask_spotPrice = ask_spotPrice;
	}

	public double getAsk_futurePrice() {
		return ask_futurePrice;
	}

	public void setAsk_futurePrice(double ask_futurePrice) {
		this.ask_futurePrice = ask_futurePrice;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getBid_rfr() {
		return bid_rfr;
	}

	public void setBid_rfr(double bid_rfr) {
		this.bid_rfr = bid_rfr;
	}

	public double getAsk_rfr() {
		return ask_rfr;
	}

	public void setAsk_rfr(double ask_rfr) {
		this.ask_rfr = ask_rfr;
	}

	public double getLot_size() {
		return lot_size;
	}

	public void setLot_size(double lot_size) {
		this.lot_size = lot_size;
	}

	public double getBrokerage() {
		return brokerage;
	}

	public void setBrokerage(double brokerage) {
		this.brokerage = brokerage;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public String getArbitrage() {
		return arbitrage;
	}

	public void setArbitrage(String arbitrage) {
		this.arbitrage = arbitrage;
	}

	


}
