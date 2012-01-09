package de.hochschulehannover.inform.bmi.data;

import java.util.Date;

/**
 * Stores a FoodItem with its serving size, meal and date
 * @author jcp
 *
 */
public class FoodHistoryItem extends HistoryItem{
	private FoodItem _foodItem;
	
	private String _servingSize;
	
	private String _meal;
	
	/**
	 * Constructor
	 * @param food
	 * @param servingSize
	 * @param meal
	 * @param date
	 */
	public FoodHistoryItem(FoodItem food, String servingSize, String meal, Date date){
		this._foodItem = food;
		this._servingSize = servingSize;
		this._meal = meal;
		this._date = date;
	}
	
	public FoodItem getFoodItem(){
		return _foodItem;
	}
	
	public String getServingSize(){
		return _servingSize;
	}
	
	public String getMeal(){
		return _meal;
	}
}
