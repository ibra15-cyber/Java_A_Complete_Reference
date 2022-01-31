package jcr.chp24.java.event;

import java.awt.*;
import java.awt.event.*;

public class UsingInnerClasses extends Frame	{
	String msg = "";
	
	//so anytime we call our constructor to create new object of our class
	//our methods are passed it automatically to listen to whatever there is to
	public UsingInnerClasses() {
		addMouseListener(new MyMouseAdapter6());
		addMouseMotionListener(new MyMouseMotionAdapter6());
		addWindowListener(new MyWindowAdapter6());
	}
	
	//inner classes
	class MyMouseMotionAdapter6 extends MouseMotionAdapter{
		
		public void mouseDragged(MouseMotionAdapter moe) {
			msg = "mouse dragged";
			repaint();
			
		}
	}
	class MyMouseAdapter6 extends MouseAdapter{
		
		public void mousePressed(MouseEvent me) {
			msg = "Mouse Pressed";
			repaint();
		}
	}
	
	//inner class 2 for window adapter
	class MyWindowAdapter6 extends WindowAdapter{
		
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	}
	
	//overide method in the main class from the frame
	public void paint(Graphics g) {
		g.drawString(msg, 20	, 80);
	}

	public static void main(String[] args) {
		UsingInnerClasses appwin = new UsingInnerClasses();
		
		appwin.setSize(new Dimension(200, 150));
		appwin.setTitle("InnerClassDemo");
		appwin.setVisible(true);
		
		

	}

}
