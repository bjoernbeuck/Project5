package de.beuck.bjoern.lang;

import java.util.Locale;

public class Conversion_si implements LocaleUnits{

	@Override
	public String getDisplayName() {
		return "metric";
	}

	@Override
	public String getValue(double input) {
		return null;
	}

	@Override
	public void setLanguageConstant(Locale country) {
	}

	@Override
	public Locale getLanguageConstant() {
		// TODO Auto-generated method stub
		return new Locale("de_DE");
	}

	@Override
	public String convertFromKilos(double unitInKilograms, String toUnit) {
		return ""+unitInKilograms  + " kg";
	}

	@Override
	public String convertFromGrams(double unitInGrams, String toUnit) {
		return ""+unitInGrams  + " gr";
	}

	@Override
	public String convertFromCentimeters(double unitInCentimeter, String toUnit) {
		return ""+unitInCentimeter + " cm";
	}

	@Override
	public String convertFromMeters(double unitInMeters, String toUnit) {
		return ""+unitInMeters + " m";
	}

	@Override
	public String convertFromMl(double unitInMilliLiters, String toUnit) {
		return ""+unitInMilliLiters + " ml";
	}

	@Override
	public String convertFromLiters(double unitInLiters, String toUnit) {
		return ""+unitInLiters + " l";
	}

	
}
