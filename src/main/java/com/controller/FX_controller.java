package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.random_values;
import com.pojo.result_fx;
import com.pojo.user_calc_input;
import com.services.ForexService;

@RestController
public class FX_controller {

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
}
