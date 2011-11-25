package de.beuck.bjoern.GUI;

import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import de.beuck.bjoern.lang.LanguageExecption;

public class UpdateInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	public UpdateInfo(Locale language) throws LanguageExecption {
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

	}

}
