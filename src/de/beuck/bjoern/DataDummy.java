package de.beuck.bjoern;

import java.util.Date;
import java.util.Random;

import de.beuck.bjoern.data.DataProvider;
import de.beuck.bjoern.data.IntakenHistory;
import de.beuck.bjoern.data.NutrialInformation;
import de.beuck.bjoern.data.WeightHistory;

public class DataDummy {

	public static void createDatas(){
		DataProvider provider = DataProvider.getInstance();
		WeightHistory buf = null;
		double initWeight = 76.1;
		double dailyWeightBuf = 0.0;
		long oneday = new Date(2011,11,2).getTime() - new Date(2011,11,1).getTime();
		long initDate = new Date(2011,10,2).getTime();
		Date date = new Date(2011,10,2);
		Random rand = new Random();
		for(int i = 0; i <= 40; ++i){
			initWeight +=rand.nextDouble() % 1;
			provider.setNewWeight(new WeightHistory(initWeight), new Date(initDate + (oneday * i)));
			provider.setNewIntaken(new IntakenHistory(rand.nextDouble() % 5, new NutrialInformation(rand.nextInt()%2600, rand.nextDouble() % 1000)), new Date(initDate + (oneday * i)));
		}

	}
	
}
