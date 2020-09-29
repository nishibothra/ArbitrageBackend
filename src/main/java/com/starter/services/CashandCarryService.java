package com.starter.services;

import java.util.List;
import org.springframework.stereotype.Component;

import com.starter.pojo.CashAndCarry;

public interface CashandCarryService {
	
	public CashAndCarry arbitrage();
	public CashAndCarry Calculator(CashAndCarry c);
	public double randomValueGenerator(double min, double max);
	public void monthAndRate();
	
}
