package com.starter.services;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

import com.starter.pojo.Parameters_fx;
import com.starter.pojo.Random_Values_fx;
import com.starter.pojo.Result_fx;
import com.starter.pojo.User_Calc_Input_fx;

@Component
public class ForexServiceImpl implements ForexService {

	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	@Override
	public Random_Values_fx arbitrage(double amount, double cost) {
		// TODO Auto-generated method stub

//		double cost;
		double bid_spot=0,ask_spot=0;
		double bid_3m,ask_3m;
		double int_c1_bid=0,int_c1_ask=0;
		double int_c2_bid=0,int_c2_ask=0;
		double amt_to_return=0,c1_to_c2=0,final_amt=0;
		
		double amt_to_return_r=0,c2_to_c1_r=0,c1_eqv_invest_r=0,final_amt_r=0;
		Parameters_fx p = null;
		
		Random_Values_fx rmv ;
//		Getting spot bid and ask rate 
		p=rv_generator(1.0,1.4);
		bid_spot =Double.parseDouble(df2.format(p.getBid())) ;
		ask_spot=Double.parseDouble(df2.format(p.getAsk())) ;  
//		Getting bid and ask rate of 3M forward rate
		p=rv_generator(1.0,1.4);
		bid_3m =Double.parseDouble(df2.format(p.getBid())) ;
		ask_3m=Double.parseDouble(df2.format(p.getAsk())) ; 
//		Getting interest rate in Country 1 for bid and ask
		p=rv_generator(1.82,5.75);
		int_c1_bid = Double.parseDouble(df2.format(p.getBid())) ;
		int_c1_ask= Double.parseDouble(df2.format(p.getAsk())) ; 
//		Getting interest rate in Country 2 for bid and ask
		p=rv_generator(0.2,6.0);
		int_c2_bid =  Double.parseDouble(df2.format(p.getBid())) ;
		int_c2_ask= Double.parseDouble(df2.format(p.getAsk())) ; 
		
		
		
//		Forward Arbitrage Calculations
		amt_to_return = amount + (amount * (int_c1_ask/400));
		c1_to_c2 = amount*bid_spot;
		double c2_eqv_invest = c1_to_c2 + (c1_to_c2 * (int_c2_bid/400));
		final_amt = c2_eqv_invest / ask_3m;
		
//		Reverse Arbitrage Calculations
	    amt_to_return_r = amount + (amount * (int_c2_ask/400));
	    c2_to_c1_r = amount/ask_spot;
	    c1_eqv_invest_r = c2_to_c1_r + (c2_to_c1_r * (int_c1_bid/400));
	    final_amt_r = c1_eqv_invest_r * bid_3m;
	   
//	    Variable declaration for result json
	    String result="";
	    double fx_p_l=0;
	    String choice="";
	    if(final_amt > (amt_to_return + cost )) {
	    	
	    	result = "Arbitrage possible with profit";
	    	choice = "Borrow in EUR and Invest In USD";
	    	fx_p_l =  Double.parseDouble(df2.format(final_amt-(amt_to_return+cost)));

	    }
	    else if((final_amt_r > (amt_to_return_r + cost ))) {
	    	
	    	result = "Revese Arbitrage possible with profit";
	    	choice = "Borrow in USD and Invest In EUR";
	    	fx_p_l = Double.parseDouble(df2.format(final_amt_r-(amt_to_return_r+cost)));

	    }
	    else {
	    	result = "No arbitrage possible loss";
	    	choice=  "";
	    	fx_p_l =  -Double.parseDouble(df2.format((amt_to_return+cost) -final_amt));;
	    }
	    
	    return new Random_Values_fx(new Result_fx(result, fx_p_l, choice), new Parameters_fx(bid_spot,ask_spot),new Parameters_fx(bid_3m,ask_3m),new Parameters_fx(int_c1_bid,int_c1_ask), new Parameters_fx(int_c2_bid,int_c2_ask));
	}
	
	
	

	@Override
	public Result_fx fx_calculator(User_Calc_Input_fx ucl) {
		// TODO Auto-generated method stub
		
//		Forward Arbitrage Algorithm Variables
		double amt_to_return=0,c1_to_c2=0,final_amt=0, c2_eqv_invest=0;
//		double cost=0.005*ucl.getAmount();
		double cost =0;
		double amt_to_return_r=0,c2_to_c1_r=0,c1_eqv_invest_r=0,final_amt_r=0;
		
// 	    Forward Arbitrage Calculations
		amt_to_return = ucl.getAmount() + (ucl.getAmount() * (ucl.getInt_c1().getAsk()/400));
		c1_to_c2 = ucl.getAmount()*ucl.getBid_ask().getBid();
		 c2_eqv_invest = c1_to_c2 + (c1_to_c2 * (ucl.getInt_c2().getBid()/400));
		final_amt = c2_eqv_invest / ucl.getBid_ask_3().getAsk();
		
//		Sys out statements to validate the answers
//		System.out.println(amt_to_return);
//		System.out.println(c1_to_c2);
//		System.out.println(c2_eqv_invest);
//		System.out.println(final_amt);
	
		
//		Reverse Arbitrage Calculations 
		amt_to_return_r = ucl.getAmount() + (ucl.getAmount() * (ucl.getInt_c2().getAsk()/400));
	    c2_to_c1_r = ucl.getAmount()/ucl.getBid_ask().getAsk();
	    c1_eqv_invest_r = c2_to_c1_r + (c2_to_c1_r * (ucl.getInt_c1().getBid()/400));
	    final_amt_r = c1_eqv_invest_r * ucl.getBid_ask_3().getBid(); 
		
//	    Variable declaration for Result json
	    String result="";
	    double fx_p_l=0;
	    String choice="";
	    if(final_amt > (amt_to_return + cost)) {
	    	
	    	result = "Arbitrage possible with profit";
	    	choice = "Borrow in: " +ucl.getC1() + " and Invest In: " +ucl.getC2();
	    	fx_p_l = Double.parseDouble(df2.format(final_amt-(amt_to_return+cost)));
	    	
	    	return new Result_fx(result,fx_p_l,choice);

	    }
	    else if((final_amt_r > (amt_to_return_r + cost))) {
	    	
	    	result = "Arbitrage possible with profit"; 
	    	choice = "Borrow in: " +ucl.getC2() + " and Invest In: " +ucl.getC1();
	    	fx_p_l =  Double.parseDouble(df2.format(final_amt_r-(amt_to_return_r+cost)));
//	    	System.out.println((amt_to_return+cost)-final_amt);
	    	
	    	return new Result_fx(result,fx_p_l,choice);

	    }
	    else {
	    	result = "No arbitrage possible loss";
	    	choice=  "";
	    	fx_p_l = - Double.parseDouble(df2.format((amt_to_return+cost) -final_amt));;
	    	
	    	return new Result_fx(result,fx_p_l,choice);

	    }
	    
	    

}


// Random value Generator and extrapolating to required range

	@Override
	public Parameters_fx rv_generator(double min, double max) {
		double value=0,ask=0,bid=Integer.MAX_VALUE;
		value = Math.random();
		ask = min+(value*(max-min));
		while(bid>ask) {
			value=Math.random();
			bid=min+(value*(max-min));
		}
			  
		return new Parameters_fx(bid,ask);
	}

}
