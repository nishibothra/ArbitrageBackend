package com.starter.randomdata;

import java.util.Random;
import java.util.stream.DoubleStream;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.starter.pojo.FRAData;

@Component
public class DataGenerator {

	public FRAData getRandomData(FRAData data) {

		Random random = new Random();
		
		data.setPrincipleAmount(Math.pow(10, 2 + random.nextInt(7)));
		data.setTransactionCost(0.1);

		Double sixMBid = -1.0 + (2.5 + 1) * random.nextDouble();
		Double sixMAsk = sixMBid + 0.05 + (0.2) * random.nextDouble();

		data.setSixMonthsSpotAsk(sixMAsk);
		data.setSixMonthsSpotBid(sixMBid);

		Double twelMBid = sixMBid + (0.5) * random.nextDouble() - 0.1 * random.nextDouble();
		Double twelMAsk = twelMBid + 0.05 + (0.2) * random.nextDouble();

		data.setTwelveMonthSpotAsk(twelMAsk);
		data.setTwelveMonthSpotBid(twelMBid);

		Double sixTwelBid = sixMBid + (0.5) * random.nextDouble() - 0.15 * random.nextDouble();
		Double sixTwelAsk = sixTwelBid + 0.05 + (0.2) * random.nextDouble();

		data.setSixByTwelveFRAsk(sixTwelAsk);
		data.setSixBytwelveFRBid(sixTwelBid);

		data.setIsArbitrageLongBorrow(false);
		data.setIsArbitrageLongLend(false);

		return data;
	}

}
