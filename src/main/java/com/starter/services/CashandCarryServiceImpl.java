package com.starter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.starter.pojo.CashAndCarry;

@Component
public class CashandCarryServiceImpl implements CashandCarryService{
	double FairValue;
	double brokerage=0.002;
	double stockamt;
	double Arbitrage;
	double spotPrice, futurePrice, dur, ROI;
	
	@Override
	public List<String> arbitrage() {
		// TODO Auto-generated method stub
			stockamt=3000.0;
			spotPrice=randomValueGenerator(3154,3250);
			futurePrice=randomValueGenerator(3100,3254);
			monthAndRate();
			if(futurePrice>spotPrice) {
				return CaandCarry(spotPrice,futurePrice,dur,ROI);
			}
			else {
				return RCandCarry(spotPrice,futurePrice,dur,ROI);
			}
		
	}
	@Override
	public List<String> Calculator(CashAndCarry c) {
		// TODO Auto-generated method stub
		stockamt=c.getLot_size();
		spotPrice= c.getSpotPrice();
		futurePrice=c.getFuturePrice();
		dur=c.getDuration(); 
		ROI=c.getRfr()/100;
		if(futurePrice>spotPrice) {
			return CaandCarry(spotPrice,futurePrice,dur,ROI);
		}
		else {
			return RCandCarry(spotPrice,futurePrice,dur,ROI);
		}
	}

	
	List<String> CaandCarry(double spotPrice, double futurePrice, double dur, double ROI)
	{
		List<String> list = new ArrayList<>();
		list.add("Spot Price:" +spotPrice);
		list.add("Futures Price: "+futurePrice);
		list.add("Months:"+dur);
		list.add("Interest: "+ROI*100+"%");
		list.add("Brokerage:"+brokerage*100+"%");
		list.add("Lot Size:" +stockamt);
			double duration= dur/12;
			double abc = 1 + ROI;      
			double power= Math.pow(abc, duration);   
			
			FairValue=spotPrice * power;      
			if(futurePrice>FairValue)
			{
				
				double Amtborrow=spotPrice*stockamt;      
				double CostofBorrowing = Amtborrow*(ROI*duration);   
				double FutureCost = futurePrice*stockamt;            
				double Gain = FutureCost-Amtborrow;                  
				Arbitrage=Gain-(CostofBorrowing+(brokerage*Amtborrow));    
				if(Arbitrage>0) {
					list.add("Arbitrage possible- Cash and Carry");
					list.add("Profit: "+Arbitrage);
					
				}
				else {

					list.add("Arbitrage not possible");
				}
				
			}
			else {

				list.add("Arbitrage not possible");
			}
			
		  
			return list;
		
	}
	
	List<String> RCandCarry(double spotPrice, double futurePrice, double dur, double ROI)
	{
		List<String> list = new ArrayList<>();
		list.add("Spot Price:" +spotPrice);
		list.add("Futures Price: "+futurePrice);
		list.add("Months:"+dur);
		list.add("Interest: "+ROI*100+"%");
		list.add("Brokerage:"+brokerage*100+"%");
		list.add("Lot Size:" +stockamt);
		double duration= dur/12;
		double Short = stockamt*spotPrice;       
		double ProfitLend=Short*ROI*duration;   
 
		FairValue=futurePrice / Math.pow(1+ROI, duration);    
		if ((spotPrice-FairValue)>0)
		{
			double Gain = stockamt * (spotPrice-futurePrice);
			Arbitrage= Gain + ProfitLend - (brokerage*Short);

			if(Arbitrage>0) {
				list.add("Arbitrage possible- Reverse Cash and Carry");
				list.add("Profit: "+Arbitrage);
								}
			else {
				list.add("Arbitrage not possible");
			}
			 
		}
		else {
			list.add("Arbitrage not possible");
		}
		return list;	
	}

	
	public double randomValueGenerator(double min, double max) {
		return  min+ (int)(Math.random() * ((max - min) + 1));
	}
@Override
public void monthAndRate() {
	// TODO Auto-generated method stub
	if(Math.random()<0.5) {
		dur=3;
		ROI=0.038;
	}
	else {
		dur=6;
		ROI=0.078;
	}
}

	
}
