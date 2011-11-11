package de.beuck.bjoern;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class UpdateInfoExercise extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public UpdateInfoExercise() {
		setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblErroro = new JLabel("Erroro");
		panel.add(lblErroro);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblDesc = new JLabel("Desc");
		panel_1.add(lblDesc);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JLabel lblExercise = new JLabel("Exercise");
		panel_2.add(lblExercise);
		
		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Intensy");
		panel_4.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("light");
		panel_4.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnModerate = new JRadioButton("Moderate#");
		panel_4.add(rdbtnModerate);
		
		JRadioButton rdbtnIntense = new JRadioButton("Intense");
		panel_4.add(rdbtnIntense);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblDatePerformed = new JLabel("Date Performed");
		panel_5.add(lblDatePerformed);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		
		textField = new JTextField();
		panel_6.add(textField);
		textField.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lblTimeStarted = new JLabel("Time started");
		panel_7.add(lblTimeStarted);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		
		JSpinner spinner = new JSpinner();
		panel_8.add(spinner);
		
		JLabel lblTimeEnded = new JLabel("Time Ended");
		panel_7.add(lblTimeEnded);
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		
		JSpinner spinner_1 = new JSpinner();
		panel_9.add(spinner_1);
		
		JPanel panel_10 = new JPanel();
		add(panel_10);
		panel_10.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12);
		panel_12.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Add new Exercise");
		panel_12.add(lblNewLabel_1);
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_13.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_12.add(panel_13);
		
		JButton btnAdd = new JButton("Add");
		panel_13.add(btnAdd);
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11);
		
		JButton btnSubmit = new JButton("Submit");
		panel_11.add(btnSubmit);

	}

}
