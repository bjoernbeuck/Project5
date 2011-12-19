package de.hochschulehannover.inform.bmi.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;



/**
 * @author Jan Prodöhl
 */
public class WeightUpdatePanel extends JPanel implements ActionListener{
	
	public WeightUpdatePanel() {
		GUIcontrol _guiControl = GUIcontrol.getInstance();
		initComponents();
		//fillComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jan ProdÃ¶hl
		//ResourceBundle bundle = ResourceBundle.getBundle("resources.GUIMessages");
		panel1 = new JPanel();
		labHead = new JLabel();
		labBreakfast = new JLabel();
		txtBreakfastAmount = new JTextField();
		buttBreakfastAdd = new JButton();
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


			//---- labHead ----
			labHead.setText("What is you current weight?");
			labHead.setFont(labHead.getFont().deriveFont(labHead.getFont().getStyle() | Font.BOLD));

			//---- labBreakfast ----
			labBreakfast.setText("New Weight");

			//---- buttBreakfastAdd ----
			buttBreakfastAdd.setText("Update");

			//---- buttEarlier ----
			buttEarlier.setText("Earlier");

			//---- labDate ----
			labDate.setText("Today");

			//---- buttLater ----
			buttLater.setText("Later");

			//---- label1 ----
			label1.setText("kg");

			//---- label2 ----
			label2.setText("Last Weight: 80 kg (yesterday)");

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
								.addComponent(labBreakfast)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtBreakfastAmount, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(label1)
								.addGap(18, 18, 18)
								.addComponent(buttBreakfastAdd))
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
							.addComponent(labBreakfast)
							.addComponent(txtBreakfastAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label1)
							.addComponent(buttBreakfastAdd))
						.addContainerGap(143, Short.MAX_VALUE))
			);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		this.setLayout(new BorderLayout());
		this.add(this.panel1);
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jan ProdÃ¶hl
	private JPanel panel1;
	private JLabel labHead;
	private JLabel labBreakfast;
	private JTextField txtBreakfastAmount;
	private JButton buttBreakfastAdd;
	private JButton buttEarlier;
	private JLabel labDate;
	private JButton buttLater;
	private JLabel label1;
	private JLabel label2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
