package com.starter.services;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.starter.pojo.Parameters;
import com.starter.pojo.Random_Values_fx;
import com.starter.pojo.Result_fx;
import com.starter.pojo.User_Calc_Input;


public interface ForexService {
	public Random_Values_fx arbitrage(double amount,double cost);
	public Parameters rv_generator(double min,double max);
	public Result_fx fx_calculator(User_Calc_Input ucl); 
	
}
 