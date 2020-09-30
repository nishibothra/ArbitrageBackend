package com.starter.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.starter.pojo.CashAndCarry;
import com.starter.services.CashandCarryService;
import com.starter.services.CashandCarryServiceImpl;

public class CashandCarryTest {

	@Autowired
	CashandCarryService cacService;
	
	@Before
	public void setUp() throws Exception {
		cacService=new CashandCarryServiceImpl();	}

	@After
	public void tearDown() throws Exception {
		cacService=null;
	}

	@Test
	public void testArbitrage() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculator() {
		
		CashAndCarry c= new CashAndCarry(500,502,520,523,3,8.8,9,1.0,0.2);
		CashAndCarry c1=cacService.Calculator(c);
		assertEquals(5.70, c1.getProfit(), 0);
		
		CashAndCarry cc= new CashAndCarry(3161,3166,3190,3245,3,3.8,4,3000,0.2);
		CashAndCarry c2=cacService.Calculator(cc);
		assertEquals("Arbitrage not  possible", c2.getArbitrage());
		
		
	}

	@Test
	public void testRandomValueGenerator() {
		fail("Not yet implemented");
	}

	@Test
	public void testMonthAndRate() {
		fail("Not yet implemented");
	}

}
