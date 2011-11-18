package de.beuck.bjoern.GUI;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowClosingAdapter extends WindowAdapter {

	private boolean exitSystem;
	
	/**
	 * Erzeugt einen WindowClosingAdapter zum Schließen des Fensters.
	 * @param exitSytem ist der Parameter true, wird die Anwendung geschlossen,
	 * ansonsten wird nur das Fenster geschlossen.
	 */
	public WindowClosingAdapter(boolean exitSytem)
	{
		this.exitSystem = exitSytem;
	}
	
	/**
	 * Erzeugt einen WindowClosingAdapter zum Schließen des Fensters. Das
	 * Programm wird nicht beendet.
	 */
	public WindowClosingAdapter()
	{
		this(false);
	}
	
	public void windowClosing(WindowEvent event)
	{
		event.getWindow().setVisible(false);
		event.getWindow().dispose();
		if(exitSystem)
		{
			System.exit(0);
		}
	}
}
