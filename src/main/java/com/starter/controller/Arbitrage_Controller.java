package com.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.starter.pojo.CashAndCarry;
import com.starter.pojo.Data;
import com.starter.pojo.Parameters;
import com.starter.pojo.Random_Values_fx;
import com.starter.pojo.Result_fx;
import com.starter.pojo.User_Calc_Input;
import com.starter.randomdata.DataGenerator;
import com.starter.services.ForexService;

@CrossOrigin
@RestController
public class Arbitrage_Controller {


// <---------------------------------------Cash and Carry Controller------------------------------------------>
	@Autowired
	com.starter.services.CashandCarryService cac;
	
	
	@GetMapping("/CAC-Arbitrage")
	public List<String> decision()
	{
		return cac.arbitrage();
		
	}
	
	@PostMapping("/CAC-Arbitrage/Calculator")
	public List<String> decision2(@RequestBody CashAndCarry c)
	{
		
		return cac.Calculator(c);
	}
//	<------------------------------------------Forex Controller------------------------------------------------->
	@Autowired
	ForexService forex;
	
	@PostMapping("/fx/calculator")
	public Result_fx arbitrage_check(@RequestBody User_Calc_Input uci) {
		Result_fx res = forex.fx_calculator(uci);
		return res;
	
	}
	
	@GetMapping("/fx/{amount}")
	public Random_Values_fx arbitrage_random(@PathVariable double amount) {
		double cost=0;
		Random_Values_fx rv=null;
		rv = forex.arbitrage(amount, cost);
		return rv;
		
		
	}
//	<-------------------------------------------FRA Controller---------------------------------------------------->
	 
	@Autowired
	com.starter.services.FRAService cal;
	
	@Autowired
	DataGenerator dg;
	
	@GetMapping("/FRA")
	public Data getArb() {
		Data d = cal.calculateGainLossLongBorrow(dg.getRandomData(new Data()));
		d=cal.calculateGainLossLongLend(d);
		return d;

	}
	
	@PostMapping("/FRA-Input")
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
