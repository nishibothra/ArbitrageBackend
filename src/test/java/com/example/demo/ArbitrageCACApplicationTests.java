package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.starter.services.CashandCarryService;



@SpringBootTest
public class ArbitrageCACApplicationTests {
	
	@Test
	void contextLoads() {
	}

	@Autowired
	CashandCarryService cacService;

}
