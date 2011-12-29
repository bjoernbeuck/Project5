package de.hochschulehannover.inform.bmi.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



/**
 * @author Jan Prodöhl
 */
public class WeightUpdatePanel extends JPanel implements ActionListener{
	GUIcontrol _guiControl;
	
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 3499790404230077408L;
	public WeightUpdatePanel() {
		_guiControl = GUIcontrol.getInstance();
		initComponents();
		fillComponents();
	}
	
	private void fillComponents(){
		refresh();
	}
	
	/**
	 * This is evil, but I am tired
	 */
	public void refresh(){
		incDate(0);
		label2.setText(this._guiControl.getLastWeightInfo());
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jan Prodöhl
		//ResourceBundle bundle = ResourceBundle.getBundle("resources.GUIMessages");
		panel1 = new JPanel();
		labHead = new JLabel();
		labNewWeight = new JLabel();
		txtWeight = new JTextField();
		buttUpdate = new JButton();
		buttEarlier = new JButton();
		labDate = new JLabel();
		buttLater = new JButton();
		label1 = new JLabel();
		label2 = new JLabel();

		//======== panel1 ========
		{

			// JFormDesigner evaluation mark
//			panel1.setBorder(new javax.swing.border.CompoundBorder(
//				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			//---- txtWeight ----
			txtWeight.setActionCommand("update");
			txtWeight.addActionListener(this);

			//---- labHead ----
			labHead.setText(this._guiControl.getLocalizedString("what_is_your_current_weight"));
			labHead.setFont(labHead.getFont().deriveFont(labHead.getFont().getStyle() | Font.BOLD));

			//---- labNewWeight ----
			labNewWeight.setText(this._guiControl.getLocalizedString("new_weight"));

			//---- buttUpdate
			buttUpdate.setText(this._guiControl.getLocalizedString("gui.update"));
			buttUpdate.setActionCommand("update");
			buttUpdate.addActionListener(this);

			//---- buttEarlier ----
			buttEarlier.setText(this._guiControl.getLocalizedString("gui.earlier"));
			buttEarlier.setActionCommand("earlier");
			buttEarlier.addActionListener(this);

			//---- labDate ----
			labDate.setText(this._guiControl.getLocalizedString("gui.today"));

			//---- buttLater ----
			buttLater.setText(this._guiControl.getLocalizedString("gui.later"));
			buttLater.setActionCommand("later");
			buttLater.addActionListener(this);

			//---- label1 ----
			label1.setText(this._guiControl.getLocalWeightUnit());

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel1Layout.createParallelGroup()
							.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
									.addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
										.addComponent(labHead, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
										.addGap(234, 234, 234))
									.addGroup(panel1Layout.createSequentialGroup()
										.addComponent(buttEarlier)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(labDate)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(buttLater))
							.addGroup(panel1Layout.createSequentialGroup()
								.addComponent(labNewWeight)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtWeight, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(label1)
								.addGap(18, 18, 18)
								.addComponent(buttUpdate))
							.addComponent(label2))
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
						.addComponent(label2)
						.addGap(18, 18, 18)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(labNewWeight)
							.addComponent(txtWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label1)
							.addComponent(buttUpdate))
						.addContainerGap(143, Short.MAX_VALUE))
			);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		this.setLayout(new BorderLayout());
		this.add(this.panel1);
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jan Prodöhl
	private JPanel panel1;
	private JLabel labHead;
	private JLabel labNewWeight;
	private JTextField txtWeight;
	private JButton buttUpdate;
	private JButton buttEarlier;
	private JLabel labDate;
	private JButton buttLater;
	private JLabel label1;
	private JLabel label2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("earlier".equals(e.getActionCommand())) incDate(-1);
		if ("later".equals(e.getActionCommand())) incDate(1);
		if ("update".equals(e.getActionCommand())) updateWeight();
	}
	
	private void updateWeight() {
		double newWeight;
		try{
			// TODO NumberFormat localizer
			newWeight = Double.parseDouble(this.txtWeight.getText());
		} catch (NumberFormatException e){
			_guiControl.showError(_guiControl.getLocalizedString("Error.enter_number"));
			return;
		}
		if (newWeight <= 1) {
			_guiControl.showError(_guiControl.getLocalizedString("Error.enter_positive_number"));
			return;
		}
		_guiControl.addWeight(newWeight);
		this.refresh();
	}

	private void incDate(int days){
		//FIXME too much logic here
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(_guiControl.getWorkingDate());
		cal.add(java.util.Calendar.DATE, days);
		if (_guiControl.isToday(cal.getTime()) >= 0)
			this.buttLater.setEnabled(false);
		else this.buttLater.setEnabled(true);
		_guiControl.setWorkingDate(cal.getTime());
		this.labDate.setText(_guiControl.getLocalizedStringFromDate(_guiControl.getWorkingDate()));
	}
	
	
}
