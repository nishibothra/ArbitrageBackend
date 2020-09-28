package com.pojo;

public class CashAndCarry {
	private double spotPrice, futurePrice;
	
	private double lot_size; 
	
	private double duration;
	private double rfr ;
	
	public CashAndCarry(double sp, double fp, double d,double rate) {
		  spotPrice= sp;
		  futurePrice = fp;
		  duration=d;
		  rfr=rate;
	  }
	
	public CashAndCarry() {
		// TODO Auto-generated constructor stub
	}

	public void setSpotPrice(double spotPrice) {
		this.spotPrice = spotPrice;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public void setRfr(double rfr) {
		this.rfr = rfr;
	}
	
	  public double getSpotPrice() {
		return spotPrice;
	}

	public double getDuration() {
		return duration;
	}

	public double getRfr() {
		return rfr;
	}
	public double getFuturePrice() {
		return futurePrice;
	}

	public void setFuturePrice(double futurePrice) {
		this.futurePrice = futurePrice;
	}
	public double getLot_size() {
		return lot_size;
	}

	public void setLot_size(double lot_size) {
		this.lot_size = lot_size;
	}


}
