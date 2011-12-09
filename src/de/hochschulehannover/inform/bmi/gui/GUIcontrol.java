package de.hochschulehannover.inform.bmi.gui;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Controls the different elements of the GUI
 * @author jcp
 *
 */
public final class GUIcontrol {
	/**
	 * Logger!
	 */
	private static Logger LOGGER = Logger.getLogger(GUIcontrol.class);
	
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
		LOGGER.info("Setting language to '" + locale + "'.");
		this._locale = new Locale(locale);
		try{
			_guiMessages = ResourceBundle.getBundle("GUIMessages", _locale);
		} catch (java.util.MissingResourceException e){
			LOGGER.error(e.getMessage());
			e.printStackTrace();
			this.showError("Language file could not be found. \n" +
					e.getLocalizedMessage());
		}
	}

	/**
	 * Get locale.
	 * @return current locale.
	 */
	public Locale get_locale() {
		return _locale;
	}
	
	private ResourceBundle _guiMessages;
	
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
    	//FIXME Print ERROR in local tongue
    	javax.swing.JOptionPane.showMessageDialog(null, message, "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    public String getLocalizedString(String key) throws java.util.MissingResourceException{
    	return _guiMessages.getString(key);
    }
}
