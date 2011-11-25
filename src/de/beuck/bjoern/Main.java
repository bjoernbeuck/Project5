package de.beuck.bjoern;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import de.beuck.bjoern.GUI.DataDisplayContainer;
import de.beuck.bjoern.GUI.SelectPanel;
import de.beuck.bjoern.GUI.TrackInfo;
import de.beuck.bjoern.GUI.bmiPanel;
import de.beuck.bjoern.lang.LanguageExecption;
import de.beuck.bjoern.lang.LocationManager;

public class Main {

	private JFrame frmStart;
	private Locale language = new Locale("en_EN");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmStart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		try {
			initialize();
		} catch (LanguageExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws LanguageExecption 
	 */
	private void initialize() throws LanguageExecption {
		frmStart = new JFrame();
		frmStart.setTitle("Start");
		frmStart.setBounds(100, 100, 647, 499);
		frmStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Menüleite--------------------------
		JMenuBar menuBar = new JMenuBar();
		frmStart.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JSeparator separator = new JSeparator();
		mnEdit.add(separator);
		
		JMenuItem mntmPreferences = new JMenuItem("Preferences");
		mnEdit.add(mntmPreferences);
		
		JMenu mnHistory = new JMenu("History");
		menuBar.add(mnHistory);
		
		JMenuItem mntmWeight = new JMenuItem("Weight");
		mnHistory.add(mntmWeight);
		
		JMenuItem mntmGoal = new JMenuItem("Goal");
		mnHistory.add(mntmGoal);
		
		JMenuItem mntmDiet_1 = new JMenuItem("Diet");
		mnHistory.add(mntmDiet_1);
		
		JMenuItem mntmExercise_2 = new JMenuItem("Exercise");
		mnHistory.add(mntmExercise_2);
		
		JMenu mnTrackInfo = new JMenu("Track Info");
		menuBar.add(mnTrackInfo);
		
		JMenuItem mntmPhysicalInfo = new JMenuItem("Physical Info");
		mnTrackInfo.add(mntmPhysicalInfo);
		
		JMenuItem mntmDiet = new JMenuItem("Diet");
		mnTrackInfo.add(mntmDiet);
		
		JMenuItem mntmExercise = new JMenuItem("Exercise");
		mnTrackInfo.add(mntmExercise);
		
		JMenu mnNewMenu_1 = new JMenu("Recommendations");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmRecommendations = new JMenuItem("Diet");
		mnNewMenu_1.add(mntmRecommendations);
		
		JMenuItem mntmExercise_1 = new JMenuItem("Exercise");
		mnNewMenu_1.add(mntmExercise_1);
		
		Container container = frmStart.getContentPane();
		GridBagLayout gbl = new GridBagLayout();
		container.setLayout(gbl);
		//														 x, y, w, h, wx, wy
		//addComponent(container, gbl, new JButton(), 	     1, 0, 3, 1, 1.0, 1.0);
		//addComponent(container, gbl, new bmiPanel(20.5), 	     1, 0, 3, 1, 1.0, 1.0);
		//addComponent(container, gbl, new SelectPanel(),  		 0, 1, 1, 4, 1.0, 1.0);
		addComponent(container, gbl, new DataDisplayContainer(), 0,1,1,4,1.0,1.0);//1, 1, 4, 4, 1.0, 1.0);
		//addComponent(frmStart, gbl, , 0, 0, 2, 1, 1.0, 1.0);
		
		frmStart.pack();
		frmStart.validate();

	}
	
	static void addComponent(Container cont, GridBagLayout gbl, Component c, int x, int y, int width, int height, double weightx, double weighty){
		GridBagConstraints gdc = new GridBagConstraints();
		gdc.fill = GridBagConstraints.BOTH;
		gdc.gridx = x;
		gdc.gridy = y;
		gdc.gridwidth = width;
		gdc.gridheight = height;
		gdc.weightx = weightx;
		gdc.weighty = weighty;
		gbl.setConstraints(c, gdc);
		cont.add(c);
	}

}
