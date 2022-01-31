package jcr.chp24.java.event;

import java.awt.*;
import java.awt.event.*;
public class UsingAnnonymousMethods extends Frame{
	String msg = "";
	
	UsingAnnonymousMethods()	{
		
		//anonymous inner class  
		//same us calling the method and passing our classes that implement and extend 
		//the super classes
		//or using this if we extend it in this same class but remember we cant 
		//extend or inherit more than one class
		//with this our method is taking anonymous classes
		//and our classes will implement methods
		//anonymous class because its not named 
		//as MouseAdapter ma = new MouseAdapter
		addMouseListener(new MouseAdapter()	{
			
			public void mousePressed(MouseEvent me) {
				msg = "Mouse Pressed";
				repaint();
			}			
		});
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
		
		public void paint(Graphics g) {
			g.drawString(msg, 20, 80);
		}
	
	public static void main(String[] args) {
		UsingAnnonymousMethods appwin = new UsingAnnonymousMethods();
		
		appwin.setSize(new Dimension(200, 150));
		appwin.setTitle("AnonymousInncerClassDemo");
		appwin.setVisible(true);
	}

}
