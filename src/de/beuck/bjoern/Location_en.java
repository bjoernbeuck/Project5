package de.beuck.bjoern;

import java.util.Locale;

public class Location_en implements LocaleUnits {

	private static final String MODULE_NAME = "Location_en";

	@Override
	public String getDisplayName() {
		return "english";
	}

	@Override
	public String getValue(double input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLanguageConstant(Locale country) {
		// TODO Auto-generated method stub

	}

	@Override
	public Locale getLanguageConstant() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * Converts Kilos in oz
	 * @see de.beuck.bjoern.LocaleUnits#convertFromKilos(double)
	 */
	@Override
	public String convertFromKilos(double unitInKilograms, String toUnit)  throws NotSupportedUnitException{
		// 1 KG = 2,2 lb
		// 1 KG = 35,27 oz
		if(toUnit.equals("oz")){
			return ""+(unitInKilograms * 35.27) + " oz";
		} else if(toUnit.equals("lbs")){
			return ""+(unitInKilograms * 2.204622) + " lbs";
		}

		throw new NotSupportedUnitException("Not supported unit", "oz, lbs", MODULE_NAME, "convertFromCentimeters");
	}

	@Override
	public String convertFromGrams(double unitInGrams, String toUnit)  throws NotSupportedUnitException{
		// 1 KG = 2,2 lb
		// 1 KG = 35,27 oz
		if(toUnit.equals("oz")){
			return ""+(unitInGrams * 0.03527) + " oz";
		} else if(toUnit.equals("lbs")){
			return ""+(unitInGrams * 0.002204623) + " lbs";
		}

		throw new NotSupportedUnitException("Not supported unit", "oz, lbs", MODULE_NAME, "convertFromGrams");
	}


	@Override
	public String convertFromMeters(double unitInMeters, String toUnit)  throws NotSupportedUnitException{
		return convertFromCentimeters(unitInMeters / 1000, toUnit);
	}

	@Override
	public String convertFromMl(double unitInMilliLiters, String toUnit)  throws NotSupportedUnitException{
		
		if(toUnit.equals("tsp")){
			return ""+ unitInMilliLiters * 0.2 + " tsp";
		}else if(toUnit.equals("fl.oz")){
			return "" + unitInMilliLiters * 0.113333  + " fl.oz";
		} else if(toUnit.equals("gallons")){
			return "" + unitInMilliLiters * 0.00026 + " gallons";
		} else if(toUnit.equals("quarts")){
			return "" + unitInMilliLiters * 0.00106 + " quarts";
		}
		
		throw new NotSupportedUnitException("Not supported unit", "tsp, fl.oz, gallons, quarts", MODULE_NAME, "convertFromMl");
	}

	@Override
	public String convertFromLiters(double unitInLiters, String toUnit) throws NotSupportedUnitException{
		return convertFromMl(unitInLiters * 1000, toUnit);
	}

	@Override
	public String convertFromCentimeters(double unitInCentimeter, String toUnit)  throws NotSupportedUnitException{
		
		if(toUnit.equals("yd")){
			return ""+ unitInCentimeter * 0.109361  + " yd";
		}else if(toUnit.equals("ft")){
			return "" + unitInCentimeter * 0.328083 + " ft";
		} else if(toUnit.equals("in")){
			return "" + unitInCentimeter * 2.54 + " in";
		} else if(toUnit.equals("quarts")){
			return "" + unitInCentimeter * 0.00106  + " quarts";
		}
		
		throw new NotSupportedUnitException("Not supported unit", "yd, ft, in, quarts", MODULE_NAME, "convertFromCentimeters");
	}

}
