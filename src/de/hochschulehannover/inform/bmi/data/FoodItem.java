package data;

public class FoodItem {
	
	/**
	 * Constructer
	 * @param id
	 * @param name
	 */
	public FoodItem(String id, String name, String servingsize) {
		_ID = id;
		_Name = name;
                _ServingSize = servingsize;
	}
	
	private String _ID;
	
	public String getID(){
		return _ID;
	}
	
	private String _Name;
	
	public String getName(){
		return _Name;
	}
	
	private String _ServingSize;
	
	public String getServingSize(){
		return _ServingSize;
	}
	
	
}
