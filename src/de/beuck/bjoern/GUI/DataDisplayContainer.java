package de.beuck.bjoern.GUI;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.xml.crypto.Data;

import de.beuck.bjoern.data.DataCombinatedHistory;
import de.beuck.bjoern.data.DataProvider;
import de.hochschulehannover.inform.bmi.DataDummy;

public class DataDisplayContainer extends JPanel {

	private static Vector<DataCombinatedHistory> datas = new Vector<DataCombinatedHistory>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataDummy.createDatas();
		DataProvider provider = DataProvider.getInstance();
		datas = provider.getData();

		JFrame frame = new JFrame();
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(new DataDisplayContainer());
		frame.add(scroll);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public DataDisplayContainer(){
		JPanel content = new JPanel();
		content.setDoubleBuffered(true);
		content.setLayout(new GridLayout(datas.size(), 1));
		DataDisplayPanel diplay = DataDisplayPanel.getInstace(2000);
		for(DataCombinatedHistory buf : datas){
			
			content.add(diplay.getDisplay(buf.get_bmiTrend(), buf.get_date(), buf.get_weight(), buf.get_bmi(), buf.get_Kcal()));
		}
		add(content);
	
	}

}
