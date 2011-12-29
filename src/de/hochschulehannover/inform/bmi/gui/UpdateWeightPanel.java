package de.hochschulehannover.inform.bmi.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Dec 11 16:53:25 CET 2011
 */




/**
 * @author Jan Prodöhl
 */
public class UpdateWeightPanel extends JPanel implements ActionListener{
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	public UpdateWeightPanel() {
		_guiControl = GUIcontrol.getInstance();
		initComponents();
		fillComponents();
	}

	private void fillComponents() {
		this.txtWeight.setText("");

		buttEarlier.setActionCommand("earlier");
		buttEarlier.addActionListener(this);

		buttLater.setActionCommand("later");
		buttLater.addActionListener(this);
		buttLater.setEnabled(false);

		this.buttWeightUpdate.setActionCommand("addWeight");
		buttWeightUpdate.addActionListener(this);
	}

	static GUIcontrol _guiControl;

	private void initComponents() {

		this.setLayout(new BorderLayout());
		panel1 = new JPanel();
		labHead = new JLabel();
		labWeight = new JLabel();
		txtWeight = new JTextField();
		labUnit = new JLabel();
		buttWeightUpdate = new JButton();
		buttEarlier = new JButton();
		labDate = new JLabel();
		buttLater = new JButton();



		//---- labHead ----
		labHead.setText(_guiControl.getLocalizedString("UpdateWeightPanel.labHead"));
		labHead.setFont(labHead.getFont().deriveFont(labHead.getFont().getStyle() | Font.BOLD));

		//---- labWeight ----
		labWeight.setText(_guiControl.getLocalizedString("UpdateWeightPanel.labWeight"));

		//---- buttWeightUpdate ----
		buttWeightUpdate.setText(_guiControl.getLocalizedString("UpdateWeightPanel.buttAdd"));

		//---- buttEarlier ----
		buttEarlier.setText(_guiControl.getLocalizedString("UpdateWeightPanel.buttEarlier"));

		//---- labDate ----
		labDate.setText(_guiControl.getLocalizedStringFromDate(_guiControl.getWorkingDate()));

		//---- buttLater ----
		buttLater.setText(_guiControl.getLocalizedString("UpdateWeightPanel.buttLater"));

		GroupLayout panel1Layout = new GroupLayout(panel1);
		panel1.setLayout(panel1Layout);
		panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
				//					.addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
				.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
										.addComponent(labHead, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(234, 234, 234))
										.addGroup(panel1Layout.createSequentialGroup()
												.addGroup(panel1Layout.createParallelGroup()
														.addComponent(labWeight)
														//									.addComponent(labLunch)
														//									.addComponent(labDinner)
														//									.addComponent(labSnacks)
												)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(panel1Layout.createParallelGroup()
														.addGroup(panel1Layout.createSequentialGroup()
																//										.addComponent(txtSnacksAmount, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
//																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																//										.addComponent(cmbSnacksUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//																.addGap(18, 18, 18)
																//										.addComponent(cmbSnacksItem, 0, 232, Short.MAX_VALUE)
														)
														.addGroup(panel1Layout.createSequentialGroup()
																//										.addComponent(txtDinnerAmount, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
//																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																//										.addComponent(cmbDinnerUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//																.addGap(18, 18, 18)
																//										.addComponent(cmbDinnerItem, 0, 232, Short.MAX_VALUE)
														)
														.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
																.addGroup(panel1Layout.createParallelGroup()
																		.addGroup(panel1Layout.createSequentialGroup()
																				.addComponent(txtWeight, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(labUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																				.addGroup(panel1Layout.createSequentialGroup()
																						//												.addComponent(txtLunchAmount, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
//																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																						//												.addComponent(cmbLunchUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																				)
																)
																.addGap(18, 18, 18)
																.addGroup(panel1Layout.createParallelGroup()
																		//											.addComponent(cmbLunchItem, 0, 232, Short.MAX_VALUE)
																		//											.addComponent(cmbBreakfastItem, 0, 232, Short.MAX_VALUE)
																		.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
																				.addComponent(buttEarlier)
																				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(labDate)))))))
																				.addGroup(panel1Layout.createParallelGroup()
																						.addGroup(panel1Layout.createSequentialGroup()
																								.addGap(18, 18, 18)
																								.addComponent(buttLater))
																								.addGroup(panel1Layout.createSequentialGroup()
																										.addGap(12, 12, 12)
																										//								.addComponent(buttLunchAdd)
																								)
																								.addGroup(panel1Layout.createSequentialGroup()
																										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(buttWeightUpdate))
																										.addGroup(panel1Layout.createSequentialGroup()
																												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																												//								.addComponent(buttDinnerAdd)
																										)
																										.addGroup(panel1Layout.createSequentialGroup()
																												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																												//								.addComponent(buttSnacksAdd)
																										))
																										.addContainerGap())
		);
		panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
				.addGroup(panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(labHead)
								.addComponent(buttLater)
								.addComponent(labDate)
								.addComponent(buttEarlier))
								.addGap(18, 18, 18)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(labWeight)
										.addComponent(txtWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(labUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										//							.addComponent(cmbBreakfastItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(buttWeightUpdate))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										//						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										//							.addComponent(labLunch)
										//							.addComponent(txtLunchAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										//							.addComponent(cmbLunchUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										//							.addComponent(cmbLunchItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										//							.addComponent(buttLunchAdd))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										//						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										//							.addComponent(labDinner)
										//							.addComponent(txtDinnerAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										//							.addComponent(cmbDinnerUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										//							.addComponent(cmbDinnerItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										//							.addComponent(buttDinnerAdd))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										//						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										//							.addComponent(labSnacks)
										//							.addComponent(txtSnacksAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										//							.addComponent(cmbSnacksUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										//							.addComponent(cmbSnacksItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										//							.addComponent(buttSnacksAdd))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										//			.addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
				)
		);

		
		this.add(panel1);
		//		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jan Prodöhl
	private JPanel panel1;
	//	private JSplitPane splitPane1;
	//	private JPanel panel2;
	//	private JScrollPane scrollPane1;
	//	private JTable tblEaten;
	private JLabel labHead;
	private JLabel labWeight;
	//	private JLabel labLunch;
	//	private JLabel labDinner;
	//	private JLabel labSnacks;
	private JTextField txtWeight;
	//	private JTextField txtLunchAmount;
	//	private JTextField txtDinnerAmount;
	//	private JTextField txtSnacksAmount;
	private JLabel labUnit;
	//	private JComboBox cmbLunchUnit;
	//	private JComboBox cmbDinnerUnit;
	//	private JComboBox cmbSnacksUnit;
	//	private JComboBox cmbBreakfastItem;
	//	private JComboBox cmbLunchItem;
	//	private JComboBox cmbDinnerItem;
	//	private JComboBox cmbSnacksItem;
	private JButton buttWeightUpdate;
	//	private JButton buttLunchAdd;
	//	private JButton buttDinnerAdd;
	//	private JButton buttSnacksAdd;
	private JButton buttEarlier;
	private JLabel labDate;
	private JButton buttLater;
	// JFormDesigner - End of variables declaration  //GEN-END:variables


	@Override
	public void actionPerformed(ActionEvent e) {
		if ("earlier".equals(e.getActionCommand())) incDate(-1);
		if ("later".equals(e.getActionCommand())) incDate(1);
		//		if ("addBreakfast".equals(e.getActionCommand())) addBreakfast();
		//		if ("addLunch".equals(e.getActionCommand())) addLunch();
		//		if ("addDinner".equals(e.getActionCommand())) addDinner();
		//		if ("addSnack".equals(e.getActionCommand())) addSnack();
	}

	private void incDate(int days){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_guiControl.getWorkingDate());
		cal.add(Calendar.DATE, days);
		if (_guiControl.isToday(cal.getTime()) >= 0)
			this.buttLater.setEnabled(false);
		else this.buttLater.setEnabled(true);
		_guiControl.setWorkingDate(cal.getTime());
		this.labDate.setText(_guiControl.getLocalizedStringFromDate(_guiControl.getWorkingDate()));
	}

	//	private void refillTable(){
	//		Object columnNames[] = { _guiControl.getLocalizedString("UpdateWeightPanel.tableFood"),
	//				_guiControl.getLocalizedString("UpdateWeightPanel.tableMeal"),
	//				_guiControl.getLocalizedString("UpdateWeightPanel.tableAmount")};
	//		this.tblEaten = new JTable(_guiControl.getHistoryTable(_guiControl.getWorkingDate()), columnNames);
	//		scrollPane1.setViewportView(tblEaten);
	//		this.splitPane1.setBottomComponent(scrollPane1);
	//		//this.revalidate();
	//	}

	private void addBreakfast(){
		//		addMeal(this.txtWeight.getText(), this.cmbBreakfastItem.getSelectedIndex(), "Breakfast");
	}

	//	private void addLunch(){
	//		addMeal(this.txtLunchAmount.getText(), this.cmbLunchItem.getSelectedIndex(), "Lunch");
	//	}
	//	
	//	private void addDinner(){
	//		addMeal(this.txtDinnerAmount.getText(), this.cmbDinnerItem.getSelectedIndex(), "Dinner");
	//	}
	//	
	//	private void addSnack(){
	//		addMeal(this.txtSnacksAmount.getText(), this.cmbSnacksItem.getSelectedIndex(), "Snacks");
	//	}
	//	
	private void addMeal(String servings, int itemID, String meal){
		//		if (itemID < 0){
		//			_guiControl.showError(_guiControl.getLocalizedString("Error.no_item_selected"));
		//			return;
		//		}
		//		int iServings = -1;
		//		try{
		//			iServings = Integer.parseInt(servings);
		//		} catch (NumberFormatException e){
		//			_guiControl.showError(_guiControl.getLocalizedString("Error.enter_number"));
		//			return;
		//		}
		//		if (iServings < 1) {
		//			_guiControl.showError(_guiControl.getLocalizedString("Error.enter_at_least_one"));
		//			return;
	}
	//		_guiControl.addMeal(servings, _guiControl.getAllFoodItems().get(itemID), meal, _guiControl.getWorkingDate());
	//		this.refillTable();
	//	}
}


