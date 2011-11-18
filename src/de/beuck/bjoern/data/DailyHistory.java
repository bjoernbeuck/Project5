package de.beuck.bjoern.data;

import java.util.Date;
import java.util.Vector;

public class DailyHistory {

	private Date _date;
	private Vector<WeightHistory> _weights = new Vector<WeightHistory>();
	private Vector<IntakenHistory> _intaken = new Vector<IntakenHistory>();
	
	private int _kCalBuf = 0;
	private boolean isLastestCalories = false;
	
	public Date get_date() {
		return _date;
	}
	public void set_date(Date _date) {
		this._date = _date;
	}
	
	public DailyHistory(){
		this(null, null, new Date());
	}
	
	public DailyHistory(WeightHistory weight, Date date){
		this(weight, null, date);
	}
	
	public DailyHistory(IntakenHistory intaken, Date date){
		this(null, intaken, date);
	}
	
	public DailyHistory(WeightHistory weight, IntakenHistory intaken, Date date){
		if(weight != null){
			_weights.add(weight);
		}
		
		if(intaken != null){
			_intaken.add(intaken);
		}
		_date = date;
	}
	
	public boolean deleteWeight(WeightHistory weight){
		return _weights.remove(weight);
	}
	
	public boolean deleteIntaken(IntakenHistory intaken){
		return _intaken.remove(intaken);
	}
	
	public WeightHistory[] get_weights() {
		WeightHistory[] result = new WeightHistory[_weights.size()];
		int i = 0;
		for(WeightHistory buf : _weights){
			result[i] = buf;
		}
		return result;
	}
	
	public void setWeight(WeightHistory weight){
		_weights.add(weight);
	}
	
	public void set_weights(Vector<WeightHistory> _weights) {
		this._weights = _weights;
	}
	
	public void setIntakenFood(IntakenHistory intaken){
		_intaken.add(intaken);
	}
	
	public Vector<IntakenHistory> get_intaken() {
		return _intaken;
	}
	public void set_intaken(Vector<IntakenHistory> _intaken) {
		this._intaken = _intaken;
		isLastestCalories = false;
	}
	
	public void recalculateKCals(){
		int result = 0;
		for(IntakenHistory buf : _intaken){
			result += buf.getFoodCalories(); 
		}
		_kCalBuf = result;
		isLastestCalories = true;
	}
	
	public int getKCalsOfDay(){
		if(isLastestCalories == false){
			recalculateKCals();
		}
		return _kCalBuf;
	}
	
	public int getCountOfMeasures()
	{
		return _weights.size();
	}
}
