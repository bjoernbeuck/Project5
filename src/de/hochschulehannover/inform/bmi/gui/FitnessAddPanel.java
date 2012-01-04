package de.hochschulehannover.inform.bmi.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

import org.apache.log4j.Logger;



/**
 * @author Jan Prodöhl
 */
public class FitnessAddPanel extends JPanel implements ActionListener{
	
	/**
	 * Logger!
	 */
	private static Logger _LOGGER = Logger.getLogger(FitnessAddPanel.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4515939951152027875L;
	GUIcontrol _guiControl;
	
	public FitnessAddPanel(){
		_guiControl = GUIcontrol.getInstance();
		initComponents();
		fillComponents();
		refresh();
	}
	
	private void fillComponents() {
		try{
			for (int i = 0; i < _guiControl.getActivities().size(); i++){
				this.cmbActivities.insertItemAt(_guiControl.getActivities().get(i).getName(), i);
			}
			if (cmbActivities.getItemCount() == 0){
				_guiControl.showError(_guiControl.getLocalizedString("Error.cannot_load"+
				"_list_of_activities") + "\n" + _guiControl.getLocalizedString(
				"Error.list_is_empty"));
				_LOGGER.error("List of activities is empty.");
				return;
			}
			cmbActivities.setSelectedIndex(0);
		} catch (java.lang.NullPointerException e){
			_guiControl.showError(_guiControl.getLocalizedString("Error.cannot_load"+
					"_list_of_activities") + "\n" + _guiControl.getLocalizedString(
							"Error.list_is_empty"));
			_LOGGER.error(e.getMessage());
		} 
	}

	public void refresh(){
		incDate(0);
		refillTable();
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
		this.refillTable();
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
		txtRepsOrSets = new JTextField();
		cmbActivities = new JComboBox();
		txtTime = new JTextField();
		label5 = new JLabel();
		sldIntensity = new JSlider();
		buttAdd = new JButton();

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
			labHead.setText(_guiControl.getLocalizedString("what_did_you_do_today"));
			labHead.setFont(labHead.getFont().deriveFont(labHead.getFont().getStyle() | Font.BOLD));

			//---- buttEarlier ----
			buttEarlier.setText(_guiControl.getLocalizedString("gui.earlier"));
			buttEarlier.setActionCommand("earlier");
			buttEarlier.addActionListener(this);

			//---- labDate ----
			labDate.setText(_guiControl.getLocalizedString("gui.today"));

			//---- buttLater ----
			buttLater.setText(_guiControl.getLocalizedString("gui.later"));
			buttLater.setActionCommand("later");
			buttLater.addActionListener(this);

			//---- label1 ----
			label1.setText(_guiControl.getLocalizedString("select_an_activity"));

			//---- label2 ----
			label2.setText(_guiControl.getLocalizedString("number_of_reps_sets_if_applicable"));

			//---- label3 ----
			label3.setText(_guiControl.getLocalizedString("timeframe"));

			//---- label4 ----
			label4.setText(_guiControl.getLocalizedString("how_intense_was_your_workout"));

			//---- textField1 ----
			//textField1.setText("0");
			this.txtTime.setText("5");
			
			
			
			Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
			labelTable.put( new Integer( 0 ), new JLabel(_guiControl.getLocalizedString("light")) );
			labelTable.put( new Integer( 1 ), new JLabel(_guiControl.getLocalizedString("moderate")) );
			labelTable.put( new Integer( 2 ), new JLabel(_guiControl.getLocalizedString("intense")) );
			sldIntensity.setLabelTable(labelTable);
			sldIntensity.setValueIsAdjusting(false);

			//---- label5 ----
			label5.setText(_guiControl.getLocalizedString("minutes"));

			//---- slider1 ----
			sldIntensity.setMaximum(2);
			sldIntensity.setValue(1);
			sldIntensity.setPaintLabels(true);
			sldIntensity.setPaintTicks(true);
			sldIntensity.setSnapToTicks(true);

			//---- button1 ----
			buttAdd.setText(_guiControl.getLocalizedString("gui.add"));

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
							.addComponent(cmbActivities, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(sldIntensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(panel1Layout.createSequentialGroup()
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
									.addComponent(txtTime)
									.addComponent(txtRepsOrSets, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(label5)))
						.addContainerGap(95, Short.MAX_VALUE))
					.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(buttAdd)
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
							.addComponent(cmbActivities, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label2)
							.addComponent(txtRepsOrSets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label3)
							.addComponent(txtTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label5))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(label4)
							.addComponent(sldIntensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(9, 9, 9)
						.addComponent(buttAdd)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
			);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		this.setLayout(new BorderLayout());
		
		this.buttAdd.setActionCommand("add");
		buttAdd.addActionListener(this);
		
		
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
	private JTextField txtRepsOrSets;
	private JComboBox cmbActivities;
	private JTextField txtTime;
	private JLabel label5;
	private JSlider sldIntensity;
	private JButton buttAdd;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("earlier".equals(e.getActionCommand())) incDate(-1);
		if ("later".equals(e.getActionCommand())) incDate(1);
		if ("add".equals(e.getActionCommand())) addFitness();
	}
	
	private void addFitness() {
		//if (history == null) history = new ArrayList<String[]>();
		//history.add(new String[]{this.comboBox1.getSelectedItem().toString(),
		//		this.textField2.getText(),
		//		this.textField1.getText()});
		if (this.cmbActivities.getSelectedIndex() < 0){
			_guiControl.showError(_guiControl.getLocalizedString("Error.no_item_selected"));
			return;
		}
		int reps = -1;
		if (!txtRepsOrSets.getText().trim().equals("")){
			try{
				reps = Integer.parseInt(this.txtRepsOrSets.getText());
			} catch (NumberFormatException e){
				_guiControl.showError(_guiControl.getLocalizedString("Error.enter_number"));
				return;
			}
			if (reps < 1) {
				_guiControl.showError(_guiControl.getLocalizedString("Error.enter_at_least_one"));
				return;
			}
		}
		
		int timeframe = -1;
		//if (!.getText().trim().equals("")){
		try{
			timeframe = Integer.parseInt(this.txtTime.getText());
		} catch (NumberFormatException e){
			_guiControl.showError(_guiControl.getLocalizedString("Error.enter_number"));
			return;
		}
		if (timeframe < 1) {
			_guiControl.showError(_guiControl.getLocalizedString("Error.enter_at_least_one"));
			return;
		}
		//}
		_guiControl.addActivity(_guiControl.getActivities().get(cmbActivities.getSelectedIndex()),
				reps, timeframe, this.sldIntensity.getValue());
		refillTable();
	}

	private void refillTable(){
		Object columnNames[] = { _guiControl.getLocalizedString("activity"),
				_guiControl.getLocalizedString("timeframe_in_minutes"),
						_guiControl.getLocalizedString("reps_sets")};
		this.tblEaten = new JTable(_guiControl.getActivityHistoryTable(_guiControl.getWorkingDate()), columnNames);
		scrollPane1.setViewportView(tblEaten);
		this.splitPane1.setBottomComponent(scrollPane1);
	}
}
