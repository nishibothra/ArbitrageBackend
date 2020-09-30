package com.starter.services;


import com.starter.pojo.Parameters_fx;
import com.starter.pojo.Random_Values_fx;
import com.starter.pojo.Result_fx;
import com.starter.pojo.User_Calc_Input_fx;


public interface ForexService {
	public Random_Values_fx arbitrage(double amount,double cost);
	public Parameters_fx rv_generator(double min,double max);
	public Result_fx fx_calculator(User_Calc_Input_fx ucl); 
	
}
 