package de.hochschulehannover.inform.bmi.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

public class MainView extends JFrame{

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	static GUIcontrol _guiControl;
	
	public MainView(){
		_guiControl = GUIcontrol.getInstance();
	}
	
	/**
	 * Logger!
	 */
	private static Logger _LOGGER = Logger.getLogger(MainView.class);

	public void run() {
		
		int c = 0;
		
		
		this.setSize(new Dimension(700, 420));
		this.setMinimumSize(new Dimension(700, 420));
		this.setDefaultCloseOperation(MainView.EXIT_ON_CLOSE);
		this.setTitle(_guiControl.getLocalizedString("programme_name"));
		
		this.setJMenuBar(new MenuBar());
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.setTabPlacement(JTabbedPane.LEFT);
		
		jtp.addTab(_guiControl.getLocalizedString("update_nutrition"), _guiControl.getFoodAddPanel());
		try {
			jtp.setMnemonicAt(c, _guiControl.getLocalizedChar("update_nutrition.mn"));
		} catch (java.util.MissingResourceException e){
			_LOGGER.warn("No mnemonic for 'update_nutrition'.", e);
		}
		
		c++; // no pun intended
		
		jtp.addTab(_guiControl.getLocalizedString("update_weight"), _guiControl.getUpdateWeightPanel());
		try {
			jtp.setMnemonicAt(c, _guiControl.getLocalizedChar("update_weight.mn"));
		} catch (java.util.MissingResourceException e){
			_LOGGER.warn("No mnemonic for 'update_weight'.", e);
		}
		c++;
		
		jtp.addTab(_guiControl.getLocalizedString("update_fitness"), _guiControl.getAddActivityPanel());
		try {
			jtp.setMnemonicAt(c, _guiControl.getLocalizedChar("update_fitness"));
		} catch (java.util.MissingResourceException e){
			_LOGGER.warn("No mnemonic for 'update_fitness'.", e);
		}
		//jtp.setEnabledAt(c, false);
		c++;
		
		jtp.addTab(_guiControl.getLocalizedString("gui.history"), new java.awt.Panel());
		try {
			jtp.setMnemonicAt(c, _guiControl.getLocalizedChar("gui.history.mn"));
		} catch (java.util.MissingResourceException e){
			_LOGGER.warn("No mnemonic for 'gui.history'.", e);
		}
		jtp.setEnabledAt(c, false);
		c++;
		
		jtp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
		        JTabbedPane pane = (JTabbedPane) evt.getSource();
		        _guiControl.getFoodAddPanel().refresh();
		        _guiControl.getUpdateWeightPanel().refresh();
		      }
		});
		
		this.add(jtp);
		
		validate();
		
		repaint();
		
		
		this.setVisible(true);
	}

}
