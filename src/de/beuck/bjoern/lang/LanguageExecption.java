package de.beuck.bjoern.lang;

public class LanguageExecption extends Exception {

	String langErr;
	String module;
	String function;
	
	public LanguageExecption(String message) {
		langErr = message;
	}
	
	public LanguageExecption(String message, String module) {
		this(message);
		this.module = module;
	}
	
	public LanguageExecption(String message, String module, String function) {
		this(message, module);
		this.function = function;
	}
	
	@Override
	public String getMessage() {
		return langErr;
	}

	@Override
	public String toString() {
		return "Eception in module " + module + ": " + langErr;
	}

	
}
