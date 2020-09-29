package com.starter.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Random_Values_fx {
	
	private int TransId;
	
	private Result_fx res;
	private Parameters_fx bid_ask;
	private Parameters_fx bid_ask_3;
	private Parameters_fx int_c1;
	private Parameters_fx int_c2;
	public Random_Values_fx(Result_fx res, Parameters_fx bid_ask, Parameters_fx bid_ask_3, Parameters_fx int_c1,
			Parameters_fx int_c2) {
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
	
}
