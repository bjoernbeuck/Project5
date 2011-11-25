package de.beuck.bjoern;

import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import de.beuck.bjoern.GUI.TrackInfo;
import de.beuck.bjoern.GUI.TrackInfoDiet;
import de.beuck.bjoern.GUI.TrackInfoExercise;
import de.beuck.bjoern.GUI.TrackInfoPhysicalInfo;
import de.beuck.bjoern.lang.LanguageExecption;

public class TrackDisplay extends JPanel {

	private static final long serialVersionUID = -5849559537444975538L;

	public TrackDisplay(Locale language) throws LanguageExecption{
		JTabbedPane tb = new JTabbedPane();
		tb.addTab("Info", new TrackInfo(language));
		tb.addTab("Diet", new TrackInfoDiet(language));
		tb.addTab("Exercise", new TrackInfoExercise(language));
		tb.addTab("Physical Info", new TrackInfoPhysicalInfo(language));
		add(tb);
	}
}
