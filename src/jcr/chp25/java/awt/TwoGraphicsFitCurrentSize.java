package jcr.chp25.java.awt;

import java.awt.*;
import java.awt.event.*;

public class TwoGraphicsFitCurrentSize extends Frame {
	final int inc = 25;
	int max = 500;
	int min = 200;
	Dimension d;
	
	//constructor
	TwoGraphicsFitCurrentSize()	{
		
		//first method
		//our event method is listening for an anonymous class
		//with a method to implement the same class
		addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent me) {
				//this will work when mouse is released
				//if the dimension d  + our inc > max, return min 
				//else return the width + inc
				int w = (d.width + inc) > max ? min : (d.width + inc); 
				int h =(d.height + inc) > max? min: (d.height + inc);
				setSize(new Dimension(w, h)	);
			}
		});
		
		//second anonymous method
		addWindowListener(new WindowAdapter() {
			
			//anonymous method is overriding a method from the Window Adapter
			//both from the frame
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
		public void paint(Graphics g) {
			//get inset size and dimension size
			//then draw
			//i.left starting x; i.top starting y; 
			Insets i = getInsets();
			d = getSize();
			
			g.drawLine(i.left, i.top, d.width-i.right, d.height-i.bottom);
			g.drawLine(i.left, d.height-i.bottom, d.width-i.right, i.top);
		
		
		}
	
	public static void main(String[] args) {
		TwoGraphicsFitCurrentSize appwin = new TwoGraphicsFitCurrentSize();
		
		appwin.setSize(new Dimension(200, 200));
		appwin.setTitle("ResizeMe");
		appwin.setVisible(true);
		

	}

}
