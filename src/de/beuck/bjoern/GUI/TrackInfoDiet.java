package de.beuck.bjoern.GUI;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import de.beuck.bjoern.lang.LanguageExecption;
import de.beuck.bjoern.lang.LocationManager;

import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;

public class TrackInfoDiet extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	private ResourceBundle langStrings = null;
	/**
	 * Create the panel.
	 * @throws LanguageExecption 
	 */
	public TrackInfoDiet(Locale language) throws LanguageExecption {
		LocationManager locMan = LocationManager.getInstance();
		langStrings = locMan.loadWindowLanguageStringsResource("TrackinInfo", language);
		
		
		setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel lblError = new JLabel("Error");
		add(lblError);
		
		JLabel lblDescription = new JLabel(langStrings.getString("tp_di_desc"));
		add(lblDescription);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(1, 4, 0, 0));
		
		JLabel lblStartDate = new JLabel(langStrings.getString("tp_di_startDate"));
		panel.add(lblStartDate);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		JLabel lblEndDate = new JLabel(langStrings.getString("tp_di_endDate"));
		panel.add(lblEndDate);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblTrackingType = new JLabel(langStrings.getString("tp_di_typ"));
		panel_1.add(lblTrackingType);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox(langStrings.getString("tp_di_nutrition"));
		panel_2.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox(langStrings.getString("tp_di_recommend"));
		panel_2.add(chckbxNewCheckBox_1);
		
		JLabel lblTrackingView = new JLabel(langStrings.getString("tp_di_trackingView"));
		panel_1.add(lblTrackingView);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 0, 0, 0));
		
		JRadioButton rdbtnGraph = new JRadioButton(langStrings.getString("tp_di_graph"));
		panel_3.add(rdbtnGraph);
		
		JRadioButton rdbtnTable = new JRadioButton(langStrings.getString("tp_di_table"));
		panel_3.add(rdbtnTable);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_6);
		
		JButton btnNewButton = new JButton(langStrings.getString("tp_di_button"));
		panel_6.add(btnNewButton);

	}

}
