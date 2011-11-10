package de.beuck.bjoern;

import java.util.Locale;

import javax.swing.JFrame;

public class GuiMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GuiMain() {
		setTitle("Update Information");
		add(new TrackInfo(Locale.ENGLISH));
	}

}
