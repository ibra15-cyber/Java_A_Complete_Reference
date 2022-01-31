package jcr.chp25.java.awt;

import java.awt.*;
import java.awt.event.*;

public class OneGraphicsDemo extends Frame {
	
	OneGraphicsDemo(){
		
		addWindowListener(new WindowAdapter() {
			//the anonymous class implements a method
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
		
		//an abstract method inherited to overriden
		public void paint(Graphics g) {
			
			//draw lines
			g.drawLine(20,  40, 100, 90);
			g.drawLine(20,  90, 100, 40);
			g.drawLine(40,  45, 250, 80);
//			
//			//draw rectangles
			g.drawRect(20, 150, 60, 50);
			g.fillRect(110, 150, 60, 50);
			g.drawRoundRect(200, 150, 60, 50, 15, 15);
			g.fillRoundRect(290, 150, 60, 50, 30, 40);
			
//			//draw ellipse
			g.drawOval(20,  250, 50, 50);
			g.fillOval(100, 250, 75, 50);
			g.drawOval(200, 260, 100, 40);
		
//			//draw arcs
			g.drawArc(20, 350, 70, 70, 0, 180);
			g.fillArc(70, 350, 70, 70, 0, 75);
			
//			//draw a polygon
			int[] xpoints = {20, 200, 20, 200, 20};
			int[] ypoints = {450, 450, 650, 650, 450};
			int num = 5;
			
			g.drawPolygon(xpoints, ypoints, num);
//		
	}

	public static void main(String[] args) {
		OneGraphicsDemo appwin = new OneGraphicsDemo();
		
		appwin.setSize(new Dimension(370, 700));
		appwin.setTitle("Graphics Demo");
		appwin.setVisible(true);
	
	}

}
