package com.starter.pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="CashAndCarry")
public class ResultCAC_db {
	private double bid_spotPrice, ask_spotPrice,bid_futurePrice, ask_futurePrice;
	private double duration;
	private double bid_rfr,ask_rfr ;
	private double lot_size; 
	private double brokerage;
	private String arbitrage=new String();
	private double profit;
	
	@Id
	private double transId;

	public ResultCAC_db() {

		super();
	
	}

	public double getBid_spotPrice() {
		return bid_spotPrice;
	}

	public void setBid_spotPrice(double bid_spotPrice) {
		this.bid_spotPrice = bid_spotPrice;
	}

	public double getAsk_spotPrice() {
		return ask_spotPrice;
	}

	public void setAsk_spotPrice(double ask_spotPrice) {
		this.ask_spotPrice = ask_spotPrice;
	}

	public double getBid_futurePrice() {
		return bid_futurePrice;
	}

	public void setBid_futurePrice(double bid_futurePrice) {
		this.bid_futurePrice = bid_futurePrice;
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

	public String getArbitrage() {
		return arbitrage;
	}

	public void setArbitrage(String arbitrage) {
		this.arbitrage = arbitrage;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public double getTransId() {
		return transId;
	}

	public void setTransId(double transId) {
		this.transId = transId;
	}
	

	public ResultCAC_db(double bid_spotPrice, double ask_spotPrice, double bid_futurePrice, double ask_futurePrice,
			double duration, double bid_rfr, double ask_rfr, double lot_size, double brokerage, String arbitrage,
			double profit, double transId) {
		super();
		this.bid_spotPrice = bid_spotPrice;
		this.ask_spotPrice = ask_spotPrice;
		this.bid_futurePrice = bid_futurePrice;
		this.ask_futurePrice = ask_futurePrice;
		this.duration = duration;
		this.bid_rfr = bid_rfr;
		this.ask_rfr = ask_rfr;
		this.lot_size = lot_size;
		this.brokerage = brokerage;
		this.arbitrage = arbitrage;
		this.profit = profit;
		this.transId = transId;
	}

}
