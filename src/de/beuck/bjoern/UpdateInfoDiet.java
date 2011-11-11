package de.beuck.bjoern;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class UpdateInfoDiet extends JPanel {

	/**
	 * Create the panel.
	 */
	public UpdateInfoDiet() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblNewLabel = new JLabel("error");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblDesc = new JLabel("desc");
		panel_1.add(lblDesc);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JLabel lblFoodIdem = new JLabel("Food Idem");
		panel_2.add(lblFoodIdem);
		
		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblMetricServingsize = new JLabel("Metric ServingSize");
		panel_3.add(lblMetricServingsize);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		JLabel lblOfServingsizes = new JLabel("# of Servingsizes eaten");
		panel_4.add(lblOfServingsizes);
		
		JSpinner spinner = new JSpinner();
		panel_4.add(spinner);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		JLabel lblSubmitNewFood = new JLabel("Submit new food");
		panel_5.add(lblSubmitNewFood);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		
		JButton btnSubmit = new JButton("Submit#");
		panel_6.add(btnSubmit);

	}

}
