package com.starter.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="result_fra")
public class FRADataDb {
	
	@Id
	private int transId;

	double principal;
	double spot_6m;
	double spot_12m;
	double forward_6_12m;
	String subtype;
	double profit;
	
	
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getSpot_6m() {
		return spot_6m;
	}
	public void setSpot_6m(double spot_6m) {
		this.spot_6m = spot_6m;
	}
	public double getSpot_12m() {
		return spot_12m;
	}
	public void setSpot_12m(double spot_12m) {
		this.spot_12m = spot_12m;
	}
	public double getForward_6_12m() {
		return forward_6_12m;
	}
	public void setForward_6_12m(double forward_6_12m) {
		this.forward_6_12m = forward_6_12m;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	@Override
	public String toString() {
		return "FRADataDb [transId=" + transId + ", principal=" + principal + ", spot_6m=" + spot_6m + ", spot_12m="
				+ spot_12m + ", forward_6_12m=" + forward_6_12m + ", subtype=" + subtype + ", profit=" + profit + "]";
	}
	public FRADataDb(int transId, double principal, double spot_6m, double spot_12m, double forward_6_12m,
			String subtype, double profit) {
		super();
		this.transId = transId;
		this.principal = principal;
		this.spot_6m = spot_6m;
		this.spot_12m = spot_12m;
		this.forward_6_12m = forward_6_12m;
		this.subtype = subtype;
		this.profit = profit;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	public FRADataDb() {
		
	}
	
	
}
