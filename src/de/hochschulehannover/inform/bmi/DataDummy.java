package main;

import comm.BMIComm;
import comm.BMIParser;
import java.util.ArrayList;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import data.ActivityHistoryItem;
import data.Fitness;
import data.FitnessList;
import data.FoodHistoryItem;
import data.Nutrition;
import data.NutritionList;
import data.WeightHistoryItem;

public class DataDummy {

	private ArrayList<FoodHistoryItem> _foodHistory;
	
	private ArrayList<ActivityHistoryItem> _activityHistory;
	
	private SortedSet<WeightHistoryItem> _weightHistory;
	
        BMIComm communicator = new BMIComm();
        BMIParser parser = new BMIParser();

	
	public ArrayList<Nutrition> getFoodList() {
            String nutrition = communicator.getNutrition();
            NutritionList foodList = parser.getNutrition(nutrition);
            Nutrition[] foodItems = foodList.getItems();
            ArrayList<Nutrition> arl = new ArrayList<Nutrition>();
            for (int i=0; i<foodList.getSize(); i++) {
                arl.add( new Nutrition(foodItems[i].getId(), foodItems[i].getName(), foodItems[i].getUs_serving()) );
            }
//            arl.add(new Nutrition("01", "Sample Food 1", "Servings"));
//            arl.add(new Nutrition("02", "Sample Food 2", "Servings"));
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

	public ArrayList<Fitness> getActivityList() {
            String fitness = communicator.getFitness();
            FitnessList activityList = parser.getFitness(fitness);
            Fitness[] activityItems = activityList.getItems();
            ArrayList<Fitness> arl = new ArrayList<Fitness>();
            for (int i=0; i<activityList.getSize(); i++) {
                arl.add( new Fitness("sample" + activityItems[i].getId(), activityItems[i].getName()) );
            }
            return arl;
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
