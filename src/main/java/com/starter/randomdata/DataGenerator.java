package com.starter.randomdata;

import java.util.Random;
import java.util.stream.DoubleStream;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.starter.pojo.Data;

@Component
public class DataGenerator {

	public Data getRandomData(Data data) {
		// for six Months spot the range is 0.5 to 1.3 and ask bid diffrence is 0.05 - 0.25
		
		// for 12 Months spot rates range is sixMonths(+0.5or -0.1) ask bid diffrence is
		// 0.05 - 0.30
		// for 6/12 fra range is sixMonths spot + - 0.5.
		// for transaction cost 0.01% of principle fixed 
		// principle for now is 10^(random bet 2 to 8);

		Random random = new Random();
		
		data.setPrincipleAmount(Math.pow(10, 2 + random.nextInt(7)));
		data.setTransactionCost(data.getPrincipleAmount()*0.0001);

		Double sixMBid = 0.5 + (1.3 - 0.5) * random.nextDouble();
		Double sixMAsk = sixMBid + 0.05 + (0.25) * random.nextDouble();

		data.setSixMonthsSpotAsk(sixMAsk);
		data.setSixMonthsSpotBid(sixMBid);

		Double twelMBid = sixMBid + (0.5) * random.nextDouble() - 0.1 * random.nextDouble();
		Double twelMAsk = twelMBid + 0.05 + (0.25) * random.nextDouble();

		data.setTwelveMonthSpotAsk(twelMAsk);
		data.setTwelveMonthSpotBid(twelMBid);

		Double sixTwelBid = sixMBid + (0.5) * random.nextDouble() - 0.5 * random.nextDouble();
		Double sixTwelAsk = sixTwelBid + 0.05 + (0.25) * random.nextDouble();

		data.setSixByTwelveFRAsk(sixTwelAsk);
		data.setSixBytwelveFRBid(sixTwelBid);
		
		data.setIsArbitrageLongBorrow(false);
		data.setIsArbitrageLongLend(false);

		return data;
	}

}
