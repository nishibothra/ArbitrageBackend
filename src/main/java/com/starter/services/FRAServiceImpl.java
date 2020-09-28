package com.starter.services;

import org.springframework.stereotype.Component;

import com.starter.pojo.Data;

@Component
public class FRAServiceImpl implements FRAService {

	@Override
	public Data calculateGainLossLongBorrow(Data data) {
		// TODO Auto-generated method stub
		double retAfterTwel = data.getPrincipleAmount() * (1 + (data.getTwelveMonthSpotAsk()) / 100);
		double getAfterSix = data.getPrincipleAmount() * (1 + (data.getSixMonthsSpotBid()) / 200);
		double getAfterTwel = getAfterSix * (1 + (data.getSixBytwelveFRBid()) / 200);

		data.setGainLossLongBorrow(getAfterTwel - retAfterTwel - data.getTransactionCost());
		if(data.getGainLossLongBorrow()>0.1) data.setIsArbitrageLongBorrow(true);

		return data;
	}

	@Override
	public Data calculateGainLossLongLend(Data data) {
		// TODO Auto-generated method stub
		double getAfterTwel = data.getPrincipleAmount() * (1 + (data.getTwelveMonthSpotBid()) / 100);
		double retAfterSix = data.getPrincipleAmount() * (1 + (data.getSixMonthsSpotAsk()) / 200);
		double retAfterTwel = retAfterSix * (1 + (data.getSixByTwelveFRAsk()) / 200);
		data.setGainLossLongLend(getAfterTwel - retAfterTwel - data.getTransactionCost());
		
		if(data.getGainLossLongLend()>0.1) data.setIsArbitrageLongLend(true);
		
		return data;
	}
	
	@Override
	public Data calculateUserInLongLend(Data data) {
		double getAfterTwel = data.getPrincipleAmount() * (1 + (data.getTwelveMonthSpotBid()) / 100);
		double retAfterSix = data.getPrincipleAmount() * (1 + (data.getSixMonthsSpotAsk()) / 200);
		double sixByTwelveFRAsk = 200 * (data.getGainLossLongLend()  + getAfterTwel  - data.getTransactionCost())/retAfterSix -200;
		
		data.setSixByTwelveFRAsk(sixByTwelveFRAsk);
		//double retAfterTwel = retAfterSix * (1 + sixByTwelveFRAsk / 200);
		//data.setGainLossLongLend(getAfterTwel - retAfterTwel - data.getTransactionCost());
		if(data.getGainLossLongLend()>0.1) data.setIsArbitrageLongLend(true);
		
		return data;
	}

	@Override
	public Data calculateUserInLongBorrow(Data data) {
		double retAfterTwel = data.getPrincipleAmount() * (1 + (data.getTwelveMonthSpotAsk()) / 100);
		double getAfterSix = data.getPrincipleAmount() * (1 + (data.getSixMonthsSpotBid()) / 200);
		double sixByTwelveFRBid = 200 * (data.getTransactionCost() + data.getGainLossLongBorrow() + retAfterTwel)/getAfterSix -200;
		
		data.setSixBytwelveFRBid(sixByTwelveFRBid);
		//double getAfterTwel = getAfterSix * (1 + sixByTwelveFRBid / 200);

		//data.setGainLossLongBorrow(getAfterTwel - retAfterTwel - data.getTransactionCost());
		if(data.getGainLossLongBorrow()>0.1) data.setIsArbitrageLongBorrow(true);
		
	
		return data;
	}

	
	}



