package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.CashAndCarry;
import com.pojo.Data;
import com.pojo.random_values;
import com.pojo.result_fx;
import com.pojo.user_calc_input;
import com.randomdata.DataGenerator;
import com.services.ForexService;

@CrossOrigin
@RestController
public class Arbitrage_Controller {


// <---------------------------------------Cash and Carry Controller------------------------------------------>
	@Autowired
	com.services.CashandCarryService cac;
	
	
	@GetMapping("/CashAndCarryArbitrage")
	public List<String> decision()
	{
		return cac.arbitrage();
		
	}
	
	@PostMapping("/CashAndCarryArbitrage/Calculator")
	public List<String> decision2(@RequestBody CashAndCarry c)
	{
		
		return cac.Calculator(c);
	}
//	<------------------------------------------Forex Controller------------------------------------------------->
	@Autowired
	ForexService forex;
	
	@PostMapping("/fx/calculator")
	public result_fx arbitrage_check(@RequestBody user_calc_input uci) {
		result_fx res = forex.fx_calculator(uci);
		return res;
	}
	
	@GetMapping("/fx/{amount}")
	public random_values arbitrage_random(@PathVariable double amount) {
		double cost=0;
		random_values rv=null;
		rv = forex.arbitrage(amount, cost);
		return rv;
	}
//	<-------------------------------------------FRA Controller---------------------------------------------------->
	 
	@Autowired
	com.services.FRAService cal;
	
	@Autowired
	DataGenerator dg;
	
	@GetMapping("/frarbitrage")
	public Data getArb() {
		Data d = cal.calculateGainLossLongBorrow(dg.getRandomData(new Data()));
		d=cal.calculateGainLossLongLend(d);
		return d;

	}
	
	@PostMapping("/fruserin")
	public Data getCalculation(@RequestBody Data data) {
		//add cases and make calls base don the cases
		if(data.getSixByTwelveFRAsk()==0.0) {
			data = cal.calculateUserInLongLend(data);
		}else {
			data = cal.calculateGainLossLongLend(data);
		}
		if(data.getSixBytwelveFRBid()==0.0) {
			data = cal.calculateUserInLongBorrow(data);
		}else {
			data = cal.calculateGainLossLongBorrow(data);
		}
		
		return data;
	}
}
