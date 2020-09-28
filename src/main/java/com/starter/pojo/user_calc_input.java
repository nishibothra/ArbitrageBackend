package com.starter.pojo;

public class user_calc_input {
	
	private parameters bid_ask;
	private parameters bid_ask_3;
	private parameters int_c1;
	private parameters int_c2;
	private double amount;
	private String c1;
	private String c2;
	public user_calc_input(parameters bid_ask, parameters bid_ask_3, parameters int_c1, parameters int_c2,
			double amount, String c1, String c2) {
		super();
		this.bid_ask = bid_ask;
		this.bid_ask_3 = bid_ask_3;
		this.int_c1 = int_c1;
		this.int_c2 = int_c2;
		this.amount = amount;
		this.c1 = c1;
		this.c2 = c2;
	}
	public parameters getBid_ask() {
		return bid_ask;
	}
	public void setBid_ask(parameters bid_ask) {
		this.bid_ask = bid_ask;
	}
	public parameters getBid_ask_3() {
		return bid_ask_3;
	}
	public void setBid_ask_3(parameters bid_ask_3) {
		this.bid_ask_3 = bid_ask_3;
	}
	public parameters getInt_c1() {
		return int_c1;
	}
	public void setInt_c1(parameters int_c1) {
		this.int_c1 = int_c1;
	}
	public parameters getInt_c2() {
		return int_c2;
	}
	public void setInt_c2(parameters int_c2) {
		this.int_c2 = int_c2;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getC1() {
		return c1;
	}
	public void setC1(String c1) {
		this.c1 = c1;
	}
	public String getC2() {
		return c2;
	}
	public void setC2(String c2) {
		this.c2 = c2;
	}
	
	
		
	
	
	
}
