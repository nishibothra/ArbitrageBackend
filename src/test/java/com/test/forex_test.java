package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.starter.pojo.Parameters_fx;
import com.starter.pojo.Result_fx;
import com.starter.pojo.User_Calc_Input_fx;
import com.starter.services.ForexService;

class forex_test {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Autowired
	ForexService frxService;

	@Test
	void testFx_calculator() {
		
		User_Calc_Input_fx uci = new User_Calc_Input_fx(new Parameters_fx(0.912,0.914), new Parameters_fx(0.916,0.9175), new Parameters_fx(3.65,3.75), new Parameters_fx(3.2,3.5), 10000, "EUR", "GBP");
		Result_fx ans = new Result_fx();
		ans = frxService.fx_calculator(uci);
//		System.out.println(ans.getFx_p_l());
		assertNull(ans);
//		(null, ans.getFx_p_l());
		
	}

}
