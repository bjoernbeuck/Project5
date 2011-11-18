package de.beuck.bjoern.GUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class RecommendationExercise extends JPanel {
	private JTable tbl_Exercise;

	/**
	 * Create the panel.
	 */
	public RecommendationExercise() {
		setLayout(new BorderLayout(0, 0));
		
		tbl_Exercise = new JTable();
		add(tbl_Exercise, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("WeeklyGoal");
		panel.add(lblNewLabel);
		
		JLabel lblNewexercisedesc = new JLabel("newExerciseDesc");
		panel.add(lblNewexercisedesc);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1);
		
		JButton btnGenerateNewSet = new JButton("Generate New Set");
		panel_1.add(btnGenerateNewSet);

	}

}
