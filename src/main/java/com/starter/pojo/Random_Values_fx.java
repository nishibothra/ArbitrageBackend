package com.starter.pojo;

public class Random_Values_fx {
	private Result_fx res;
	private Parameters bid_ask;
	private Parameters bid_ask_3;
	private Parameters int_c1;
	private Parameters int_c2;
	public Random_Values_fx(Result_fx res, Parameters bid_ask, Parameters bid_ask_3, Parameters int_c1,
			Parameters int_c2) {
		super();
		this.res = res;
		this.bid_ask = bid_ask;
		this.bid_ask_3 = bid_ask_3;
		this.int_c1 = int_c1;
		this.int_c2 = int_c2;
	}
	public Result_fx getRes() {
		return res;
	}
	public void setRes(Result_fx res) {
		this.res = res;
	}
	public Parameters getBid_ask() {
		return bid_ask;
	}
	public void setBid_ask(Parameters bid_ask) {
		this.bid_ask = bid_ask;
	}
	public Parameters getBid_ask_3() {
		return bid_ask_3;
	}
	public void setBid_ask_3(Parameters bid_ask_3) {
		this.bid_ask_3 = bid_ask_3;
	}
	public Parameters getInt_c1() {
		return int_c1;
	}
	public void setInt_c1(Parameters int_c1) {
		this.int_c1 = int_c1;
	}
	public Parameters getInt_c2() {
		return int_c2;
	}
	public void setInt_c2(Parameters int_c2) {
		this.int_c2 = int_c2;
	}
	
}
