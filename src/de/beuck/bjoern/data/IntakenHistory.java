package de.beuck.bjoern.data;

import java.util.Date;
import java.util.Vector;

/**
 * @author Björn Beuck
 * @date 18.11.2011
 * @version 
 *
 */
public class IntakenHistory {

	private long _timestamp;
	private long _id = -1;
	private double _quantity;
	private Vector<NutrialInformation> _nutrial = new Vector<NutrialInformation>();
	
	@Override
	public String toString(){
		return "Intaken: Quanti" + _quantity + " " + _timestamp;
	}
	
	public IntakenHistory(double quanity, NutrialInformation nutrial){
		_quantity = quanity;
		_nutrial.add(nutrial);
		_timestamp = new Date().getTime();
	}
	
	public IntakenHistory(double quanity, Vector<NutrialInformation> nutrial){
		_quantity = quanity;
		for(NutrialInformation buf : nutrial){
			_nutrial.add(buf);
		}
		_timestamp = new Date().getTime();
	}
	
	public IntakenHistory(double quanity, NutrialInformation[] nutrial){
		_quantity = quanity;
		for(NutrialInformation buf : nutrial){
			_nutrial.add(buf);
		}
		_timestamp = new Date().getTime();
	}

	public long get_id() {
		return _id;
	}

	/**Es kann die Id für das Objekt mit dieser Methode einmalig gesetzt werden.
	 * @param _id Die erstmalige Id für das Objekt
	 */
	public void set_id(long _id) {
		if(_id == -1){
			this._id = _id;
			_timestamp = new Date().getTime();
		}
	}

	public double getQuantity() {
		return _quantity;
	}

	public void setQuantity(double quantity) {
		this._quantity = quantity;
		_timestamp = new Date().getTime();
	}

	public Vector<NutrialInformation> get_nutrial() {
		return _nutrial;
	}

	public void set_nutrial(Vector<NutrialInformation> _nutrial) {
		this._nutrial = _nutrial;
		_timestamp = new Date().getTime();
	}

	/** Gibt die Seriennummer der letzten Änderung zurück. Diese wird automatisch gepflegt
	 * @return
	 */
	public long get_timestamp() {
		return _timestamp;
	}
	
	public int getFoodCalories(){
		int result = 0;
		for(NutrialInformation buf :_nutrial){
			result += buf.get_calories();
		}
		return result;
	}
}
