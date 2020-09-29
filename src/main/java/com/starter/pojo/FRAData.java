package com.starter.pojo;

public class FRAData {
	
	private double principleAmount;

	private double transactionCost;
	private double sixMonthsSpotAsk;
	private double sixMonthsSpotBid;
	private double twelveMonthSpotAsk;
	private double twelveMonthSpotBid;
	private double sixByTwelveFRAsk;
	private double sixBytwelveFRBid;
	
	private double gainLossLongBorrow;
	private double gainLossLongLend;
	
	private boolean isArbitrageLongBorrow;
	private boolean isArbitrageLongLend;
	
	public boolean getIsArbitrageLongBorrow() {
		return isArbitrageLongBorrow;
	}





	public void setIsArbitrageLongBorrow(boolean isArbitrageLongBorrow) {
		this.isArbitrageLongBorrow = isArbitrageLongBorrow;
	}





	public boolean getIsArbitrageLongLend() {
		return isArbitrageLongLend;
	}





	public void setIsArbitrageLongLend(boolean isArbitrageLongLend) {
		this.isArbitrageLongLend = isArbitrageLongLend;
	}





	public FRAData() {
		
	}
	
	
	

	
	





	@Override
	public String toString() {
		return "Data [principleAmount=" + principleAmount + ", transactionCost=" + transactionCost
				+ ", sixMonthsSpotAsk=" + sixMonthsSpotAsk + ", sixMonthsSpotBid=" + sixMonthsSpotBid
				+ ", twelveMonthSpotAsk=" + twelveMonthSpotAsk + ", twelveMonthSpotBid=" + twelveMonthSpotBid
				+ ", sixByTwelveFRAsk=" + sixByTwelveFRAsk + ", sixBytwelveFRBid=" + sixBytwelveFRBid
				+ ", gainLossLongBorrow=" + gainLossLongBorrow + ", gainLossLongLend=" + gainLossLongLend
				+ ", isArbitrageLongBorrow=" + isArbitrageLongBorrow + ", isArbitrageLongLend=" + isArbitrageLongLend
				+ "]";
	}





	public double getGainLossLongBorrow() {
		return gainLossLongBorrow;
	}





	public void setGainLossLongBorrow(double gainLossCaseOne) {
		this.gainLossLongBorrow = gainLossCaseOne;
	}





	public double getGainLossLongLend() {
		return gainLossLongLend;
	}





	public void setGainLossLongLend(double gainLossCaseTwo) {
		this.gainLossLongLend = gainLossCaseTwo;
	}




	public FRAData(double principleAmount, double transactionCost, double sixMonthsSpotAsk, double sixMonthsSpotBid,
			double twelveMonthSpotAsk, double twelveMonthSpotBid, double sixByTwelveFRAsk, double sixBytwelveFRBid,
			double gainLossLongBorrow, double gainLossLongLend, boolean isArbitrageLongBorrow,
			boolean isArbitrageLongLend) {
		super();
		this.principleAmount = principleAmount;
		this.transactionCost = transactionCost;
		this.sixMonthsSpotAsk = sixMonthsSpotAsk;
		this.sixMonthsSpotBid = sixMonthsSpotBid;
		this.twelveMonthSpotAsk = twelveMonthSpotAsk;
		this.twelveMonthSpotBid = twelveMonthSpotBid;
		this.sixByTwelveFRAsk = sixByTwelveFRAsk;
		this.sixBytwelveFRBid = sixBytwelveFRBid;
		this.gainLossLongBorrow = gainLossLongBorrow;
		this.gainLossLongLend = gainLossLongLend;
		this.isArbitrageLongBorrow = isArbitrageLongBorrow;
		this.isArbitrageLongLend = isArbitrageLongLend;
	}





	public double getPrincipleAmount() {
		return principleAmount;
	}

	public void setPrincipleAmount(double principleAmount) {
		this.principleAmount = principleAmount;
	}

	public double getTransactionCost() {
		return transactionCost;
	}

	public void setTransactionCost(double transactionCost) {
		this.transactionCost = transactionCost;
	}

	public double getSixMonthsSpotAsk() {
		return sixMonthsSpotAsk;
	}

	public void setSixMonthsSpotAsk(double sixMonthsSpotAsk) {
		this.sixMonthsSpotAsk = sixMonthsSpotAsk;
	}

	public double getSixMonthsSpotBid() {
		return sixMonthsSpotBid;
	}

	public void setSixMonthsSpotBid(double sixMonthsSpotBid) {
		this.sixMonthsSpotBid = sixMonthsSpotBid;
	}

	public double getTwelveMonthSpotAsk() {
		return twelveMonthSpotAsk;
	}

	public void setTwelveMonthSpotAsk(double twelveMonthSpotAsk) {
		this.twelveMonthSpotAsk = twelveMonthSpotAsk;
	}

	public double getTwelveMonthSpotBid() {
		return twelveMonthSpotBid;
	}

	public void setTwelveMonthSpotBid(double twelveMonthSpotBid) {
		this.twelveMonthSpotBid = twelveMonthSpotBid;
	}

	public double getSixByTwelveFRAsk() {
		return sixByTwelveFRAsk;
	}

	public void setSixByTwelveFRAsk(double sixByTwelveFRAsk) {
		this.sixByTwelveFRAsk = sixByTwelveFRAsk;
	}

	public double getSixBytwelveFRBid() {
		return sixBytwelveFRBid;
	}

	public void setSixBytwelveFRBid(double sixBytwelveFRBid) {
		this.sixBytwelveFRBid = sixBytwelveFRBid;
	}
	
	
	
}
