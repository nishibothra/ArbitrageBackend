package com.services;

import org.springframework.stereotype.Component;

import com.pojo.parameters;
import com.pojo.random_values;
import com.pojo.result_fx;
import com.pojo.user_calc_input;

@Component
public class ForexServiceImpl implements ForexService {

	@Override
	public random_values arbitrage(double amount, double cost) {
		// TODO Auto-generated method stub
//		Fix a value for cost
//		double cost;
		double bid_spot=0,ask_spot=0;
		double bid_3m,ask_3m;
		double int_c1_bid=0,int_c1_ask=0;
		double int_c2_bid=0,int_c2_ask=0;
		double amt_to_return=0,c1_to_c2=0,final_amt=0;
		
		double amt_to_return_r=0,c2_to_c1_r=0,c1_eqv_invest_r=0,final_amt_r=0;
		parameters p = null;
		
		random_values rmv ;
//		Getting spot bid and ask rate
		p=rv_generator(1.0,1.4);
		bid_spot = p.getBid();
		ask_spot=p.getAsk();
//		Getting bid and ask rate of 3M forward
		p=rv_generator(1.0,1.4);
		bid_3m = p.getBid();
		ask_3m=p.getAsk();
//		Getting interest rate in C1 for bid and ask
		p=rv_generator(1.82,5.75);
		int_c1_bid = p.getBid();
		int_c1_ask=p.getAsk();
//		Getting interest rate in C2 for bid and ask
		p=rv_generator(0.2,6.0);
		int_c2_bid = p.getBid();
		int_c2_ask=p.getAsk();
		
		
		
//		Calculating Forward Arbitrage
		amt_to_return = amount + (amount * (int_c1_ask/400));
		c1_to_c2 = amount*bid_spot;
		double c2_eqv_invest = c1_to_c2 + (c1_to_c2 * (int_c2_bid/400));
		final_amt = c2_eqv_invest / bid_3m;
//		Reverse Arbitrage
	    amt_to_return_r = amount + (amount * (int_c2_ask/400));
	    c2_to_c1_r = amount/bid_spot;
	    c1_eqv_invest_r = c2_to_c1_r + (c2_to_c1_r * (int_c1_bid/400));
	    final_amt_r = c1_eqv_invest_r * bid_3m;
	    
	    String result="";
	    double fx_p_l=0;
	    String choice="";
	    if(final_amt > (amt_to_return + cost )) {
	    	
	    	result = "Arbitrage possible with profit";
	    	choice = "Borrow in Eur and Invest In USD";
	    	fx_p_l = final_amt-(amt_to_return+cost);

	    }
	    else if((final_amt_r > (amt_to_return_r + cost ))) {
	    	
	    	result = "Revese Arbitrage possible with profit";
	    	choice = "Borrow in USD and Invest In EUR";
	    	fx_p_l = final_amt_r-(amt_to_return_r+cost);

	    }
	    else {
	    	result = "No arbitrage possible loss =";
	    	choice="";
	    	fx_p_l = (amt_to_return+cost) -final_amt;
//	    	System.out.println("No arbitrage possible loss = " + (amt_to_return-final_amt));
	    }
	    
	    return new random_values(new result_fx(result, fx_p_l, choice), new parameters(bid_spot,ask_spot),new parameters(bid_3m,ask_3m),new parameters(int_c1_bid,int_c1_ask), new parameters(int_c2_bid,int_c2_ask));
	}
	
	
	

	@Override
	public result_fx fx_calculator(user_calc_input ucl) {
		// TODO Auto-generated method stub
		
//		Forward Arbitrage
		double amt_to_return=0,c1_to_c2=0,final_amt=0, c2_eqv_invest=0;
//		added cost 
		double cost=0.005*ucl.getAmount();
		System.out.println(cost);
		double amt_to_return_r=0,c2_to_c1_r=0,c1_eqv_invest_r=0,final_amt_r=0;
		

		amt_to_return = ucl.getAmount() + (ucl.getAmount() * (ucl.getInt_c1().getAsk()/400));
		c1_to_c2 = ucl.getAmount()*ucl.getBid_ask().getBid();
		 c2_eqv_invest = c1_to_c2 + (c1_to_c2 * (ucl.getInt_c2().getBid()/400));
		final_amt = c2_eqv_invest / ucl.getBid_ask_3().getBid();
		
//		Reverse Arbitrage
		
		amt_to_return_r = ucl.getAmount() + (ucl.getAmount() * (ucl.getInt_c2().getAsk()/400));
	    c2_to_c1_r = ucl.getAmount()/ucl.getBid_ask().getBid();
	    c1_eqv_invest_r = c2_to_c1_r + (c2_to_c1_r * (ucl.getInt_c1().getBid()/400));
	    final_amt_r = c1_eqv_invest_r * ucl.getBid_ask_3().getBid();
	    
	    String result="";
	    double fx_p_l=0;
	    String choice="";
	    if(final_amt > (amt_to_return + cost)) {
	    	
	    	result = "Arbitrage possible with profit";
//	    	choice = "Borrow in Eur and Invest In USD";
	    	choice = "Borrow in GBP and Invest In CAD";
	    	fx_p_l = final_amt-(amt_to_return+cost);
	    	return new result_fx(result,fx_p_l,choice);

	    }
	    else if((final_amt_r > (amt_to_return_r + cost))) {
	    	
	    	result = "Reverse Arbitrage possible with profit";
	    	choice = "Borrow in CAD and Invest In GBP";
	    	fx_p_l = final_amt_r-(amt_to_return_r+cost);
	    	System.out.println(final_amt_r);
	    	System.out.println(amt_to_return_r + cost);
	    	return new result_fx(result,fx_p_l,choice);

	    }
	    else {
	    	result = "No arbitrage possible loss =";
	    	choice="";
	    	fx_p_l = (amt_to_return+cost) -final_amt;
	    	
	    	return new result_fx(result,fx_p_l,choice);

	    }
	    
	    

}




	@Override
	public parameters rv_generator(double min, double max) {
		double value=0,ask=0,bid=Integer.MAX_VALUE;
		value = Math.random();
		ask = min+(value*(max-min));
		while(bid>ask) {
			value=Math.random();
			bid=min+(value*(max-min));
		}
			  
		return new parameters(bid,ask);
	}

}
