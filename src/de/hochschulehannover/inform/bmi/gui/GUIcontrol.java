package de.hochschulehannover.inform.bmi.gui;

import java.awt.Component;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import de.hochschulehannover.inform.bmi.DataDummy;
import de.hochschulehannover.inform.data.FoodItem;
import de.hochschulehannover.inform.data.FoodHistoryItem;
import de.hochschulehannover.inform.data.WeightHistoryItem;

/**
 * Controls the different elements of the GUI
 * @author jcp
 *
 */
public final class GUIcontrol {
	/**
	 * Logger!
	 */
	private static Logger _LOGGER = Logger.getLogger(GUIcontrol.class);
	
	/**
	 * Current locale.
	 */
	private Locale _locale;

	/**
	 * Sets locale from a language code.
	 * @see java.util.Locale.Locale
	 * @param locale A two letter language code like &lsquo;en&rsquo; or 
	 * &lsquo;de&rsquo;.
	 * @throws NullPointerException if argument is NULL.
	 */
	public void set_locale(String locale) throws NullPointerException{
		_LOGGER.info("Setting language to '" + locale + "'.");
		this._locale = new Locale(locale);
		try{
			_guiMessages = ResourceBundle.getBundle("GUIMessages", _locale);
		} catch (java.util.MissingResourceException e){
			_LOGGER.error(e.getMessage());
			e.printStackTrace();
			this.showError("Language file could not be found.\n" +
					e.getLocalizedMessage());
		}
		
//	     try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * Get locale.
	 * @return current locale.
	 */
	public Locale get_locale() {
		return _locale;
	}
	
	/**
	 * Resource Bundle with localized messages
	 */
	private ResourceBundle _guiMessages;
	
	/**
	 * Panel containing mask to fill out food input information
	 */
	private FoodAddPanel _FoodAddPanel;
	
	/**
	 * Panel containing mask to update weight information.
	 */
	private WeightUpdatePanel _UpdateWeightPanel;
	
	private FitnessAddPanel _AddActivityPanel;
	
	private Date _workingDate;
	
	/**
	 * It's a fake!
	 */
	private DataDummy dataDummy;
	
	/**
	 * Instance of GUIcontrol.
	 */
	private static GUIcontrol instance;
	
	/**
	 * Constructor.
	 */
	private GUIcontrol(){
		//String lang = System.getProperty("user.language");
		this.set_locale(System.getProperty("user.language"));
		dataDummy = new DataDummy();
	}

	/**
     * Returns instance of GUI control
     * @return instance of GUIcontrol
     */
    public synchronized static GUIcontrol getInstance() {
        if (instance == null) {
            instance = new GUIcontrol();
        }
        return instance;
    }
	
    /*
     * Prints a nice error message on the screen.
     */
    public void showError(String message){
    	javax.swing.JOptionPane.showMessageDialog(null, message, this.getLocalizedString("ERROR"), javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * String in locale language if available
     * @param key Identifier
     * @return translated string
     * @see getLocalizedChar
     */
    public String getLocalizedString(String key) {
    	//TODO let throw exception and let caller handle problem (easier to debug)
    	try{
    		return _guiMessages.getString(key);
    	} catch (java.util.MissingResourceException e) {
    		_LOGGER.error(e.getMessage());
    		return key;
    	}
    }
    
    /**
     * String in locale language if available
     * @param key Identifier
     * @param parameters to replace variables with
     * @return translated string
     * @see getLocalizedChar
     */
    public String getLocalizedString(String key, String[] parameters){
    	MessageFormat mf = new MessageFormat("");
    	mf.applyPattern(getLocalizedString(key));
    	return mf.format(parameters);
    }
    
    /**
     * First letter of a string in local language if available
     * @param key Identifier
     * @return first letter of translated string
     * @throws java.util.MissingResourceException
     * @see getLocalizedString
     */
    public char getLocalizedChar(String key) throws java.util.MissingResourceException{
    	return _guiMessages.getString(key).toCharArray()[0];
    }

	public void quit() {
		System.exit(0);
	}

	/**
	 * Get FoodAddPanel
	 * @return JPanel
	 */
	public FoodAddPanel getFoodAddPanel() {
		if (_FoodAddPanel == null) _FoodAddPanel = new FoodAddPanel();
		return _FoodAddPanel;
	}
	
	public WeightUpdatePanel getUpdateWeightPanel() {
		if (_UpdateWeightPanel == null) _UpdateWeightPanel = new WeightUpdatePanel();
		return _UpdateWeightPanel;
	}
	
	/**
	 * Formats date according to locale.
	 * @return localized String
	 */
	public String getLocalizedStringFromDate(Date date) {
		// TODO add support for "yesterday"
		return this.isToday(getWorkingDate()) == 0 ? this.getLocalizedString("gui.today") : DateFormat.getDateInstance(DateFormat.SHORT).format(date);
	}

	public void setWorkingDate(Date _workingDate) {
		this._workingDate = _workingDate;
	}

	public Date getWorkingDate() {
		if (_workingDate == null) _workingDate = new Date();
		return _workingDate;
	}
	
	public ArrayList<FoodItem> getAllFoodItems(){
		return dataDummy.getFoodList();
	}
	
	public String[] getNutricionUnits(){
		return new String[] {this.getLocalizedString("servings"),
			this.getLocalizedString("pieces")
		};
	}
	
	// Gets the name of the local weight unit for display.
	public String getLocalWeightUnit(){
		//TODO add support for other units
		return this.getLocalizedString("kg");
	}
	
	/**
	 * Compare Date with current date.
	 * @param date 
	 * @return offset in days, i. e. 0 for today, -1 for yesterday
	 */
	public int isToday(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR) + cal.get(Calendar.DAY_OF_YEAR) -
			Calendar.getInstance().get(Calendar.YEAR) - 
			Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
	}

	public Object[][] getHistoryTable(Date workingDate) {
		//return this.dataDummy.fakeHistoryTable();
		//FIXME Proper Data
		Object[][] obj;
		ArrayList<FoodHistoryItem> history = this.dataDummy.fakedHistoryTable();
		if (history == null){
			obj = new Object[0][3];
		}
		else {
			obj = new Object[history.size()][3];
			for (int i = 0; i < history.size(); i++){
				obj[i][0] = history.get(i).getFoodItem().getName();
				obj[i][1] = this.getLocalizedString("Food."+ history.get(i).getMeal());
				obj[i][2] = history.get(i).getServingSize();
			}
		}
		
		return obj;
//		return this.dataDummy.fakeHistoryTable();
	}
	
	/**
	 * Adds intake to the list
	 * @param servings
	 * @param food
	 * @param meal
	 * @param date
	 */
	public void addMeal(String servings, FoodItem food, String meal, Date date){
		this.dataDummy.addToFakedHistoryTable(new FoodHistoryItem(food, servings, meal, date));
	}
	
	public FitnessAddPanel getAddActivityPanel(){
		if (_AddActivityPanel == null) _AddActivityPanel = new FitnessAddPanel();
		return _AddActivityPanel;
	}
	
	public String getLastWeightInfo(){
		//TODO support for non SI units
		if (dataDummy.getWeightHistory() == null) return "";
		return this.getLocalizedString("last_weight_WEIGHT_DATE", new String[] {
				dataDummy.getWeightHistory().last().getWeight() + "",
				this.getLocalizedStringFromDate(dataDummy.getWeightHistory().last().getDate())
				});
	}

	public void addWeight(double newWeight) {
		this.dataDummy.addToFakedWeightHistory(new WeightHistoryItem(newWeight, this.getWorkingDate()));
	}
}
