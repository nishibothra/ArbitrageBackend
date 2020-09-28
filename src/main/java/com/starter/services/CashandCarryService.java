package com.starter.services;

import java.util.List;
import org.springframework.stereotype.Component;

import com.starter.pojo.CashAndCarry;

public interface CashandCarryService {
	public List<String> arbitrage();
	public List<String> Calculator(CashAndCarry c);
	//public List<String> CaandCarry(double spotPrice, double futurePrice, double dur, double ROI);
	//public List<String> RCandCarry(double spotPrice, double futurePrice, double dur, double ROI);
	public double randomValueGenerator(double min, double max);
	public void monthAndRate();
}
