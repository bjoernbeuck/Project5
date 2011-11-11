package de.beuck.bjoern;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Main {

	private JFrame frmStart;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStart = new JFrame();
		frmStart.setTitle("Start");
		frmStart.setBounds(100, 100, 647, 499);
		frmStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		
		frmStart.add(new TrackInfo(Locale.ENGLISH), BorderLayout.CENTER);
	}

}
