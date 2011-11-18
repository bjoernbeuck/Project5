package de.beuck.bjoern.data;

import java.util.Date;

public class UserInformation {
	private String _username;
	private String _password;
	private int _height;
	private Date _birthday;
	public String get_username() {
		return _username;
	}
	public void set_username(String _username) {
		this._username = _username;
	}
	public String get_password() {
		return _password;
	}
	public void set_password(String _password) {
		this._password = _password;
	}
	public int get_height() {
		return _height;
	}
	public void set_height(int _height) {
		this._height = _height;
	}
	public Date get_birthday() {
		return _birthday;
	}
	public void set_birthday(Date _birthday) {
		this._birthday = _birthday;
	}
	
	public int getAge(){
		return new Date().getYear() - _birthday.getYear();
	}
}
