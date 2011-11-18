package de.beuck.bjoern.lang;

import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Vector;



/**
 * @author Björn Beuck
 * date 07.11.2011
 *
 */

public class LocationManager {

	final static String BUNDLE_BASENANE = "./languages/";
	final String MODULE_NAME = "LocationManager";

	private static LocationManager instance = null;
	
	private LocationManager(){
		loadAvailableLanguages();
	}
	
	public static LocationManager getInstance(){
		if(instance == null){
			instance = new LocationManager();
		}
		return instance;
	}
	
	/**
	 *Speichert alle iso Codes für die Sprache. Werden automatisch gesucht 
	 */
	private Vector<String> languagesIsoNames = null;
	// Converter Delegate.
	private LocaleUnits converter = null;
	//temporäre Resource mit allen String - Key Werten
	private ResourceBundle languageResource = null;
	//Gibt an, welche Sprache angezeigt werden soll. Kann eine andere sein, wie die Werte des converter Delegates
	private Locale localeLang = null;
	
	//von welcher Klasse werden gerade die Strings benötigt
	private String guiElement;
	
	

	
	/** Gives you the aktually settet propertie file name. Without the language prefix and the properties extension
	 * @return The file name. E.g. Settings_en_EN.properties -> you will become the String "Settings"
	 */
//	public String getGuiElement() {
//		return guiElement;
//	}


	/**Set the new file to read the Strings. For example the name of file is Settings_en_EN.properties. The Param is than only "Settings".
	 * The rest will set automatical.
	 * @param guiElement Name of the file. But only the name, not the language postfix and the extension.
	 * @throws LanguageExecption The exception will raised, when no languages files will be found in the setted folder. Or when not the right language will found.
	 * The ISO Location postfix will ignored.
	 */
//	public void setGuiElement(String guiElement) throws LanguageExecption {
//		this.guiElement = guiElement;
//		loadWindowLanguageStringsResource(guiElement);
//	}


	/**
	 * @param unitConverter An Object, witch converts the metric Values of the Database in the user selected units. For Example 1 meters in 39.3700787 inch
	 * @param displayLanguage Set the Language for the Programm. It should a be a configurated Locate Object.
	 */
	private LocationManager(LocaleUnits unitConverter, Locale displayLanguage) {
		loadAvailableLanguages();
		localeLang = displayLanguage;
		converter = unitConverter;
		
	}
	
	
	/**Loads the language for the GUI window.
	 * @throws IOException It can't be loaded the requested File
	 */
	public ResourceBundle loadWindowLanguageStringsResource(String fileName, Locale displayLanguage) throws LanguageExecption{
		if(localeLang == null){
			throw new LanguageExecption("It isn't set a display language (No Locale class is set).");
		}
		
		try{
			//Nur laden, wenn von einem anderen Fenster etwas geladen werden soll
			if(!fileName.equals(guiElement)){
				languageResource = PropertyResourceBundle.getBundle(BUNDLE_BASENANE + fileName, displayLanguage);
			}
		}
		catch (MissingResourceException e2) {
			System.err.println("Cannot load the file with name: " + BUNDLE_BASENANE + fileName);
			e2.printStackTrace();
			throw new LanguageExecption("(MissingResourceException) Cannot load the file with name: " + BUNDLE_BASENANE + fileName);
		}
		catch (NullPointerException e1) {
			System.err.println("The Inputstream is empty");
			e1.printStackTrace();
			throw new LanguageExecption("(NullPointerException) The Inputstream is empty");
		} 
		return languageResource;
	}
	
	
	/** Not implemented yet
	 * Get all languages Strings and keys
	 * @return null
	 */
	public Dictionary<String, String> getCompleteLanguageStrings(){
		// TODO implenetieren wenn benötigt
		return null;
	}
	
	
	/**Retuns a localized String for the programm
	 * @param module Name of the file for all translated Strings. But only the name, not the language postfix or the extension. 
	 * For Example Settings_en_EN.properties required only the String "Settings"
	 * @param langSting The Key for the translated String, which is contains in the property file.
	 * @return a translated String, relevant to the Key
	 * @throws LanguageExecption The exception will raised, when no languages files will be found in the setted folder. Or when not the right language will found.
	 * The ISO Location postfix will ignored.
	 */
//	public String getLocaleLanguageString(String module, String langSting) throws LanguageExecption{
//		loadWindowLanguageStringsResource(module);
//		return languageResource.getString(langSting);
//	}
	
	
	/** This method checks whether a converter is set
	 * @return true when it is set one
	 * false No converter class is set.
	 */
	private boolean checkIsSetTheConverter(){
		if(converter == null){
			return false;
		}
		return true;
	}
	
	
	/** The method converts a given value in kilograms, in the target system E.g. kilogramm in lbs. Its a delegate method from the Converter
	 * @param unitInKilograms Input value in kilogramm = 1000 grams
	 * @param toUnit a string that indicates what unit to convert to. For the available Strings you must see in the docs of the concrete converter 
	 * @return A String the includes the converted value, and the unit
	 * @throws NoConverterExeption Will raised, when you have forgotten to set the concrete unit converter
	 * @throws NotSupportedUnitException Will raised when the unit is not supported by the converter. There is a list with all options on the most Exceptions saved, in the field supportedUnits
	 */
	public String convertFromKilos(double unitInKilograms, String toUnit) throws NoConverterExeption, NotSupportedUnitException{
		if (!checkIsSetTheConverter())
			throw new NoConverterExeption("It isn't set a converter");
		return converter.convertFromKilos(unitInKilograms, toUnit);
	}
	
	/** The method converts a given value in grams, in the target system E.g. gramm in oz. Its a delegate method from the Converter
	 * @param convertFromGrams Input value in gramm = 1/1000 kilogram
	 * @param toUnit a string that indicates what unit to convert to. For the available Strings you must see in the docs of the concrete converter 
	 * @return A String the includes the converted value, and the unit
	 * @throws NoConverterExeption Will raised, when you have forgotten to set the concrete unit converter
	 * @throws NotSupportedUnitException Will raised when the unit is not supported by the converter. There is a list with all options on the most Exceptions saved, in the field supportedUnits
	 */
	public String convertFromGrams(double unitInGrams, String toUnit) throws NoConverterExeption, NotSupportedUnitException{
		if (!checkIsSetTheConverter())
			throw new NoConverterExeption("It isn't set a converter");
		return converter.convertFromGrams(unitInGrams, toUnit);
	}
	
	/** This method converts a given metric centimeter value in the new system value. E.g. centimeters in foots
	 * @param unitInCentimeter Input value in centimeters
	 * @param toUnit a string that indicates what unit to convert to. For the available Strings you must see in the docs of the concrete converter 
	 * @return A String the includes the converted value, and the unit
	 * @throws NoConverterExeption Will raised, when you have forgotten to set the concrete unit converter
	 * @throws NotSupportedUnitException Will raised when the unit is not supported by the converter. There is a list with all options on the most Exceptions saved, in the field supportedUnits
	 */
	public String convertFromCentimeters(double unitInCentimeter, String toUnit) throws NoConverterExeption, NotSupportedUnitException{
		if (!checkIsSetTheConverter())
			throw new NoConverterExeption("It isn't set a converter");
		return converter.convertFromCentimeters(unitInCentimeter, toUnit);
	}
	
	/** This method converts a given metric value in the new system value. E.g. meters in foots
	 * @param unitInMeters Input value in meters
	 * @param toUnit a string that indicates what unit to convert to. For the available Strings you must see in the docs of the concrete converter 
	 * @return A String the includes the converted value, and the unit
	 * @throws NoConverterExeption Will raised, when you have forgotten to set the concrete unit converter
	 * @throws NotSupportedUnitException Will raised when the unit is not supported by the converter. There is a list with all options on the most Exceptions saved, in the field supportedUnits
	 */
	public String convertFromMeters(double unitInMeters, String toUnit) throws NoConverterExeption, NotSupportedUnitException{
		if (!checkIsSetTheConverter())
			throw new NoConverterExeption("It isn't set a converter");
		return converter.convertFromMeters(unitInMeters, toUnit);
	}
	
	/**The Method delegates the unit convertes to the unitConverter Class
	 * @param value metric value, which is to be converted
	 * @return The converted value as String
	 */
	public String getConvertedLocaleUnit(double value) {
		return converter.getValue(value);
	}
	
	/** Here you can set a new unitConverter. The converter must implemets the LocaleUnits interface.
	 * @param unitConverter a class which can calculate a 
	 * @return
	 */
	public String setUnitConverter(LocaleUnits unitConverter){
		converter = unitConverter;
		return converter.getDisplayName();
	}
	
	/** Loads all properties files, to determine all available Languages. When it found one language
	 * file, it will be saved in the list. The fuction searched .properties files witch the Java name 
	 * convension for language String files.
	 * The result will be saved in the private variable languagesIsoNames
	 */
	private void loadAvailableLanguages()
	{
		//Vector<String> languages = null;
		File file = new File(BUNDLE_BASENANE);
		String[] directory = file.list();
		for(String akt : directory){
			if(new File(akt).isFile())
			{
				//berechnen wo der erste Unterstrich im Dateiname sein muss.
				int begin = akt.length() - 16;
				
				//Prüfen ob der Dateiname dem Format dateiname_en_EN.Erweiterung entspricht
				if((akt.substring(begin-1, begin + 1) == "_") && (akt.substring(begin+2, begin + 1) == "_")){
					//Prüfen ob es sich um eine Properties Datei handelt
					if(akt.toLowerCase().contains("properties")){
						String lang = akt.substring(begin, begin + 2);
						if(!languagesIsoNames.contains(lang)){
							languagesIsoNames.add(lang);
						}
					}
				}
				
				
			}
		}
	}
	
	
	/**This method gives you all available languagepacks in the directory.
	 * Beware, there is no check whether all required files are present
	 * @return List of all founded languages as full name, like english, german etc.
	 * @throws LanguageExecption No language files found in the programm directory. (fatal error, programm must be stopped)
	 */
	public Vector<String> getAvailableLanguagesNames() throws LanguageExecption{
		Vector<String> displayNames = null;
		
		if(languagesIsoNames.isEmpty()){
			throw new LanguageExecption("No languages available. Please copy at least one Lang-Pack in the Programm directory");
		}
		
		for(int i = 0; i < languagesIsoNames.size(); ++i){
			String displayLocale = new Locale(languagesIsoNames.elementAt(i)).getDisplayLanguage(); 
			if(!displayNames.contains(displayLocale)){
				displayNames.add(displayLocale);
			}
		}
		return displayNames;
	}
	
}
