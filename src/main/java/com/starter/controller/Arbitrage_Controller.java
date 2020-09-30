package com.starter.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starter.pojo.CashAndCarry;
//import com.starter.pojo.Data;
import com.starter.pojo.FRAData;
import com.starter.pojo.Parameters_fx;
import com.starter.pojo.Random_Values_fx;
import com.starter.pojo.Result_fx;
import com.starter.pojo.Result_fx_db;
import com.starter.pojo.User_Calc_Input_fx;
import com.starter.randomdata.DataGenerator;
import com.starter.repo.ForexRepo;
import com.starter.services.ForexService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/arbitrage")
public class Arbitrage_Controller {



	@Autowired
	com.starter.services.CashandCarryService cac;
	
	
	@GetMapping("/cac")
	public CashAndCarry randomValueArbitrage()
	{
		return cac.arbitrage();
		
	}
	
	@PostMapping("/cac/calculator")
	public CashAndCarry calculatorArbitrage(@RequestBody CashAndCarry c)
	{
		
		return cac.Calculator(c);
	}
	

	@Autowired
	ForexService forex;
	
	@Autowired
	ForexRepo forexRepo;
	
	@PostMapping("/fx/calculator")
	public Result_fx arbitrage_check(@RequestBody User_Calc_Input_fx uci) {
		Result_fx res = forex.fx_calculator(uci);
		return res;
	
	}
	
	@GetMapping("/fx/history")
	public Iterable<Result_fx_db> forex_history() {
		List<Result_fx_db> top5 = forexRepo.findTop7ByOrderByTransIdDesc();
		return top5;
		
	}
	@GetMapping("/fx/{amount}")
	public Random_Values_fx arbitrage_random(@PathVariable double amount) {
		double cost=0;
		Random_Values_fx rv=null;
		rv = forex.arbitrage(amount, cost);
		return rv;
		
		
	}

	 
	@Autowired
	com.starter.services.FRAService cal;
	
	@Autowired
	DataGenerator dg;
	
	@GetMapping("/fra")
	public FRAData getArb() {
		FRAData d = cal.calculateGainLossLongBorrow(dg.getRandomData(new FRAData()));
		d=cal.calculateGainLossLongLend(d);
		return d;

	}
	
	@PostMapping("/fra/calculator")
	public FRAData getCalculation(@RequestBody FRAData data) {
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
