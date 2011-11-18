package de.beuck.bjoern.data;

import java.util.Date;

public class NutrialInformation {

	private long _id;
	private long _timestamp;
	private int _calories;
	private double _carbs;
	private double _choles;
	private double _transFat;
	private double _polyFat;
	private double _satFat;
	private double _sodium;
	private double _sugar;
	private double _protein;
	
	public NutrialInformation(int calories, double carbs, double choles, double transFat, double polyFat, double satFat, double sodium, double sugar, double protein){
		_timestamp = new Date().getTime();
		_calories = calories;
		_carbs = carbs;
		_choles = choles;
		_transFat = transFat;
		_polyFat = polyFat;
		_satFat = satFat;
		_sodium = sodium;
		_sugar = sugar;
		_protein = protein;
	}
	
	public NutrialInformation(int calories, double carbs, double choles, double sodium, double sugar, double protein){
		this(calories, carbs, choles, 0,0,0, sodium, sugar, protein);
	}
	
	public NutrialInformation(int calories, double carbs, double sugar){
		this(calories, carbs, 0,0,0,0,0, sugar, 0);
	}
	
	public NutrialInformation(int calories,double sugar){
		this(calories, 0, 0,0,0,0,0, sugar, 0);
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
		_timestamp = new Date().getTime();
	}

	public int get_calories() {
		return _calories;
	}

	public void set_calories(int _calories) {
		this._calories = _calories;
		_timestamp = new Date().getTime();
	}

	public double get_carbs() {
		return _carbs;
	}

	public void set_carbs(double _carbs) {
		this._carbs = _carbs;
		_timestamp = new Date().getTime();
	}

	public double get_choles() {
		return _choles;
	}

	public void set_choles(double _choles) {
		this._choles = _choles;
		_timestamp = new Date().getTime();
	}

	public double get_transFat() {
		return _transFat;
	}

	public void set_transFat(double _transFat) {
		this._transFat = _transFat;
		_timestamp = new Date().getTime();
	}

	public double get_polyFat() {
		return _polyFat;
	}

	public void set_polyFat(double _polyFat) {
		this._polyFat = _polyFat;
		_timestamp = new Date().getTime();
	}

	public double get_satFat() {
		return _satFat;
	}

	public void set_satFat(double _satFat) {
		this._satFat = _satFat;
		_timestamp = new Date().getTime();
	}

	public double get_sodium() {
		return _sodium;
	}

	public void set_sodium(double _sodium) {
		this._sodium = _sodium;
		_timestamp = new Date().getTime();
	}

	public double get_sugar() {
		return _sugar;
	}

	public void set_sugar(double _sugar) {
		this._sugar = _sugar;
		_timestamp = new Date().getTime();
	}

	public double get_protein() {
		return _protein;
	}

	public void set_protein(double _protein) {
		this._protein = _protein;
		_timestamp = new Date().getTime();
	}

	public long get_timestamp() {
		return _timestamp;
	}
}
