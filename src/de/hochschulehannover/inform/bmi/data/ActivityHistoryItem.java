package data;

import java.util.Date;


public class ActivityHistoryItem extends HistoryItem {
	ActivityItem _activity;
	int _repsOrSets = 0;
	
	//TODO proper time
	int _timeframe = 0;
	
	int _intensity = 0;
	
	public ActivityHistoryItem(ActivityItem activity, int repsOrSets, int timeframe, int intensity, Date date){
		_activity = activity;
		_repsOrSets = repsOrSets;
		_timeframe = timeframe;
		_intensity = intensity;
		_date = date;
	}
	
	public int getRepsOrSets(){return _repsOrSets;}
	public int getTimeframe(){return _timeframe;}
	
	public ActivityItem getActivityItem(){
		return _activity;
	}
}
