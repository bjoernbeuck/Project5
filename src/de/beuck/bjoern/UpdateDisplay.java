package de.beuck.bjoern;

import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import de.beuck.bjoern.GUI.UpdateInfoDiet;
import de.beuck.bjoern.GUI.UpdateInfoExercise;
import de.beuck.bjoern.lang.LanguageExecption;

public class UpdateDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5126160728886872748L;

	public UpdateDisplay(Locale language) throws LanguageExecption{
		JTabbedPane tb = new JTabbedPane();
		tb.addTab("Info", new UpdateInfoExercise(language));
		tb.addTab("Diet", new UpdateInfoDiet(language));
		tb.addTab("Exercise", new UpdateInfoExercise(language));
		//tb.addTab("Physical Info", new UpdateInfoPhysicalInfo(language));
		add(tb);
	}
}
