package com.starter.pojo;

public class User_Calc_Input_fx {
	
	private Parameters_fx bid_ask;
	private Parameters_fx bid_ask_3;
	private Parameters_fx int_c1;
	private Parameters_fx int_c2;
	private double amount;
	private String c1;
	private String c2;
	private double transCost;
	private double monthDuration;
	public Parameters_fx getBid_ask() {
		return bid_ask;
	}
	public void setBid_ask(Parameters_fx bid_ask) {
		this.bid_ask = bid_ask;
	}
	public Parameters_fx getBid_ask_3() {
		return bid_ask_3;
	}
	public void setBid_ask_3(Parameters_fx bid_ask_3) {
		this.bid_ask_3 = bid_ask_3;
	}
	public Parameters_fx getInt_c1() {
		return int_c1;
	}
	public void setInt_c1(Parameters_fx int_c1) {
		this.int_c1 = int_c1;
	}
	public Parameters_fx getInt_c2() {
		return int_c2;
	}
	public void setInt_c2(Parameters_fx int_c2) {
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
	public double getTransCost() {
		return transCost;
	}
	public void setTransCost(double transCost) {
		this.transCost = transCost;
	}
	public double getMonthDuration() {
		return monthDuration;
	}
	public void setMonthDuration(double monthDuration) {
		this.monthDuration = monthDuration;
	}
	public User_Calc_Input_fx(Parameters_fx bid_ask, Parameters_fx bid_ask_3, Parameters_fx int_c1,
			Parameters_fx int_c2, double amount, String c1, String c2, double transCost, double monthDuration) {
		super();
		this.bid_ask = bid_ask;
		this.bid_ask_3 = bid_ask_3;
		this.int_c1 = int_c1;
		this.int_c2 = int_c2;
		this.amount = amount;
		this.c1 = c1;
		this.c2 = c2;
		this.transCost = transCost;
		this.monthDuration = monthDuration;
	}
	
	
	
	
	
		
	
	
	
}
