package com.randomdata;

import com.pojo.Data;

public class TestRandomData {
	
	public static void main(String[] args) {
		DataGenerator dataGenerator;
		for(int i=0;i<100;i++) {
			dataGenerator = new DataGenerator();
			System.out.println("SR#"+i+"  "+dataGenerator.getRandomData(new Data()));
			dataGenerator=null;
		}
	}
	
}
