package com.example.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.starter.pojo.FRAData;
import com.starter.pojo.Parameters_fx;
import com.starter.pojo.Result_fx;
import com.starter.pojo.User_Calc_Input_fx;
import com.starter.services.FRAService;
import com.starter.services.FRAServiceImpl;
import com.starter.services.ForexService;

@SpringBootTest
class ArbitrageFxApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testFraImpl() {
		FRAService fra = new FRAServiceImpl();
		FRAData d = new FRAData();
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
		DecimalFormat df = new DecimalFormat("#.000000");
		
		df.setRoundingMode(RoundingMode.FLOOR);
		d = fra.calculateGainLossLongBorrow(d);
		d = fra.calculateGainLossLongLend(d);
	
		//FRA Answers  -Long Lend 0.214629  gain    Long Borrow 0.60594 loss
		
		double num1 = Double.parseDouble(df.format(d.getGainLossLongLend()));
		assertEquals(0.214629,num1);
		assertTrue(d.getIsArbitrageLongLend());
		double num2 =Double.parseDouble(df.format(d.getGainLossLongBorrow()));
		assertEquals(-0.605938,num2);
		assertFalse(d.getIsArbitrageLongBorrow());
	}

	
}
