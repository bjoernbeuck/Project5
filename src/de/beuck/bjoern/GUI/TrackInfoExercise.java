package de.beuck.bjoern.GUI;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;

import de.beuck.bjoern.lang.LanguageExecption;
import de.beuck.bjoern.lang.LocationManager;

public class TrackInfoExercise extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	private ResourceBundle langStrings = null;
	/**
	 * Create the panel.
	 * @throws LanguageExecption 
	 */
	public TrackInfoExercise(Locale language) throws LanguageExecption {
		LocationManager locMan = LocationManager.getInstance();
		langStrings = locMan.loadWindowLanguageStringsResource("TrackinInfo", language);
		
		setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel lblError = new JLabel("Error");
		add(lblError);
		
		JLabel lblDesription = new JLabel(langStrings.getString("td_ex_desc"));
		add(lblDesription);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblStartDate = new JLabel(langStrings.getString("td_ex_startDate"));
		panel.add(lblStartDate);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblEndDate = new JLabel(langStrings.getString("td_ex_endDate"));
		panel.add(lblEndDate);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblTrackingType = new JLabel(langStrings.getString("td_ex_typ"));
		panel_3.add(lblTrackingType);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 0, 0, 0));
		
		JCheckBox chckbxFrequency = new JCheckBox(langStrings.getString("td_ex_frequency"));
		panel_4.add(chckbxFrequency);
		
		JCheckBox chckbxQuantity = new JCheckBox(langStrings.getString("td_ex_quantity"));
		panel_4.add(chckbxQuantity);
		
		JCheckBox chckbxAvgCaloriesBurned = new JCheckBox(langStrings.getString("td_ex_avgCal"));
		panel_4.add(chckbxAvgCaloriesBurned);
		
		JLabel lblTrackingView = new JLabel(langStrings.getString("td_ex_trackingView"));
		panel_3.add(lblTrackingView);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));
		
		JRadioButton rdbtnGraph = new JRadioButton(langStrings.getString("td_ex_graph"));
		panel_5.add(rdbtnGraph);
		
		JRadioButton rdbtnTable = new JRadioButton(langStrings.getString("td_ex_table"));
		panel_5.add(rdbtnTable);
		
		JPanel panel_6 = new JPanel();
		add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnSubmit = new JButton(langStrings.getString("td_ex_button"));
		panel_6.add(btnSubmit);

	}

}
