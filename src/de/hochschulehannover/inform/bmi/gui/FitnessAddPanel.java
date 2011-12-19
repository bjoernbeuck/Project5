package de.hochschulehannover.inform.bmi.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;



/**
 * @author Jan Prodöhl
 */
public class FitnessAddPanel extends JPanel implements ActionListener{
	
	public FitnessAddPanel(){
		initComponents();
		refillTable();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jan Prodöhl
		//ResourceBundle bundle = ResourceBundle.getBundle("resources.GUIMessages");
		panel1 = new JPanel();
		splitPane1 = new JSplitPane();
		panel2 = new JPanel();
		scrollPane1 = new JScrollPane();
		tblEaten = new JTable();
		labHead = new JLabel();
		buttEarlier = new JButton();
		labDate = new JLabel();
		buttLater = new JButton();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		textField1 = new JTextField();
		comboBox1 = new JComboBox();
		textField2 = new JTextField();
		label5 = new JLabel();
		slider1 = new JSlider();
		button1 = new JButton();

		//======== panel1 ========
		{

//			// JFormDesigner evaluation mark
//			panel1.setBorder(new javax.swing.border.CompoundBorder(
//				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


			//======== splitPane1 ========
			{
				splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);

				//======== panel2 ========
				{

					GroupLayout panel2Layout = new GroupLayout(panel2);
					panel2.setLayout(panel2Layout);
					panel2Layout.setHorizontalGroup(
						panel2Layout.createParallelGroup()
							.addGap(0, 538, Short.MAX_VALUE)
					);
					panel2Layout.setVerticalGroup(
						panel2Layout.createParallelGroup()
							.addGap(0, 1, Short.MAX_VALUE)
					);
				}
				splitPane1.setTopComponent(panel2);

				//======== scrollPane1 ========
				{
					scrollPane1.setViewportView(tblEaten);
				}
				splitPane1.setBottomComponent(scrollPane1);
			}

			//---- labHead ----
			labHead.setText("What did you do today?");
			labHead.setFont(labHead.getFont().deriveFont(labHead.getFont().getStyle() | Font.BOLD));

			//---- buttEarlier ----
			buttEarlier.setText("Earlier");

			//---- labDate ----
			labDate.setText("Today");

			//---- buttLater ----
			buttLater.setText("Later");

			//---- label1 ----
			label1.setText("Select an Activity");

			//---- label2 ----
			label2.setText("Number of Reps/Sets, if applicable");

			//---- label3 ----
			label3.setText("Timeframe");

			//---- label4 ----
			label4.setText("How intense was your workout?");

			//---- textField1 ----
			textField1.setText("0");
			
			this.comboBox1.insertItemAt("Sample Fitness One", 0);
			this.comboBox1.insertItemAt("Sample Fitness Two", 1);
			comboBox1.setSelectedIndex(0);
			
			Hashtable labelTable = new Hashtable();
			labelTable.put( new Integer( 0 ), new JLabel("Light") );
			labelTable.put( new Integer( 1 ), new JLabel("Moderate") );
			labelTable.put( new Integer( 2 ), new JLabel("Intense") );
			slider1.setLabelTable(labelTable);
			slider1.setValueIsAdjusting(false);

			//---- label5 ----
			label5.setText("Minutes");

			//---- slider1 ----
			slider1.setMaximum(2);
			slider1.setValue(1);
			slider1.setPaintLabels(true);
			slider1.setPaintTicks(true);
			slider1.setSnapToTicks(true);

			//---- button1 ----
			button1.setText("Add");

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
					.addGroup(panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(label2)
							.addComponent(label1)
							.addComponent(label3)
							.addComponent(label4))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(slider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(panel1Layout.createSequentialGroup()
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
									.addComponent(textField2)
									.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(label5)))
						.addContainerGap(95, Short.MAX_VALUE))
					.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(button1)
							.addGroup(panel1Layout.createSequentialGroup()
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
									.addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
										.addComponent(labHead, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(234, 234, 234))
									.addGroup(panel1Layout.createSequentialGroup()
										.addComponent(buttEarlier)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(labDate)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(buttLater)))
						.addGap(25, 25, 25))
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
							.addComponent(label1)
							.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label2)
							.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label3)
							.addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label5))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(label4)
							.addComponent(slider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(9, 9, 9)
						.addComponent(button1)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
			);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		this.setLayout(new BorderLayout());
		
		this.button1.setActionCommand("add");
		button1.addActionListener(this);
		
		
		this.add(this.panel1);
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jan Prodöhl
	private JPanel panel1;
	private JSplitPane splitPane1;
	private JPanel panel2;
	private JScrollPane scrollPane1;
	private JTable tblEaten;
	private JLabel labHead;
	private JButton buttEarlier;
	private JLabel labDate;
	private JButton buttLater;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextField textField1;
	private JComboBox comboBox1;
	private JTextField textField2;
	private JLabel label5;
	private JSlider slider1;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	ArrayList<String[]> history;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (history == null) history = new ArrayList<String[]>();
		history.add(new String[]{this.comboBox1.getSelectedItem().toString(),
			this.textField2.getText(),
			this.textField1.getText()});
		refillTable();
	}
	
	private void refillTable(){
		Object columnNames[] = { "Activity",
				"Timeframe in Minutes",
				"Reps/Sets"};
		Object[][] obj;
		if (history == null){
			obj = new Object[0][3];
		}
		else {
			obj = new Object[history.size()][3];
			for (int i = 0; i < history.size(); i++){
				obj[i][0] = history.get(i)[0];
				obj[i][1] = history.get(i)[1];
				obj[i][2] = history.get(i)[2];
			}
		}
		this.tblEaten = new JTable(obj, columnNames);
		scrollPane1.setViewportView(tblEaten);
		this.splitPane1.setBottomComponent(scrollPane1);
	}
}
