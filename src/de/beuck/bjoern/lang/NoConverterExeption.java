package de.beuck.bjoern.lang;

public class NoConverterExeption extends Exception {

	private String message;

	public NoConverterExeption(String message){
		this.message = message;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}

}
