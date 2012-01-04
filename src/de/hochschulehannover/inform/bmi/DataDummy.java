package de.hochschulehannover.inform.bmi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import de.beuck.bjoern.data.DataProvider;
import de.beuck.bjoern.data.IntakenHistory;
import de.beuck.bjoern.data.NutrialInformation;
import de.beuck.bjoern.data.WeightHistory;
import de.hochschulehannover.inform.bmi.data.ActivityHistoryItem;
import de.hochschulehannover.inform.data.ActivityItem;
import de.hochschulehannover.inform.data.FoodItem;
import de.hochschulehannover.inform.data.FoodHistoryItem;
import de.hochschulehannover.inform.data.WeightHistoryItem;

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
	
	private ArrayList<FoodHistoryItem> _foodHistory;
	
	private ArrayList<ActivityHistoryItem> _activityHistory;
	
	private SortedSet<WeightHistoryItem> _weightHistory;
	
	private ArrayList<ActivityItem> _activities;
	
	
	public ArrayList<FoodItem> getFoodList(){
		ArrayList<FoodItem> arl = new ArrayList<FoodItem>();
		arl.add(new FoodItem("01", "Sample Food 1", "Servings"));
		arl.add(new FoodItem("02", "Sample Food 2", "Servings"));
		return arl;
	}
	
	public void addToFakedFoodHistoryTable(FoodHistoryItem foodHistoryItem){
		if (_foodHistory == null) _foodHistory = new ArrayList<FoodHistoryItem>();
		_foodHistory.add(foodHistoryItem);
	}
	
	public void addToFakedActivityHistoryTabe(ActivityHistoryItem activityHistoryItem){
		if (_activityHistory == null) _activityHistory = new ArrayList<ActivityHistoryItem>();
		_activityHistory.add(activityHistoryItem);
	}

	public ArrayList<FoodHistoryItem> fakedFoodHistoryTable() {
//		_history = new ArrayList<HistoryItem>();
//		_history.add(new HistoryItem(getFoodList().get(0), "1", "Breakfast", new Date()));
//		_history.add(new HistoryItem(getFoodList().get(1), "3", "Dinner", new Date()));
		return _foodHistory;
//		return new Object[][] {{getFoodList().get(0), "1", "Breakfast"},
//				{getFoodList().get(1), "3", "Dinner"}};
	}

	
	public SortedSet<WeightHistoryItem> getWeightHistory(){
		//if (_weightHistory == null) _weightHistory = new TreeSet<WeightHistoryItem>();
		return _weightHistory;
	}

	public void addToFakedWeightHistory(WeightHistoryItem weightHistoryItem) {
		if (_weightHistory == null) _weightHistory = new TreeSet<WeightHistoryItem>();
		_weightHistory.add(weightHistoryItem);
	}

	public ArrayList<ActivityItem> getActivityList() {
		if (_activities == null) {
			_activities = new ArrayList<ActivityItem>();
			_activities.add(new ActivityItem("sample1", "Sample Activity One"));
			_activities.add(new ActivityItem("sample2", "Sample Activity Two"));
		}
		return _activities;
	}

	public ArrayList<ActivityHistoryItem> fakedActivityHistoryTable() {
		return _activityHistory;
	}
	
	public ArrayList<ActivityHistoryItem> selectActivities(Date date){
		if (this._activityHistory == null) return null;
		ArrayList<ActivityHistoryItem> result = new ArrayList<ActivityHistoryItem>();
		for (int i = 0; i < this._activityHistory.size(); i++)
			if ((_activityHistory.get(i).getDate().getTime() - date.getTime()) /86400000 == 0)
				result.add(_activityHistory.get(i));
		return result.size() > 0? result : null;
	}
	
	public ArrayList<FoodHistoryItem> selectFoods(Date date){
		if (this._foodHistory == null) return null;
		ArrayList<FoodHistoryItem> result = new ArrayList<FoodHistoryItem>();
		for (int i = 0; i < this._foodHistory.size(); i++)
			if ((_foodHistory.get(i).getDate().getTime() - date.getTime()) /86400000 == 0)
				result.add(_foodHistory.get(i));
		return result.size() > 0? result : null;
	}
	
	
}
