package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.starter.pojo.Parameters;
import com.starter.pojo.Result_fx;
import com.starter.pojo.User_Calc_Input;
import com.starter.services.ForexService;

@SpringBootTest
class ArbitrageFxApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ForexService frxService;

	
}
