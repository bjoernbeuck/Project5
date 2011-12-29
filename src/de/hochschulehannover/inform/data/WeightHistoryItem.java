package de.hochschulehannover.inform.data;

import java.util.Date;

/**
 * HistoryItem for weights
 * @see HistoryItem
 * @author jcp
 *
 */
public class WeightHistoryItem extends HistoryItem {
	private double _weight;
	
	/**
	 * Constructor
	 * @param weight in kg
	 * @param date
	 */
	public WeightHistoryItem(double weight, Date date){
		this._weight = weight;
		this._date = date;
	}
	
	public double getWeight(){ return _weight;}
}
