package de.hochschulehannover.inform.data;

public class ActivityItem {
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 */
	public ActivityItem(String id, String name){
		_id = id;
		_name = name;
	}

	public String getId() {
		return _id;
	}

	public String getName() {
		return _name;
	}

	private String _id;
	
	private String _name;
}
