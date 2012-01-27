package gui;

import comm.BMIComm;
import comm.BMIParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import main.DataDummy;
import data.ActivityHistoryItem;
import data.ActivityItem;
import data.Fitness;
import data.FoodHistoryItem;
import data.FoodItem;
import data.Login;
import data.Nutrition;
import data.WeightHistoryItem;

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
	
	private BMIComm _communicator = new BMIComm();
        private BMIParser _parser = new BMIParser();
        
        private SettingsView _settingsView;
	
	/**
	 * Instance of GUIcontrol.
	 */
	private static GUIcontrol instance;
	
	private Properties _userProperties;
	
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
    	} catch (Exception e) {
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
		// TODO add support for "last Monday" and the like
		//return this.isToday(getWorkingDate()) == 0 ? this.getLocalizedString("gui.today") : DateFormat.getDateInstance(DateFormat.SHORT).format(date);
		switch (this.isToday(getWorkingDate())){
		case 0: return this.getLocalizedString("gui.today");
		case -1: return this.getLocalizedString("gui.yesterday");
		default: return DateFormat.getDateInstance(DateFormat.SHORT).format(date);
		}
	}

	public void setWorkingDate(Date _workingDate) {
		this._workingDate = _workingDate;
	}

	public Date getWorkingDate() {
		if (_workingDate == null) _workingDate = new Date();
		return _workingDate;
	}
	
	public ArrayList<Nutrition> getAllFoodItems(){
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
//		return cal.get(Calendar.YEAR) + cal.get(Calendar.DAY_OF_YEAR) -
//			Calendar.getInstance().get(Calendar.YEAR) - 
//			Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		return (int) ((cal.getTimeInMillis() - Calendar.getInstance().getTimeInMillis())/86400000);
	}

	public Object[][] getFoodHistoryTable(Date workingDate) {
		//return this.dataDummy.fakeHistoryTable();
		//FIXME Proper Data
		Object[][] obj;
		ArrayList<FoodHistoryItem> history = this.dataDummy.selectFoods(getWorkingDate());
		if (history == null){
			obj = new Object[0][3];
		}
		else {
			obj = new Object[history.size()][3];
			for (int i = 0; i < history.size(); i++){
				obj[i][0] = history.get(i).getFoodItem().getName();
				obj[i][1] = this.getLocalizedString(history.get(i).getMeal());
				obj[i][2] = history.get(i).getServingSize();
			}
		}
		
		return obj;
//		return this.dataDummy.fakeHistoryTable();
	}
	
	public Object[][] getActivityHistoryTable(Date workingDate) {
		//return this.dataDummy.fakeHistoryTable();
		//FIXME Proper Data
		Object[][] obj;
		ArrayList<ActivityHistoryItem> history = this.dataDummy.selectActivities(getWorkingDate());
		if (history == null){
			obj = new Object[0][3];
		}
		else {
			obj = new Object[history.size()][3];
			for (int i = 0; i < history.size(); i++){
				obj[i][0] = history.get(i).getActivityItem().getName();
				obj[i][1] = history.get(i).getTimeframe();
				obj[i][2] = history.get(i).getRepsOrSets() == -1 ? this.getLocalizedString("gui.sym.none") : history.get(i).getRepsOrSets();
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
	public void addMeal(String servings, Nutrition food, String meal, Date date){
            FoodItem foodItem = new FoodItem(food.getId(), food.getName(), food.getUs_serving());
            FoodHistoryItem dietItem = new FoodHistoryItem(foodItem, servings, meal, date);
            this.dataDummy.addToFakedFoodHistoryTable(dietItem);
//            int userid = Integer.parseInt(this.getSettings("userid"));
//            String auth = this.getSettings("authkey");
//            int mealId = Integer.parseInt(food.getId());
//            Double noOfServings = Double.parseDouble(dietItem.getServingSize());
//            String mealJSON = _parser.updateDiet(food);
//            String debug = _communicator.updateDiet(userid, auth, _workingDate.getTime(), mealId, noOfServings, mealJSON);
//            System.out.println(debug);
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
            int userid = Integer.parseInt(this.getSettings("userid"));
            String authkey = this.getSettings("authkey");
            System.out.println( _communicator.updateWeight(userid, authkey, _workingDate.getTime(), newWeight) );
            this.dataDummy.addToFakedWeightHistory(new WeightHistoryItem(newWeight, this.getWorkingDate()));
	}

	public ArrayList<Fitness> getActivities() {
		return dataDummy.getActivityList();
	}

	public void addActivity(Fitness fitnessItem, int reps, int timeframe, int value) {
            ActivityItem activity = new ActivityItem(fitnessItem.getId(), fitnessItem.getName());
            dataDummy.addToFakedActivityHistoryTabe(new ActivityHistoryItem(activity, reps, timeframe, value, getWorkingDate()));
	}

	public void showDialogue(String actionCommand) {
            if ("settings".equals(actionCommand)) getSettingsView().run();
            else {
                _LOGGER.error("There is no dialogue called '" + actionCommand + "'.");
                this.showError(this.getLocalizedString("Error.there_is_no_DIALOGUE_dialouge", new String[] {actionCommand}));
            }
	}

	private void setSettingsView(SettingsView _settingsView) {
            this._settingsView = _settingsView;
	}

	private SettingsView getSettingsView() {
		//if (_settingsView == null)
			setSettingsView(new SettingsView());
		return _settingsView;
	}

	private void setUserSettings(Properties _userSettings) {
		this._userProperties = _userSettings;
	}

	private Properties getUserProperties() {
		if (_userProperties == null)
		{
			setUserSettings(new Properties());
			java.io.FileInputStream in = null;
			try {
				in = new java.io.FileInputStream(getSettingsFile());
			} catch (FileNotFoundException e1) {
				_LOGGER.info("There is no settings file at " + getSettingsFile());
			}
			if (in != null){
				try{
					getUserProperties().load(in);
					in.close();
				} catch (java.io.IOException e){
					_LOGGER.error(e.getMessage());
				}
			}
		}
		return _userProperties;
	}
	
	/**
	 * Returns the value for the specified user setting.
	 * If it does not exist the default Value will be saved and returned.
	 * @param key
	 * @param defaultValue
	 * @return user setting
	 */
	public String getSetting(String key, String defaultValue){
		if (!this.getUserProperties().containsKey(key)){
			_LOGGER.info("Key '" + key + "' not found in settings file.\n" +
					"Setting to '" + defaultValue + "'");
			setSetting(key, defaultValue);
		}
		return this.getUserProperties().getProperty(key, defaultValue);
	}
	
	public String getSettings(String key){
		if (!this.getUserProperties().containsKey(key))
			_LOGGER.warn("Key '" + key + "' not found in settings file.");
		return this.getUserProperties().getProperty(key);
	}
	
	public void setSetting(String key, String value){
		this.getUserProperties().setProperty(key, value);
		java.io.FileOutputStream out = null;
		try {
			out = new java.io.FileOutputStream(getSettingsFile());
		} catch (FileNotFoundException e) {
			_LOGGER.error("Cannot save user settings to " + getSettingsFile().toString() +
					": " + e.getMessage());
			this.showError(this.getLocalizedString("Error.cannot_save_settings") +
					" " + this.getLocalizedString("Error.need_write_access_to_LOCATION", 
							new String[] { getSettingsFile().toString() }));
		}
		if (out != null){
		try {
			this.getUserProperties().store(out, "This file is not intended to be manipulated manually.\n" +
					"# Y O U  K N O W  W H A T  Y O U  D O I N G.");
			out.close();
		} catch (IOException e) {
			_LOGGER.error("Cannot save user settings to " + getSettingsFile().toString() +
					": " + e.getMessage());
			this.showError(this.getLocalizedString("Error.cannot_save_settings") +
					" " + this.getLocalizedString("Error.need_write_access_to_LOCATION", 
							new String[] { getSettingsFile().toString() }));
		}
		
		}

	}
	
	/**
	 * Gets the directory in which user settings are saved.
	 * @return
	 * 
	 * I stole this from a piece of sample code from
	 * http://stackoverflow.com/questions/193474/how-to-create-an-ini-file-to-store-some-settings-in-java
	 */
	private java.io.File getSettingsFile() {
	    String userHome = System.getProperty("user.home");
	    if(userHome == null) {
	    	_LOGGER.error("Cannot detect user's home directory.");
	        throw new IllegalStateException("user.home==null");
	    }
	    java.io.File home = new java.io.File(userHome);
	    java.io.File settingsDirectory = new java.io.File(home, "." + this.getLocalizedString("programme_name").toLowerCase());
	    if(!settingsDirectory.exists()) {
	    	try{
	        if(!settingsDirectory.mkdir()) {
	        	_LOGGER.error("Failed to create " + settingsDirectory.toString());
	        }
	    	} catch (java.lang.SecurityException e){
	    		_LOGGER.error(e.getMessage());
	    		throw new IllegalStateException(settingsDirectory.toString());
	    	}
	    }
	    return new java.io.File(settingsDirectory, "settings");
	}

	/**
	 * Save user password
	 * @param string
	 * @param password
	 */
	public void setPassword(String string, char[] password) {
		// TODO add some sort of deception
		this.setSetting("password", String.valueOf(password));
	}

        /**
	 * Login and set user data
	 */
	public void login() {
            String user = this.getSettings("user");
            String pass = this.getSettings("password");
            String userdata = _communicator.login(user, pass);
            Login login = _parser.login(userdata);
            this.setSetting( "userid", login.getUserid() );
            this.setSetting( "authkey", login.getAuth() );
	}

}
