package de.beuck.bjoern;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class PreferencesProgramm extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public PreferencesProgramm() {
		setLayout(new GridLayout(2,1));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JLabel lblEmail = new JLabel("E-Mail");
		panel_4.add(lblEmail);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		JLabel lblLanguage = new JLabel("Language");
		panel_4.add(lblLanguage);
		
		JComboBox comboBox = new JComboBox();
		panel_4.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Password");
		panel_2.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		panel_2.add(passwordField);
		
		JLabel lblUnit = new JLabel("Unit");
		panel_2.add(lblUnit);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_2.add(comboBox_1);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JLabel lblBirthday = new JLabel("Birthday");
		panel_6.add(lblBirthday);
		
		textField_1 = new JTextField();
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JLabel lblGender = new JLabel("Gender");
		panel_7.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		panel_7.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		panel_7.add(rdbtnFemale);

	}

}
