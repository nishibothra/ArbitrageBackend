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
import com.starter.pojo.FRADataDb;
import com.starter.pojo.Parameters_fx;
import com.starter.pojo.Random_Values_fx;
import com.starter.pojo.ResultCAC_db;
import com.starter.pojo.Result_fx;
import com.starter.pojo.Result_fx_db;
import com.starter.pojo.User_Calc_Input_fx;
import com.starter.randomdata.DataGenerator;
import com.starter.repo.CAC_Repo;
import com.starter.repo.FRARepo;
import com.starter.repo.ForexRepo;
import com.starter.services.ForexService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/arbitrage")
public class Arbitrage_Controller {



	@Autowired
	com.starter.services.CashandCarryService cac;
	
	@Autowired
	CAC_Repo cac_repo;

	
	
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
	
	@GetMapping("/cac/history")
	public Iterable<ResultCAC_db> cac_history() {
	//	List<ResultCAC_db> res =  cac_repo.findAll();
		List<ResultCAC_db> top3 = cac_repo.findTop5ByOrderByTransIdDesc();
		return top3;
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
	
	@Autowired
	FRARepo fraRepo;
	
	@GetMapping("/fra")
	public FRAData getArb() {
		FRAData d = cal.calculateGainLossLongBorrow(dg.getRandomData(new FRAData()));
		d=cal.calculateGainLossLongLend(d);
		cal.saveFraData(d);
		return d;

	}
	
	@PostMapping("/fra/calculator")
	public FRAData getCalculation(@RequestBody FRAData data) {
		//add cases and make calls base don the cases
		data = cal.calculateGainLossLongLend(data);
		data = cal.calculateGainLossLongBorrow(data);	
		return data;
	}
	
	@GetMapping("/fra/history")
	public Iterable<FRADataDb> fraHistory() {
		List<FRADataDb> top7 = fraRepo.findTop7ByOrderByTransIdDesc();
		return top7;
		
	}
	
}
