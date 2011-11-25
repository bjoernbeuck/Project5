package de.beuck.bjoern.test;

import javax.swing.Action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class JToolbarDemo {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		
		final JTextArea textArea = new JTextArea();
		frame.add(new JScrollPane(textArea));
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Datei");
		menuBar.add(fileMenu);
		JMenu helpMenu = new JMenu("Hilfe");
		menuBar.add(helpMenu);
		frame.setJMenuBar(menuBar);
		helpMenu.add(new JMenuItem("Über das Programm"));
		final Icon smallIcon = new ImageIcon(JToolbarDemo.class.getResource("/fileopen16x16.png"));
		final Icon largeIcon = new ImageIcon(JToolbarDemo.class.getResource("/fileopen32x32.png"));
		
		Action openAction = new AbstractAction() {
			{
				putValue(Action.NAME,	"Öffnen");
				putValue(Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1);
				putValue(Action.SMALL_ICON, smallIcon);
				putValue(Action.LARGE_ICON_KEY, largeIcon);
			}
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				if( fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ) {
					FileReader in = null;
					try{
						textArea.read(in = new FileReader(fileChooser.getSelectedFile()), null);
					}
					catch(IOException ex){
						textArea.setText(ex.getMessage());
					}
					finally {
						try{
							in.close();
							
						}
						catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}	
			}
		};
		
		fileMenu.add(openAction);
		fileMenu.addSeparator();
		
		fileMenu.add( new AbstractAction() {
			{
				putValue(Action.NAME, "Beenden");
				putValue(Action.DISPLAYED_MNEMONIC_INDEX_KEY, 0);
			}
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(openAction);
		frame.add(toolBar, BorderLayout.PAGE_START);
		frame.setVisible(true);
	}
}
