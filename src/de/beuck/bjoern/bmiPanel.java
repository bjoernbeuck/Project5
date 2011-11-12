package de.beuck.bjoern;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JPanel;

public class bmiPanel extends Frame {

	private static final long serialVersionUID = -6211019038447300250L;
	private Image background = null;
	private double bmiValue;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bmiPanel frame = new bmiPanel(25.7);
		frame.addWindowListener(new WindowClosingAdapter(true));
		frame.pack();
		frame.setVisible(true);

	}

	public bmiPanel(double bmiWert){
		this.bmiValue = bmiWert;
		background = getToolkit().getImage("./Resourcen/bmi.png");
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(background, 0);
		try{
			mt.waitForAll();
		}catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

	@Override
	public void paint(Graphics g) {
		
		g.drawImage(background, 0, 0, this);
		double winkel = (bmiValue - 17) * 10;
		int x = (int)(background.getWidth(this) * Math.sin(winkel));
		int y = (int)(background.getWidth(this) * Math.cos(winkel));
		g.drawLine(x,y,background.getWidth(this) / 2, background.getHeight(this));
		super.paint(g);
	}

	@Override
	public Dimension getMinimumSize() {
		return new Dimension(background.getWidth(this), background.getHeight(this));
	}

	@Override
	public Dimension getPreferredSize() {
		
		return new Dimension(background.getWidth(this), background.getHeight(this));
	}

	public double getBmiValue() {
		return bmiValue;
	}

	public void setBmiValue(double bmiValue) {
		this.bmiValue = bmiValue;
	}
	
	
	
	
}
