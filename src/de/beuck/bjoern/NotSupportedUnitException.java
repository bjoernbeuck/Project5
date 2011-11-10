package de.beuck.bjoern;

public class NotSupportedUnitException extends Exception {

	private String message;
	private String supportedUnits;
	private String modul;
	private String function;
	
	public NotSupportedUnitException(String message){
		this.message = message;
	}
	public NotSupportedUnitException(String message, String supportedUnits){
		this(message);
		this.supportedUnits = supportedUnits;
	}
	public NotSupportedUnitException(String message, String supportedUnits, String modul){
		this(message, supportedUnits);
		this.modul = modul;
	}
	public NotSupportedUnitException(String message, String supportedUnits, String modul, String function){
		this(message, supportedUnits, modul);
		this.function = function;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Exeption ");
		
		if(!modul.isEmpty()){
			str.append("in Molul: ");
			str.append(modul);
		}
		
		if(!function.isEmpty()){
			str.append(", Function: ");
			str.append(function);
		}
		
		str.append(" Message: ");
		str.append(message);
		
		if(!supportedUnits.isEmpty()){
			str.append(" supportet units are only: ");
			str.append(supportedUnits);
		}
		
		return str.toString();
	}

	@Override
	public String getMessage() {
		return message;
	}

	
}
