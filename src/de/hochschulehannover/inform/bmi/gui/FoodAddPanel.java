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
public class FoodAddPanel extends JPanel implements ActionListener{
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	public FoodAddPanel() {
		_guiControl = GUIcontrol.getInstance();
		initComponents();
		fillComponents();
	}
	
	private void fillComponents() {
		this.txtBreakfastAmount.setText("1");
		this.txtLunchAmount.setText("1");
		this.txtDinnerAmount.setText("1");
		this.txtSnacksAmount.setText("0");
		
		for (int i = 0; i < _guiControl.getUnits().length; i++){
		this.cmbBreakfastUnit.insertItemAt(_guiControl.getUnits()[i], i);
		this.cmbLunchUnit.insertItemAt(_guiControl.getUnits()[i], i);
		this.cmbDinnerUnit.insertItemAt(_guiControl.getUnits()[i], i);
		this.cmbSnacksUnit.insertItemAt(_guiControl.getUnits()[i], i);
		}
		this.cmbBreakfastUnit.setSelectedIndex(0);
		this.cmbLunchUnit.setSelectedIndex(0);
		this.cmbDinnerUnit.setSelectedIndex(0);

		
		for (int i = 0; i < _guiControl.getAllFoodItems().length; i++){
			this.cmbBreakfastItem.insertItemAt(_guiControl.getAllFoodItems()[i].getName(), i);
			this.cmbLunchItem.insertItemAt(_guiControl.getAllFoodItems()[i].getName(), i);
			this.cmbDinnerItem.insertItemAt(_guiControl.getAllFoodItems()[i].getName(), i);
			this.cmbSnacksItem.insertItemAt(_guiControl.getAllFoodItems()[i].getName(), i);
		}
		
		buttEarlier.setActionCommand("earlier");
		buttEarlier.addActionListener(this);
		
		buttLater.setActionCommand("later");
		buttLater.addActionListener(this);
		buttLater.setEnabled(false);
		
		this.refillTable();
	}

	static GUIcontrol _guiControl;

	private void initComponents() {
		
		this.setLayout(new BorderLayout());
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jan Prodöhl
		//ResourceBundle _guiControl = ResourceBundle.getBundle("resources.GUIMessages");
		panel1 = new JPanel();
		splitPane1 = new JSplitPane();
		panel2 = new JPanel();
		scrollPane1 = new JScrollPane();
		tblEaten = new JTable();
		labHead = new JLabel();
		labBreakfast = new JLabel();
		labLunch = new JLabel();
		labDinner = new JLabel();
		labSnacks = new JLabel();
		txtBreakfastAmount = new JTextField();
		txtLunchAmount = new JTextField();
		txtDinnerAmount = new JTextField();
		txtSnacksAmount = new JTextField();
		cmbBreakfastUnit = new JComboBox();
		cmbLunchUnit = new JComboBox();
		cmbDinnerUnit = new JComboBox();
		cmbSnacksUnit = new JComboBox();
		cmbBreakfastItem = new JComboBox();
		cmbLunchItem = new JComboBox();
		cmbDinnerItem = new JComboBox();
		cmbSnacksItem = new JComboBox();
		buttBreakfastAdd = new JButton();
		buttLunchAdd = new JButton();
		buttDinnerAdd = new JButton();
		buttSnacksAdd = new JButton();
		buttEarlier = new JButton();
		labDate = new JLabel();
		buttLater = new JButton();

		//======== panel1 ========
		{

			// JFormDesigner evaluation mark
//			panel1.setBorder(new javax.swing.border.CompoundBorder(
//				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


			//======== splitPane1 ========
			{
				splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
				splitPane1.setEnabled(false);

				//======== panel2 ========
				{

					GroupLayout panel2Layout = new GroupLayout(panel2);
					panel2.setLayout(panel2Layout);
					panel2Layout.setHorizontalGroup(
						panel2Layout.createParallelGroup()
							.addGap(0, 530, Short.MAX_VALUE)
					);
					panel2Layout.setVerticalGroup(
						panel2Layout.createParallelGroup()
							.addGap(0, 0, Short.MAX_VALUE)
					);
				}
				splitPane1.setTopComponent(panel2);

				//======== scrollPane1 ========
				{
					//scrollPane1.setViewportView(new JButton());
					//scrollPane1.add(tblEaten);
				}
				splitPane1.setBottomComponent(tblEaten);
				//splitPane1.setBottomComponent(new JButton());
			}

			//---- labHead ----
			labHead.setText(_guiControl.getLocalizedString("FoodAddPanel.labHead"));
			labHead.setFont(labHead.getFont().deriveFont(labHead.getFont().getStyle() | Font.BOLD));

			//---- labBreakfast ----
			labBreakfast.setText(_guiControl.getLocalizedString("FoodAddPanel.labBreakfast"));

			//---- labLunch ----
			labLunch.setText(_guiControl.getLocalizedString("FoodAddPanel.labLunch"));

			//---- labDinner ----
			labDinner.setText(_guiControl.getLocalizedString("FoodAddPanel.labDinner"));

			//---- labSnacks ----
			labSnacks.setText(_guiControl.getLocalizedString("FoodAddPanel.labSnacks"));

			//---- buttBreakfastAdd ----
			buttBreakfastAdd.setText(_guiControl.getLocalizedString("FoodAddPanel.buttAdd"));

			//---- buttLunchAdd ----
			buttLunchAdd.setText(_guiControl.getLocalizedString("FoodAddPanel.buttAdd"));

			//---- buttDinnerAdd ----
			buttDinnerAdd.setText(_guiControl.getLocalizedString("FoodAddPanel.buttAdd"));

			//---- buttSnacksAdd ----
			buttSnacksAdd.setText(_guiControl.getLocalizedString("FoodAddPanel.buttAdd"));

			//---- buttEarlier ----
			buttEarlier.setText(_guiControl.getLocalizedString("FoodAddPanel.buttEarlier"));

			//---- labDate ----
			labDate.setText(_guiControl.getLocalizedStringFromWorkingDate());

			//---- buttLater ----
			buttLater.setText(_guiControl.getLocalizedString("FoodAddPanel.buttLater"));
			
			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
					.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
								.addComponent(labHead, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(234, 234, 234))
							.addGroup(panel1Layout.createSequentialGroup()
								.addGroup(panel1Layout.createParallelGroup()
									.addComponent(labBreakfast)
									.addComponent(labLunch)
									.addComponent(labDinner)
									.addComponent(labSnacks))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel1Layout.createParallelGroup()
									.addGroup(panel1Layout.createSequentialGroup()
										.addComponent(txtSnacksAmount, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(cmbSnacksUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(cmbSnacksItem, 0, 232, Short.MAX_VALUE))
									.addGroup(panel1Layout.createSequentialGroup()
										.addComponent(txtDinnerAmount, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(cmbDinnerUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(cmbDinnerItem, 0, 232, Short.MAX_VALUE))
									.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
										.addGroup(panel1Layout.createParallelGroup()
											.addGroup(panel1Layout.createSequentialGroup()
												.addComponent(txtBreakfastAmount, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(cmbBreakfastUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(panel1Layout.createSequentialGroup()
												.addComponent(txtLunchAmount, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(cmbLunchUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGap(18, 18, 18)
										.addGroup(panel1Layout.createParallelGroup()
											.addComponent(cmbLunchItem, 0, 232, Short.MAX_VALUE)
											.addComponent(cmbBreakfastItem, 0, 232, Short.MAX_VALUE)
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
								.addComponent(buttLunchAdd))
							.addGroup(panel1Layout.createSequentialGroup()
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(buttBreakfastAdd))
							.addGroup(panel1Layout.createSequentialGroup()
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(buttDinnerAdd))
							.addGroup(panel1Layout.createSequentialGroup()
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(buttSnacksAdd)))
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
							.addComponent(labBreakfast)
							.addComponent(txtBreakfastAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cmbBreakfastUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cmbBreakfastItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttBreakfastAdd))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(labLunch)
							.addComponent(txtLunchAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cmbLunchUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cmbLunchItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttLunchAdd))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(labDinner)
							.addComponent(txtDinnerAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cmbDinnerUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cmbDinnerItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttDinnerAdd))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(labSnacks)
							.addComponent(txtSnacksAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cmbSnacksUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cmbSnacksItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttSnacksAdd))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
			);
			
			this.add(panel1);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jan Prodöhl
	private JPanel panel1;
	private JSplitPane splitPane1;
	private JPanel panel2;
	private JScrollPane scrollPane1;
	private JTable tblEaten;
	private JLabel labHead;
	private JLabel labBreakfast;
	private JLabel labLunch;
	private JLabel labDinner;
	private JLabel labSnacks;
	private JTextField txtBreakfastAmount;
	private JTextField txtLunchAmount;
	private JTextField txtDinnerAmount;
	private JTextField txtSnacksAmount;
	private JComboBox cmbBreakfastUnit;
	private JComboBox cmbLunchUnit;
	private JComboBox cmbDinnerUnit;
	private JComboBox cmbSnacksUnit;
	private JComboBox cmbBreakfastItem;
	private JComboBox cmbLunchItem;
	private JComboBox cmbDinnerItem;
	private JComboBox cmbSnacksItem;
	private JButton buttBreakfastAdd;
	private JButton buttLunchAdd;
	private JButton buttDinnerAdd;
	private JButton buttSnacksAdd;
	private JButton buttEarlier;
	private JLabel labDate;
	private JButton buttLater;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("earlier".equals(e.getActionCommand())) incDate(-1);
		if ("later".equals(e.getActionCommand())) incDate(1);
	}
	
	private void incDate(int days){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_guiControl.getWorkingDate());
		cal.add(Calendar.DATE, days);
		if (_guiControl.isToday(cal.getTime()) >= 0)
			this.buttLater.setEnabled(false);
		else this.buttLater.setEnabled(true);
		_guiControl.setWorkingDate(cal.getTime());
		this.labDate.setText(_guiControl.getLocalizedStringFromWorkingDate());
	}
	
	private void refillTable(){
Object columnNames[] = { _guiControl.getLocalizedString("FoodAddPanel.tableAmount"),
		_guiControl.getLocalizedString("FoodAddPanel.tableUnit"),
		_guiControl.getLocalizedString("FoodAddPanel.tableFood")};
		this.tblEaten = new JTable(_guiControl.getHistoryTable(_guiControl.getWorkingDate()), columnNames);
		
		scrollPane1.setViewportView(tblEaten);
		this.splitPane1.setBottomComponent(scrollPane1);
		//this.revalidate();
	}
}


