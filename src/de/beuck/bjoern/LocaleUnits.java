package de.beuck.bjoern;

import java.util.Locale;

public interface LocaleUnits {

	public String getDisplayName();
	public String getValue(double input);
	public void setLanguageConstant(final Locale country);
	public Locale getLanguageConstant();
	public String convertFromKilos(double unitInKilograms, String toUnit) throws NotSupportedUnitException;
	public String convertFromGrams(double unitInGrams, String toUnit) throws NotSupportedUnitException;
	public String convertFromCentimeters(double unitInCentimeter, String toUnit) throws NotSupportedUnitException;
	public String convertFromMeters(double unitInMeters, String toUnit) throws NotSupportedUnitException;
	public String convertFromMl(double unitInMilliLiters, String toUnit) throws NotSupportedUnitException;
	public String convertFromLiters(double unitInLiters, String toUnit) throws NotSupportedUnitException;
	
}
