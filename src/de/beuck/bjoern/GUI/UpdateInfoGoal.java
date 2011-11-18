package de.beuck.bjoern.GUI;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class UpdateInfoGoal extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public UpdateInfoGoal() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblError = new JLabel("Error");
		add(lblError);
		
		JLabel lblDesc = new JLabel("Desc");
		add(lblDesc);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblGoal = new JLabel("Goal");
		
		JRadioButton rdbtnLoose = new JRadioButton("loose#");
		
		JRadioButton rdbtnMain = new JRadioButton("main");
		
		JRadioButton rdbtnBuild = new JRadioButton("build");
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(lblGoal);
		panel_1.add(rdbtnLoose);
		panel_1.add(rdbtnMain);
		panel_1.add(rdbtnBuild);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JLabel lblEndDate = new JLabel("End date");
		panel_3.add(lblEndDate);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JLabel lblGoal_1 = new JLabel("Goal");
		panel_4.add(lblGoal_1);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblKg = new JLabel(" kg");
		panel_4.add(lblKg);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_5);
		
		JButton btnSubmit = new JButton("Submit");
		panel_5.add(btnSubmit);

	}

}
