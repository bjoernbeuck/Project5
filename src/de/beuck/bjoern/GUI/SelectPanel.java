package de.beuck.bjoern.GUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectPanel extends JPanel {

	public SelectPanel(){
		setDoubleBuffered(true);
		setLayout(new GridLayout(5, 1));
		JButton options = new JButton("Options");
		JButton track = new JButton("Track Info");
		JButton update = new JButton("Update");
		JButton overview = new JButton("Overview");
		JButton recommens = new JButton("Recommendattions");
		add(overview);
		add(track);
		add(update);
		add(recommens);
		add(options);
	}
}
