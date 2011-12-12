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
		
		
		this.setSize(new Dimension(640, 480));
		this.setDefaultCloseOperation(MainView.EXIT_ON_CLOSE);
		this.setTitle(_guiControl.getLocalizedString("programme.name"));
		
		this.setJMenuBar(new MenuBar());
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.setTabPlacement(JTabbedPane.LEFT);
		
		jtp.addTab(_guiControl.getLocalizedString("tab.updateinfo"), _guiControl.getFoodAddPanel());
		jtp.setMnemonicAt(0, _guiControl.getLocalizedChar("tab.updateinfo.mn"));
		
		JPanel foo = new JPanel();
		foo.setBackground(Color.black);
		
		jtp.addTab(_guiControl.getLocalizedString("tab.history"), foo);
		jtp.setMnemonicAt(1, _guiControl.getLocalizedChar("tab.history.mn"));
		
		jtp.addTab(_guiControl.getLocalizedString("tab.exercises"), new java.awt.Panel());
		jtp.setMnemonicAt(2, _guiControl.getLocalizedChar("tab.exercises.mn"));
		jtp.setEnabledAt(2, false);
		
		this.add(jtp);
		
		validate();
		
		repaint();
		
		
		this.setVisible(true);
	}

}
