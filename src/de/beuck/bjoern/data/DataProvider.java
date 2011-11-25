package de.beuck.bjoern.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class DataProvider {

	private ArrayList<DailyHistory> _dailyHistory = new ArrayList<DailyHistory>();
	private UserInformation _user = new UserInformation();
	private static  DataProvider instance = null;
	
	private DataProvider(){
		
	}
	
	public static DataProvider getInstance(){
		if(instance == null){
			instance = new DataProvider();
		}
		return instance;
	}
	
	
	public Vector<DataCombinatedHistory> getDataInIntervall(Date start, Date end){
		BmiTrendKonstants trend = BmiTrendKonstants.bmi_equal;
		Vector<DataCombinatedHistory> res = new Vector<DataCombinatedHistory>();
		
		double tr = -1.0;
		for(DailyHistory buf : _dailyHistory){
			
			if(buf.get_date().after(start) && buf.get_date().before(end))
			{
				int counts = buf.getCountOfMeasures();
				int kcals = buf.getKCalsOfDay();
				WeightHistory[] weigh = buf.get_weights();
				
				for(int i1 = 0; i1 < counts; ++i1){
					
					double weightBuf = weigh[i1].get_weight();
					if(tr != -1.0){
						if(weightBuf == tr){
							trend = BmiTrendKonstants.bmi_equal;
						} else if(weightBuf > tr){
							trend = BmiTrendKonstants.bmi_up;
						} else {
							trend = BmiTrendKonstants.bmi_down;
						}
					}
					else{
						tr = weightBuf;
						trend = BmiTrendKonstants.bmi_init;
					}
					tr = weightBuf;
					
					res.add(new DataCombinatedHistory(buf.get_date(), weightBuf, getBmi(weightBuf, _user.get_height()), trend, kcals));
				}
			}
		}
		return res;
	}
	
	public Vector<DataCombinatedHistory> getData(){
		BmiTrendKonstants trend = BmiTrendKonstants.bmi_equal;
		Vector<DataCombinatedHistory> res = new Vector<DataCombinatedHistory>();
		
		double tr = -1.0;
		for(DailyHistory buf : _dailyHistory){
			int counts = buf.getCountOfMeasures();
			int kcals = buf.getKCalsOfDay();
			WeightHistory[] weigh = buf.get_weights();
			
			for(int i1 = 0; i1 < counts; ++i1){
				
				double weightBuf = weigh[i1].get_weight();
				if(tr != -1.0){
					if(weightBuf == tr){
						trend = BmiTrendKonstants.bmi_equal;
					} else if(weightBuf > tr){
						trend = BmiTrendKonstants.bmi_up;
					} else {
						trend = BmiTrendKonstants.bmi_down;
					}
				}
				else{
					tr = weightBuf;
					trend = BmiTrendKonstants.bmi_init;
				}
				tr = weightBuf;
				
				res.add(new DataCombinatedHistory(buf.get_date(), weightBuf, getBmi(weightBuf, _user.get_height()), trend, kcals));
			}
		}
		return res;
	}
	
	public double getBmi(double weight, int heightInCm) {
		return weight / ((heightInCm / 100)*(heightInCm / 100));
	}
	
	public boolean isBmiOk(double bmi, int age){
		if(age >= 19 && age <=24){
			if(bmi >= 19 && bmi <= 24){
				return true;
			}
			return false;
		} else if(age >= 25 && age <=34){
			if(bmi >= 20 && bmi <= 25){
				return true;
			}
			return false;
		} else if(age >= 35 && age <= 44){
			if(bmi >= 21 && bmi <= 26){
				return true;
			}
			return false;
		} else if(age >= 45 && age <= 54){
			if(bmi >= 22 && bmi <= 27){
				return true;
			}
			return false;
		} else if(age >= 55 && age <=64){
			if(bmi >= 23 && bmi <= 28){
				return true;
			}
			return false;
		} else if(age > 64){
			if(bmi >= 24 && bmi <= 29){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public void setNewWeight(WeightHistory newWeight, Date date){
		DailyHistory buf = findByDay(date);
		if(buf != null){
			buf.setWeight(newWeight);
			return;
		}
		_dailyHistory.add(new DailyHistory(newWeight, date));
	}
	
	public void setNewIntaken(IntakenHistory intaken, Date date){
		DailyHistory buf = findByDay(date);
		if(buf != null){
			buf.setIntakenFood(intaken);
			return;
		}
		_dailyHistory.add(new DailyHistory(intaken, date));
	}
	
	public boolean deleteWeightMeasure(WeightHistory weight, Date date){
		DailyHistory buf = findByDay(date);
		if(buf != null){
			return buf.deleteWeight(weight);
		}
		return false;
	}
	
	public boolean deleteIntakene(IntakenHistory intaken, Date date){
		DailyHistory buf = findByDay(date);
		if(buf != null){
			return buf.deleteIntaken(intaken);
		}
		return false;
	}
	
	private DailyHistory findByDay(Date date){
		for(DailyHistory buf : _dailyHistory){
			if(buf.get_date().equals(date)){
				return buf;
			}
		}
		return null;
	}
	
	@Override
	public String toString(){
		StringBuffer str = new StringBuffer();
		for(DailyHistory his : _dailyHistory){
			str.append(his);
			str.append(" ");
		}
		return str.toString();
	}
}
