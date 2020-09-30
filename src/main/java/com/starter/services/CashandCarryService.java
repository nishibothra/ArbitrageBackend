package com.starter.services;


import com.starter.pojo.CashAndCarry;

public interface CashandCarryService {
	
	public CashAndCarry arbitrage();
	public CashAndCarry Calculator(CashAndCarry c);
	public double randomValueGenerator(double min, double max);
	public double ranValGen(double min,double max);
	public void monthAndRate();
	
}
