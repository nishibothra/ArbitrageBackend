package com.starter.services;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starter.pojo.FRAData;
import com.starter.pojo.FRADataDb;
import com.starter.repo.FRARepo;

@Component
public class FRAServiceImpl implements FRAService {

	@Autowired
	FRARepo fraRepo;
	private static int transid=0;
	@Override
	public FRAData calculateGainLossLongBorrow(FRAData data) {
		// TODO Auto-generated method stub
		double retAfterTwel = data.getPrincipleAmount() * (1 + (data.getTwelveMonthSpotAsk()) / 100);
		double getAfterSix = data.getPrincipleAmount() * (1 + (data.getSixMonthsSpotBid()) / 200);
		double getAfterTwel = getAfterSix * (1 + (data.getSixBytwelveFRBid()) / 200);

		data.setGainLossLongBorrow(getAfterTwel - retAfterTwel - data.getTransactionCost());
		if(data.getGainLossLongBorrow()>0.0001) data.setIsArbitrageLongBorrow(true);
		if(data.getIsArbitrageLongBorrow()) {
			FRADataDb fra = new FRADataDb();
			Date date =new Date();
//			Timestamp tm = new Timestamp(date.getTime());
			fra.setTransId(++transid);
			
			fra.setPrincipal(data.getPrincipleAmount());
			fra.setSpot_6m(data.getSixMonthsSpotBid());
			fra.setSpot_12m(data.getTwelveMonthSpotAsk());
			
			fra.setForward_6_12m(data.getSixBytwelveFRBid());
			fra.setSubtype("Long Borrow");
			fra.setProfit(data.getGainLossLongBorrow());
			System.out.println("history : "+fra.toString());
			fraRepo.save(fra);
		}
		

		return data;
	}

	@Override
	public FRAData calculateGainLossLongLend(FRAData data) {
		// TODO Auto-generated method stub
		double getAfterTwel = data.getPrincipleAmount() * (1 + (data.getTwelveMonthSpotBid()) / 100);
		double retAfterSix = data.getPrincipleAmount() * (1 + (data.getSixMonthsSpotAsk()) / 200);
		double retAfterTwel = retAfterSix * (1 + (data.getSixByTwelveFRAsk()) / 200);
		data.setGainLossLongLend(getAfterTwel - retAfterTwel - data.getTransactionCost());
		
		if(data.getGainLossLongLend()>0.0001) data.setIsArbitrageLongLend(true);

		if(data.getIsArbitrageLongLend()) {
			FRADataDb fra = new FRADataDb();
			Date date =new Date();
			Timestamp tm = new Timestamp(date.getTime());
			fra.setTransId(++transid);
			
			fra .setPrincipal(data.getPrincipleAmount());
			fra.setSpot_6m(data.getSixMonthsSpotAsk());
			fra.setSpot_12m(data.getTwelveMonthSpotBid());
			
			fra.setForward_6_12m(data.getSixByTwelveFRAsk());
			fra.setSubtype("Long Lend");
			fra.setProfit(data.getGainLossLongLend());
			fraRepo.save(fra);
		}
		
		return data;
	}
	
	@Override
	public FRAData calculateUserInLongLend(FRAData data) {
		double getAfterTwel = data.getPrincipleAmount() * (1 + (data.getTwelveMonthSpotBid()) / 100);
		double retAfterSix = data.getPrincipleAmount() * (1 + (data.getSixMonthsSpotAsk()) / 200);
		double sixByTwelveFRAsk = 200 * (data.getGainLossLongLend()  + getAfterTwel  - data.getTransactionCost())/retAfterSix -200;
		
		data.setSixByTwelveFRAsk(sixByTwelveFRAsk);
		//double retAfterTwel = retAfterSix * (1 + sixByTwelveFRAsk / 200);
		//data.setGainLossLongLend(getAfterTwel - retAfterTwel - data.getTransactionCost());
		if(data.getGainLossLongLend()>0.0001) data.setIsArbitrageLongLend(true);
		
		return data;
	}

	@Override
	public FRAData calculateUserInLongBorrow(FRAData data) {
		double retAfterTwel = data.getPrincipleAmount() * (1 + (data.getTwelveMonthSpotAsk()) / 100);
		double getAfterSix = data.getPrincipleAmount() * (1 + (data.getSixMonthsSpotBid()) / 200);
		double sixByTwelveFRBid = 200 * (data.getTransactionCost() + data.getGainLossLongBorrow() + retAfterTwel)/getAfterSix -200;
		
		data.setSixBytwelveFRBid(sixByTwelveFRBid);
		//double getAfterTwel = getAfterSix * (1 + sixByTwelveFRBid / 200);

		//data.setGainLossLongBorrow(getAfterTwel - retAfterTwel - data.getTransactionCost());
		if(data.getGainLossLongBorrow()>0.0001) data.setIsArbitrageLongBorrow(true);
		
	
		return data;
	}

	
	}



