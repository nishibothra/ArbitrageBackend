package com.starter.test;

import static org.junit.Assert.*;


import java.text.DecimalFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.starter.pojo.Parameters_fx;
import com.starter.pojo.Result_fx;
import com.starter.pojo.User_Calc_Input_fx;
import com.starter.services.ForexService;

public class forex_test {

	private static DecimalFormat df2 = new DecimalFormat("#.##");
		
//	send loss with -ve sign
	@Autowired
	ForexService frxService;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testArbitrage() {
//		fail("Not yet implemented");
	}

	@Test
	public void testFx_calculator() {
//	
////		User_Calc_Input_fx uci = new User_Calc_Input_fx(new Parameters_fx(0.912,0.914), new Parameters_fx(0.916,0.9175), new Parameters_fx(3.65,3.75), new Parameters_fx(3.2,3.5), 10000, "EUR", "GBP");
//		Result_fx ans = new Result_fx();
//		ans = frxService.fx_calculator(uci);
//		assertEquals(25.83, ans.getFx_p_l(), 0);

	}

	@Test
	public void testRv_generator() {
	
	}

}
