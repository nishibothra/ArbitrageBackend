package com.starter.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.starter.pojo.CashAndCarry;
import com.starter.pojo.ResultCAC_db;
import com.starter.repo.CAC_Repo;

@Component
public class CashandCarryServiceImpl implements CashandCarryService{
	@Autowired
	CAC_Repo cacrepo;
	private static double trans_Id=0;
	double brokerage;
	double stockamt;
	double Arbitrage;
	double bid_spotPrice,ask_spotPrice, bid_futurePrice,ask_futurePrice, dur, bid_ROI,ask_ROI;
	String arbitragetype="";
	CashAndCarry cc;
	
	ResultCAC_db db1;
	@Autowired
	JdbcTemplate template;

	@Override
    public CashAndCarry arbitrage() {
		stockamt=3000.0;
		brokerage=0.002;
		bid_spotPrice=randomValueGenerator(3154,3172);
		ask_spotPrice=randomValueGenerator(bid_spotPrice+1,3175);
		bid_futurePrice=randomValueGenerator(3180,3240);
		ask_futurePrice=randomValueGenerator(bid_futurePrice+1,3250);
		
		monthAndRate();
		
		CashAndCarry cc = new CashAndCarry(bid_spotPrice,ask_spotPrice,bid_futurePrice,ask_futurePrice,dur,bid_ROI,ask_ROI,stockamt,brokerage);
		
		double duration= dur/12;
		double Amtborrow=ask_spotPrice*stockamt;      
		double CostofBorrowing = Amtborrow*(ask_ROI*duration)/100.0;   
		double FutureCost = bid_futurePrice*stockamt;            
		double Gain = FutureCost-Amtborrow;                  
		Arbitrage=  Math.round( (Gain-(CostofBorrowing+(brokerage*Amtborrow)))* 100.0) / 100.0;     
		if(Arbitrage>0) {
			arbitragetype="Arbitrage is possible-Cash and Carry";
			cc.setArbitrage(arbitragetype);
			cc.setProfit(Arbitrage);
			ResultCAC_db rsb=new ResultCAC_db( bid_spotPrice,  ask_spotPrice, bid_futurePrice,  ask_futurePrice,
					 duration,  bid_ROI,  ask_ROI,  stockamt,  brokerage,arbitragetype,  Arbitrage,  trans_Id);
			rsb.setTransId(++trans_Id);
			cacrepo.save(rsb);
			}

		else {
			double Short = stockamt*bid_spotPrice;       
			double ProfitLend=(Short*bid_ROI*duration)/100.0;   
			Gain = stockamt * (bid_spotPrice-ask_futurePrice);
			Arbitrage= Math.round((Gain + ProfitLend - (brokerage*Short))*100.0)/100.0;

			if(Arbitrage>0) {
			
				arbitragetype="Arbitrage is possible-Reverse Cash and Carry";
				cc.setArbitrage(arbitragetype);
				cc.setProfit(Arbitrage);
				ResultCAC_db rsb=new ResultCAC_db( bid_spotPrice,  ask_spotPrice, bid_futurePrice,  ask_futurePrice,
						 duration,  bid_ROI,  ask_ROI,  stockamt,  brokerage,arbitragetype,  Arbitrage,  trans_Id);
				rsb.setTransId(++trans_Id);
				cacrepo.save(rsb);
				
			
				}
			else {
				cc.setArbitrage("Arbitrage not possible");
			}			 
		}
		return cc;
		
	}
	
	@Override
	public CashAndCarry Calculator(CashAndCarry cc) {
	
		bid_spotPrice=cc.getBid_spotPrice();
		ask_spotPrice=cc.getAsk_spotPrice(); 
		bid_futurePrice=cc.getBid_futurePrice();
		ask_futurePrice=cc.getAsk_futurePrice(); 
		bid_ROI=cc.getBid_rfr()/100;
		ask_ROI=cc.getAsk_rfr()/100.0;
		dur=cc.getDuration();
		
		stockamt=cc.getLot_size();
		brokerage=cc.getBrokerage()/100;

		double duration= dur/12;
		double Amtborrow=ask_spotPrice*stockamt;      
		double CostofBorrowing = Amtborrow*(ask_ROI*duration);   
		double FutureCost = bid_futurePrice*stockamt;            
		double Gain = FutureCost-Amtborrow; 
		int flag=0;
		Arbitrage=  Math.round( (Gain-(CostofBorrowing+(brokerage*Amtborrow)))* 100.0) / 100.0;
		if(Arbitrage>0) {
			cc.setArbitrage("Arbitrage possible- Cash and Carry");
			cc.setProfit(Arbitrage);	
	
			
			}
		
		else {
			double Short = stockamt*bid_spotPrice;       
			double ProfitLend=Short*bid_ROI*duration;   
	  

				Gain = stockamt * (bid_spotPrice-ask_futurePrice);
				Arbitrage= Math.round((Gain + ProfitLend - (brokerage*Short))*100.0)/100.0;
				if(Arbitrage>0) {
					cc.setArbitrage("Arbitrage possible- Reverse Cash and Carry");
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
	
	return  min+ (int)(Math.random() * ((max - min) + 1));
}
	
@Override
public void monthAndRate() {

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
