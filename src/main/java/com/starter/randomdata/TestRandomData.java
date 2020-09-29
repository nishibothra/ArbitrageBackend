package com.starter.randomdata;

import com.starter.pojo.FRAData;

public class TestRandomData {
	
	public static void main(String[] args) {
		DataGenerator dataGenerator;
		for(int i=0;i<100;i++) {
			dataGenerator = new DataGenerator();
			System.out.println("SR#"+i+"  "+dataGenerator.getRandomData(new FRAData()));
			dataGenerator=null;
		}
	}
	
}
