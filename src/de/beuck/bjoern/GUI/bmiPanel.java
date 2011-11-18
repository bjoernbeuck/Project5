package de.beuck.bjoern.GUI;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class bmiPanel extends Frame {

	private static final long serialVersionUID = -6211019038447300250L;
	private Image background = null;
	private Image pointer = null;
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
		pointer = getToolkit().getImage("./Resourcen/bmiPointer.png");
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(background, 0);
		mt.addImage(pointer, 0);
		try{
			mt.waitForAll();
		}catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		//BufferedImage pic = new BufferedImage(pointer.getWidth(this) , pointer.getHeight(this), pointer);
		
	}

	@Override
	public void paint(Graphics g) {
		
		g.drawImage(background, getInsets().left, getInsets().top, this);
		int offset = (getWidth() / 2) -  (pointer.getWidth(this) / 2);
		int hoehe = getHeight() - (pointer.getHeight(this) - 40);
		//BufferedImage buf = rotateImage(pointer, 43.0);
		g.drawImage(pointer, offset, hoehe, this);
		super.paint(g);
	}

	@Override
	public Dimension getMinimumSize() {
		Insets border = getInsets();
		int widths = border.left + border.right;
		int height = border.top + border.bottom;
		return new Dimension(background.getWidth(this) + widths, background.getHeight(this) + height);
	}

	@Override
	public Dimension getPreferredSize() {
		Insets border = getInsets();
		int widths = border.left + border.right;
		int height = border.top + border.bottom;
		return new Dimension(background.getWidth(this) + widths, background.getHeight(this) + height);
	}

	public double getBmiValue() {
		return bmiValue;
	}

	public void setBmiValue(double bmiValue) {
		this.bmiValue = bmiValue;
	}
	
	private double getAngleForPicture(){
		
		return 0;
	}
	
	
	//Code von http://www.java-forum.org/spiele-multimedia-programmierung/34398-2d-projektil-flugbahn.html#post217467
	
	public BufferedImage rotateImage(Image inputImage, double angle) {

	    //Eckpunkte des Ursprungsbildes
	    Point a = new Point(0,0);
	    Point b = new Point(inputImage.getWidth(this),0);
	    Point c = new Point(0,inputImage.getHeight(this));
	    Point d = new Point(inputImage.getWidth(this),inputImage.getHeight(this));
	    
	    //Eckpunkte nach Rotation
	    Point newA = drehe(a, angle);
	    Point newB = drehe(b, angle);
	    Point newC = drehe(c, angle);
	    Point newD = drehe(d, angle);
	    
	    //berechne minimal umschliessendes Rechteck
	    int X = Math.max(Math.max(newA.x, newB.x), Math.max(newC.x, newD.x)) - Math.min(Math.min(newA.x, newB.x), Math.min(newC.x, newD.x)); 
	    int Y = Math.max(Math.max(newA.y, newB.y), Math.max(newC.y, newD.y)) - Math.min(Math.min(newA.y, newB.y), Math.min(newC.y, newD.y));
	    
	    //Zwischenspeicherbild
	    BufferedImage tempRI = new BufferedImage(2*X, 2*Y, BufferedImage.TYPE_INT_ARGB);
	    //Neues Bild in der benötigten Größe
	    BufferedImage RI = new BufferedImage(X, Y, BufferedImage.TYPE_INT_ARGB);
	    
	    AffineTransform af = AffineTransform.getRotateInstance(angle, X/2, Y/2);
	    Graphics2D g = tempRI.createGraphics();
	    //Male das Ursprungsbild in die Mitte des Zwischenspeicherbildes
	    g.drawImage(inputImage, X-inputImage.getWidth(this)/2, Y-inputImage.getHeight(this)/2, null);
	    Graphics2D g2 = RI.createGraphics();
	    //Male das Zwischenspeicherbild auf das Endbild und drehe es dann
	    g2.setTransform(af);
	    g2.drawImage(tempRI, -X/2, -Y/2, null);
	    g.dispose();
	    g2.dispose();
	    return RI;
	  }
	  
	  public BufferedImage rotateImage(BufferedImage inputImage, int deltaX, int deltaY) {
		  double rotArc = Math.asin(Math.abs(deltaY)/Math.sqrt(deltaX*deltaX+deltaY*deltaY));
			if (deltaY<0 && deltaX>0)
				rotArc = Math.PI/2 - rotArc;
			else if (deltaY>0 && deltaX>0)
				rotArc += Math.PI/2;
			else if (deltaY>0 && deltaX<0)
				rotArc = 1.5*Math.PI-rotArc;
			else if (deltaY<0 && deltaX<0)
				rotArc += 1.5*Math.PI;
			else if (deltaX==0 && deltaY<0)
				rotArc = 0;
			else if (deltaX==0 && deltaY>0)
				rotArc = Math.PI;
			else if (deltaY==0 && deltaX>0)
				rotArc = Math.PI/2; 
			else if (deltaY==0 && deltaX<0)
				rotArc = 1.5*Math.PI;  
			
			return rotateImage(inputImage, rotArc);
	  
	  }
	  
	  private static Point drehe(Point p, double angle) {
		  Point pnew = new Point(0,0);
		  pnew.x = (int)(p.x*Math.cos(angle)-p.y*Math.sin(angle));
		  pnew.y = (int)(p.x*Math.sin(angle)+p.y*Math.cos(angle));
		  return pnew;
	  }
	
	
}
