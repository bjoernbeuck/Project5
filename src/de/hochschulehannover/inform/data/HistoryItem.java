package de.hochschulehannover.inform.data;

import java.util.Date;

/**
 * Stores an item (like a FoodItem) with a date
 * @author jcp
 *
 */
public abstract class HistoryItem implements Comparable{
	protected Date _date;
	
	public Date getDate(){
		return _date;
	}
	
	public int compareTo(Object o1) {
        if (this.getDate().equals(((HistoryItem) o1).getDate()))
            return 0;
        else if (this.getDate().after(((HistoryItem) o1).getDate()))
            return 1;
        else
            return -1;
    }
}
