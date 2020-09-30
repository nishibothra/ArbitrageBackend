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
		//System.out.println(c1.getProfit());
		//System.out.println(c1.getBrokerage());
		assertEquals(5.701, c1.getProfit(), 0);
		
		
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
