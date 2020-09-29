package com.starter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.starter.pojo.CashAndCarry;

@Component
public class CashandCarryServiceImpl implements CashandCarryService{
	double brokerage=0.002;
	double stockamt;
	double Arbitrage;
	double bid_spotPrice,ask_spotPrice, bid_futurePrice,ask_futurePrice, dur, bid_ROI,ask_ROI;
	CashAndCarry cc;
	@Override
	public CashAndCarry arbitrage() {
		// TODO Auto-generated method stub
		stockamt=3000.0;
		bid_spotPrice=randomValueGenerator(3154,3172);
		ask_spotPrice=randomValueGenerator(bid_spotPrice,3175);
		bid_futurePrice=randomValueGenerator(3145,3180);
		ask_futurePrice=randomValueGenerator(bid_futurePrice,3185);
		monthAndRate();
		CashAndCarry cc = new CashAndCarry(bid_spotPrice,ask_spotPrice,bid_futurePrice,ask_futurePrice,dur,bid_ROI,ask_ROI);
		cc.setLot_size(stockamt);
		cc.setBrokerage(0.2);
		//c and c
		double duration= dur/12;
		double Amtborrow=ask_spotPrice*stockamt;      
		double CostofBorrowing = Amtborrow*(ask_ROI*duration)/100.0;   
		double FutureCost = bid_futurePrice*stockamt;            
		double Gain = FutureCost-Amtborrow;                  
		Arbitrage=  Math.round( (Gain-(CostofBorrowing+(brokerage*Amtborrow)))* 1000.0) / 1000.0;     
		if(Arbitrage>0) {
			
			cc.setArbitrage("Arbitrage possible- Cash and Carry");
			cc.setProfit(Arbitrage);					
			}
		//reverse c and c
		else {
			double Short = stockamt*bid_spotPrice;       
			double ProfitLend=(Short*bid_ROI*duration)/100.0;   
			Gain = stockamt * (bid_spotPrice-ask_futurePrice);
			Arbitrage= Math.round((Gain + ProfitLend - (brokerage*Short))*1000.0)/1000.0;

			if(Arbitrage>0) {
				cc.setArbitrage("Arbitrage possible- Reverse Cash and Carry");
				cc.setProfit(Arbitrage);
				}
			else {
				cc.setArbitrage("Arbitrage not possible");
			}			 
		}
		return cc;
		
	}
	
	@Override
	public CashAndCarry Calculator(CashAndCarry cc) {
		// TODO Auto-generated method stub
		bid_spotPrice=cc.getBid_spotPrice();
		ask_spotPrice=cc.getAsk_spotPrice(); 
		bid_futurePrice=cc.getBid_futurePrice();
		ask_futurePrice=cc.getAsk_futurePrice(); 
		bid_ROI=cc.getBid_rfr()/100;
		ask_ROI=cc.getAsk_rfr()/100.0;
		dur=cc.getDuration();
		
		stockamt=cc.getLot_size();
		brokerage=cc.getBrokerage()/100;
		//c and c
		double duration= dur/12;
		double Amtborrow=ask_spotPrice*stockamt;      
		double CostofBorrowing = Amtborrow*(ask_ROI*duration);   
		double FutureCost = bid_futurePrice*stockamt;            
		double Gain = FutureCost-Amtborrow;        
		Arbitrage=  Math.round( (Gain-(CostofBorrowing+(brokerage*Amtborrow)))* 1000.0) / 1000.0;
		if(Arbitrage>0) {
			cc.setArbitrage("Arbitrage possible- Cash and Carry");
			cc.setProfit(Arbitrage);					
			}
		//reverse c and c
		else {
			double Short = stockamt*bid_spotPrice;       
			double ProfitLend=Short*bid_ROI*duration;   
	  

				Gain = stockamt * (bid_spotPrice-ask_futurePrice);
				Arbitrage= Math.round((Gain + ProfitLend - (brokerage*Short))*1000.0)/1000.0;
				if(Arbitrage>0) {
					cc.setArbitrage("Arbitrage possible- Rverse Cash and Carry");
					cc.setProfit(Arbitrage);
									}
				else {
					cc.setArbitrage("Arbitrage not  possible");
				}			 
		}
		return cc;
	}
	
@Override
public double randomValueGenerator(double min, double max) {
	// TODO Auto-generated method stub
	return  min+ (int)(Math.random() * ((max - min) + 1));
}
	
@Override
public void monthAndRate() {
	// TODO Auto-generated method stub
	if(Math.random()<0.5) {
		dur=3;
		bid_ROI=3.8;
		ask_ROI=4.0;
	}
	else {
		dur=6;
		bid_ROI=7.8;
		ask_ROI=8.0;
	}
}
	
}
