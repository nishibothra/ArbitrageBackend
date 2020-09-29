package com.starter.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name="result_fx")
public class Result_fx_db {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private double TransId;
	
	private double bid_spot,ask_spot,bid_3m,ask_3m,int_c1_bid,int_c2_ask,int_c1_ask,int_c2_bid;
	private String result,choice;
	private double fx_p_l;
	public double getTransId() {
		return TransId;
	}
	public void setTransId(double transId) {
		TransId = transId;
	}
	public double getBid_spot() {
		return bid_spot;
	}
	public void setBid_spot(double bid_spot) {
		this.bid_spot = bid_spot;
	}
	public double getAsk_spot() {
		return ask_spot;
	}
	public void setAsk_spot(double ask_spot) {
		this.ask_spot = ask_spot;
	}
	public double getBid_3m() {
		return bid_3m;
	}
	public void setBid_3m(double bid_3m) {
		this.bid_3m = bid_3m;
	}
	public double getAsk_3m() {
		return ask_3m;
	}
	public void setAsk_3m(double ask_3m) {
		this.ask_3m = ask_3m;
	}
	public double getInt_c1_bid() {
		return int_c1_bid;
	}
	public void setInt_c1_bid(double int_c1_bid) {
		this.int_c1_bid = int_c1_bid;
	}
	public double getInt_c2_ask() {
		return int_c2_ask;
	}
	public void setInt_c2_ask(double int_c2_ask) {
		this.int_c2_ask = int_c2_ask;
	}
	public double getInt_c1_ask() {
		return int_c1_ask;
	}
	public void setInt_c1_ask(double int_c1_ask) {
		this.int_c1_ask = int_c1_ask;
	}
	public double getInt_c2_bid() {
		return int_c2_bid;
	}
	public void setInt_c2_bid(double int_c2_bid) {
		this.int_c2_bid = int_c2_bid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public double getFx_p_l() {
		return fx_p_l;
	}
	public void setFx_p_l(double fx_p_l) {
		this.fx_p_l = fx_p_l;
	}
	
	public Result_fx_db() {
		super();
	}
	public Result_fx_db(double transId, double bid_spot, double ask_spot, double bid_3m, double ask_3m,
			double int_c1_bid, double int_c2_ask, double int_c1_ask, double int_c2_bid, String result, String choice,
			double fx_p_l) {
		super();
		TransId = transId;
		this.bid_spot = bid_spot;
		this.ask_spot = ask_spot;
		this.bid_3m = bid_3m;
		this.ask_3m = ask_3m;
		this.int_c1_bid = int_c1_bid;
		this.int_c2_ask = int_c2_ask;
		this.int_c1_ask = int_c1_ask;
		this.int_c2_bid = int_c2_bid;
		this.result = result;
		this.choice = choice;
		this.fx_p_l = fx_p_l;
	}
	public Result_fx_db(double bid_spot, double ask_spot, double bid_3m, double ask_3m, double int_c1_bid,
			double int_c2_ask, double int_c1_ask, double int_c2_bid, String result, String choice, double fx_p_l) {
		super();
		this.bid_spot = bid_spot;
		this.ask_spot = ask_spot;
		this.bid_3m = bid_3m;
		this.ask_3m = ask_3m;
		this.int_c1_bid = int_c1_bid;
		this.int_c2_ask = int_c2_ask;
		this.int_c1_ask = int_c1_ask;
		this.int_c2_bid = int_c2_bid;
		this.result = result;
		this.choice = choice;
		this.fx_p_l = fx_p_l;
	}
	

}
