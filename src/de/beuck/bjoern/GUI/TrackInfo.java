package de.beuck.bjoern.GUI;

import java.awt.BorderLayout;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import de.beuck.bjoern.lang.LanguageExecption;

public class TrackInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrackInfo(Locale language) {
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		try{
			tabbedPane.add("Physical Info",new TrackInfoPhysicalInfo(language));
			tabbedPane.add("Track Info",new TrackInfoDiet(language));
			tabbedPane.add("Exercise", new TrackInfoExercise(language));
		}
		catch (LanguageExecption e) {
			// TODO: handle exception
		}
		setLayout(new BorderLayout(0, 0));
		add(tabbedPane);


	}

}
