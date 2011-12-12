package de.hochschulehannover.inform.bmi.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar implements ActionListener{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	static GUIcontrol _guiControl;
	
	/**
	 * Constructor
	 */
	public MenuBar(){
		_guiControl = GUIcontrol.getInstance();
		this.add(createFileMenu());
	}
	
	private JMenu createFileMenu(){
		JMenu fileMenu = new JMenu(_guiControl.getLocalizedString("menu.file"));
		fileMenu.setMnemonic(_guiControl.getLocalizedChar("menu.file.mn"));
		
		JMenuItem quit = new JMenuItem(_guiControl.getLocalizedString("menu.quit"));
		quit.setMnemonic(_guiControl.getLocalizedChar("menu.quit.mn"));
		quit.setActionCommand("quit");
		quit.addActionListener(this);
		
		fileMenu.add(quit);
		
		return fileMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("quit".equals(e.getActionCommand())) _guiControl.quit();
	}

}
