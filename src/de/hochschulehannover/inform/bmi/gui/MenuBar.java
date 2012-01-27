package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.log4j.Logger;

public class MenuBar extends JMenuBar implements ActionListener{
	
	/**
	 * Logger!
	 */
	private static Logger _LOGGER = Logger.getLogger(MenuBar.class);

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
		this.add(createEditMenu());
	}
	
	private JMenu createEditMenu() {
		JMenu editMenu = new JMenu(_guiControl.getLocalizedString("gui.edit"));
		try{
			editMenu.setMnemonic(_guiControl.getLocalizedChar("gui.edit.mn"));
		} catch (java.util.MissingResourceException e){
			_LOGGER.warn("No mnemonic for 'gui.edit'.", e);
		}
		
		JMenuItem settings = new JMenuItem(_guiControl.getLocalizedString("gui.settings"));
		try{
			settings.setMnemonic(_guiControl.getLocalizedChar("gui.settings.mn"));
		} catch (java.util.MissingResourceException e){
			_LOGGER.warn("No Mnemonic for 'gui.settings'.", e);
		}
		settings.setActionCommand("settings");
		settings.addActionListener(this);
		
		editMenu.add(settings);
		
		return editMenu;
	}

	private JMenu createFileMenu(){
		JMenu fileMenu = new JMenu(_guiControl.getLocalizedString("gui.file"));
		try{
			fileMenu.setMnemonic(_guiControl.getLocalizedChar("gui.file.mn"));
		} catch (java.util.MissingResourceException e){
			_LOGGER.warn("No mnemonic for 'gui.file'.", e);
		}
		
		JMenuItem quit = new JMenuItem(_guiControl.getLocalizedString("gui.quit"));
		try{
			quit.setMnemonic(_guiControl.getLocalizedChar("gui.quit.mn"));
		} catch (java.util.MissingResourceException e){
			_LOGGER.warn("No Mnemonic for 'gui.quit'.", e);
		}
		quit.setActionCommand("quit");
		quit.addActionListener(this);
		
		fileMenu.add(quit);
		
		return fileMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("quit".equals(e.getActionCommand())) _guiControl.quit();
		else _guiControl.showDialogue(e.getActionCommand());
	}

}
