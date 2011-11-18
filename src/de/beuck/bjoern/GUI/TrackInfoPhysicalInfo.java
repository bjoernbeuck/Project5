package de.beuck.bjoern.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import de.beuck.bjoern.lang.LanguageExecption;
import de.beuck.bjoern.lang.LocationManager;

public class TrackInfoPhysicalInfo extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private ResourceBundle langStrings = null;

	/**
	 * Create the panel.
	 * @throws LanguageExecption 
	 */
	public TrackInfoPhysicalInfo(Locale language) throws LanguageExecption {
		LocationManager locMan = LocationManager.getInstance();
		langStrings = locMan.loadWindowLanguageStringsResource("TrackinInfo", language);
		setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Error");
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(langStrings.getString("td_pi_desc"));
		add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblNewLabel_2 = new JLabel(langStrings.getString("td_pi_startDate"));
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel(langStrings.getString("td_pi_endDate"));
		panel.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblTrackingType = new JLabel(langStrings.getString("td_pi_typ"));
		panel_1.add(lblTrackingType);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JCheckBox chckbxWeight = new JCheckBox(langStrings.getString("td_pi_weight"));
		panel_2.add(chckbxWeight);
		
		JCheckBox chckbxGoalWeight = new JCheckBox(langStrings.getString("td_pi_goalWeight"));
		panel_2.add(chckbxGoalWeight);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox(langStrings.getString("td_pi_bmi"));
		panel_2.add(chckbxNewCheckBox);
		
		JLabel lblTrackingView = new JLabel(langStrings.getString("td_pi_trackingView"));
		panel_1.add(lblTrackingView);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 0, 0, 0));
		
		JRadioButton rdbtnGraph = new JRadioButton(langStrings.getString("td_pi_graph"));
		panel_3.add(rdbtnGraph);
		
		JRadioButton rdbtnTable = new JRadioButton(langStrings.getString("td_pi_Table"));
		panel_3.add(rdbtnTable);
		
		JButton btnSubmit = new JButton(langStrings.getString("td_pi_button"));
		add(btnSubmit);

	}

}
