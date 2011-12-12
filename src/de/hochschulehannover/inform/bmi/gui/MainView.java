package de.hochschulehannover.inform.bmi.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainView extends JFrame{

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	static GUIcontrol _guiControl;
	
	public MainView(){
		_guiControl = GUIcontrol.getInstance();
	}

	public void run() {
		
		int c = 0;
		
		
		this.setSize(new Dimension(670, 350));
		this.setMinimumSize(new Dimension(650, 300));
		this.setDefaultCloseOperation(MainView.EXIT_ON_CLOSE);
		this.setTitle(_guiControl.getLocalizedString("programme.name"));
		
		this.setJMenuBar(new MenuBar());
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.setTabPlacement(JTabbedPane.LEFT);
		
		jtp.addTab(_guiControl.getLocalizedString("tab.updateinfo"), _guiControl.getFoodAddPanel());
		jtp.setMnemonicAt(c, _guiControl.getLocalizedChar("tab.updateinfo.mn"));
		c++; // no pun intended
		
		jtp.addTab(_guiControl.getLocalizedString("tab.updateweight"), _guiControl.getUpdateWeightPanel());
		jtp.setMnemonicAt(c, _guiControl.getLocalizedChar("tab.updateweight.mn"));
		c++;
		
		jtp.addTab(_guiControl.getLocalizedString("tab.exercises"), new java.awt.Panel());
		jtp.setMnemonicAt(c, _guiControl.getLocalizedChar("tab.exercises.mn"));
		jtp.setEnabledAt(c, false);
		c++;
		
		jtp.addTab(_guiControl.getLocalizedString("tab.history"), new java.awt.Panel());
		jtp.setMnemonicAt(c, _guiControl.getLocalizedChar("tab.history.mn"));
		jtp.setEnabledAt(c, false);
		c++;
		
		this.add(jtp);
		
		validate();
		
		repaint();
		
		
		this.setVisible(true);
	}

}
