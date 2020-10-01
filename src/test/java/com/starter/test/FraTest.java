package com.starter.test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.starter.pojo.FRAData;
import com.starter.services.FRAService;
import com.starter.services.FRAServiceImpl;

public class FraTest {
	
	@Autowired
	FRAService fra;
	
	@Autowired
	FRAData d;
	
	@Test
	void contextLoads() {
	}

	
	@Test
	public void testFraImpl() {
		d.setPrincipleAmount(100.00);
		d.setTransactionCost(0.1);
		//set other stuff
		d.setSixMonthsSpotAsk(2.62);
		d.setSixMonthsSpotBid(2.5);
		d.setTwelveMonthSpotAsk(3.30);
		d.setTwelveMonthSpotBid(3.20);
		d.setSixByTwelveFRAsk(3.11);
		d.setSixBytwelveFRBid(3.05);
		//calculate cases
		DecimalFormat df = new DecimalFormat("#.00");
		
		df.setRoundingMode(RoundingMode.CEILING);
		d = fra.calculateGainLossLongBorrow(d);
		d = fra.calculateGainLossLongLend(d);
	
		//FRA Answers  -Long Lend 0.214629  gain    Long Borrow 0.60594 loss
		System.out.println(d.toString());
		double num1 = Double.parseDouble(df.format(d.getGainLossLongLend()));
		assertEquals(0.21, num1);
		assertTrue(d.getIsArbitrageLongLend());
		double num2 =Double.parseDouble(df.format(d.getGainLossLongBorrow()));
		assertEquals(-0.61,num2);
		assertFalse(d.getIsArbitrageLongBorrow());
		
	}

	
}
	
