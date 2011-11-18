package de.beuck.bjoern.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.net.URL;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import de.beuck.bjoern.data.BmiTrendKonstants;
import net.java.dev.transparentlayout.*;

public class DataDisplayPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -757972780228420563L;
	/**
	 * Create the panel.
	 */
	
	public static int BMI_UP = 0;
	public static int BMI_DOWN = 1;
	public static int DMI_NEUTRAL = 2;
	private String fileNames[] = {"smilyHappy.png", "smilyNotHappy.png", "smilyNeutral.png"};
	private Icon icons[] = null;
	private static DataDisplayPanel instance = null;
	private static int defaultKCal = 2000;
	
	public static DataDisplayPanel getInstace(int defaultKCal){
		//this.defaultKCal = defaultKCal;
		if(instance == null) {
			instance = new DataDisplayPanel();
		}
		return instance;
	}
	
	private void preloadBMITrendIcons(){
		icons = new Icon[fileNames.length];
		int i = 0;
		for(String file : fileNames){
			URL res = DataDisplayPanel.class.getResource("./../Resourcen/" + file);
			icons[i] = new ImageIcon(res);
			i++;
		}
	}
	
	private DataDisplayPanel(){
		preloadBMITrendIcons();
	}
	
	public DataDisplay getDisplay(BmiTrendKonstants bmiTrend, Date date, double weight, double bmi, int kcal){
		return new DataDisplay(bmiTrend, date, weight, bmi,  kcal);
	}
	
	
	public class DataDisplay extends JPanel{
		private BmiTrendKonstants bmiTrend;
		private Date date;
		private double weight, bmi;
		private int kCal;
		private Dimension dim = new Dimension(100,70);
		
		public DataDisplay(BmiTrendKonstants bmiTrend, Date date, double weight, double bmi, int kcal){
			this.bmiTrend = bmiTrend;
			this.date = date;
			this.weight = weight;
			this.bmi = bmi;
			this.kCal = kcal;
		}
		
		@Override
		public void paint(Graphics g) {
			int offset = 20;
			int xPos = 10;
			int iconHeight = 0;
			
			setLayout(new TransparentLayout());
			JLabel lblPicture = new JLabel("Picture");
			if(BmiTrendKonstants.bmi_down == bmiTrend){
				lblPicture.setIcon(icons[1]);
				iconHeight = icons[1].getIconHeight();
			}
			else if(BmiTrendKonstants.bmi_equal == bmiTrend){
				lblPicture.setIcon(icons[2]);
				iconHeight = icons[2].getIconHeight();
			}
			else if(BmiTrendKonstants.bmi_up == bmiTrend){
				lblPicture.setIcon(icons[0]);
				iconHeight = icons[0].getIconHeight();
			}
			xPos = lblPicture.getPreferredSize().width + offset;
			add(lblPicture, new Point(10, 5));
			
			JLabel lblDate = new JLabel("Date: " + date.toLocaleString());
			add(lblDate, new Point(xPos, 10));
	
			JProgressBar progressBar = new JProgressBar();
			progressBar.setMaximum(defaultKCal);
			progressBar.setMinimum(0);
			progressBar.setValue(kCal);
			add(progressBar, new Point(xPos, 40));
			xPos += lblDate.getPreferredSize().width + offset;
			
			JLabel lblWeight = new JLabel("Weight: " + weight);
			add(lblWeight, new Point(xPos, 10));
			xPos += lblWeight.getPreferredSize().width + offset;
			
			JLabel lblBmi = new JLabel("BMI: " + bmi);
			add(lblBmi, new Point(xPos, 10));
			xPos += lblBmi.getPreferredSize().width + offset; 
			
			this.dim = new Dimension(xPos, iconHeight + 10);
			super.paint(g);
		}


		@Override
		public Dimension getMinimumSize() {
			return dim;
		}

		@Override
		public Dimension getPreferredSize() {
			return dim;
		}
		
		
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DataDisplayPanel frm = DataDisplayPanel.getInstace(2000);
		
		frame.getContentPane().add(frm.getDisplay(BmiTrendKonstants.bmi_up, new Date(), 82.5, 22.89, 500));
		frame.pack();
		frame.setVisible(true);
	}

}
