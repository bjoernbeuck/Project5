package de.beuck.bjoern.data;

import java.util.Date;

public class WeightHistory {
	private double _weight;
	private long _timestamp;
	private long _id;
	
	@Override
	public String toString(){
		return _weight + " " +  _timestamp;
	}
	
	public WeightHistory(double weight){
		_weight = weight;
		_timestamp = new Date().getTime();
	}


	public double get_weight() {
		return _weight;
	}

	public void set_weight(double _weight) {
		this._weight = _weight;
		_timestamp = new Date().getTime();
	}

	public long get_timestamp() {
		return _timestamp;
	}
	
	public long get_id(){
		return _id;
	}
	
}
