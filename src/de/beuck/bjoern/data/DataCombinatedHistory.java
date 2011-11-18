package de.beuck.bjoern.data;

import java.util.Date;

public class DataCombinatedHistory {
 
	private Date _date;
	private double _weight;
	private BmiTrendKonstants _bmiTrend;
	private double _bmi;
	private int _kcal;
	
	public DataCombinatedHistory(Date date, double weight, double bmi, BmiTrendKonstants bmiTrend, int daylyEatenkCals){
		_date = (Date)date.clone();
		_weight = weight;
		_bmi = bmi;
		_bmiTrend = bmiTrend;
		_kcal = daylyEatenkCals;
	}
	
	public Date get_date() {
		return _date;
	}
	public double get_weight() {
		return _weight;
	}
	public BmiTrendKonstants get_bmiTrend() {
		return _bmiTrend;
	}
	public double get_bmi() {
		return _bmi;
	}
	public int get_Kcal() {
		return _kcal;
	}
	
	
	
}
