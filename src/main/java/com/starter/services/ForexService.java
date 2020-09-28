package com.starter.services;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.starter.pojo.parameters;
import com.starter.pojo.random_values;
import com.starter.pojo.result_fx;
import com.starter.pojo.user_calc_input;


public interface ForexService {
	public random_values arbitrage(double amount,double cost);
	public parameters rv_generator(double min,double max);
	public result_fx fx_calculator(user_calc_input ucl); 
	
}
 