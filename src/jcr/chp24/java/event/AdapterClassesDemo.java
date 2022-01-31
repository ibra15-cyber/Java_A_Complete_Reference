package jcr.chp24.java.event;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class AdapterClassesDemo  extends Frame{
		String msg = " ";
		
	    AdapterClassesDemo() {
	    	//if mouse adapter was implemented
	    	//we will have used 
	    	//addMouseLister(this)
	    	//but since it is created and implemented in a diff class
	    	//we create an instance o fthat class
			addMouseListener(new MyMouseAdapter3(this));
			addMouseMotionListener(new MyMouseAdapter3(this));
			addWindowListener(new MyWindowAdapter()); //this doesnt have a constructor
		}
		
	    //from the extended fram class
		public void paint(Graphics g) {
			g.drawString(msg, 20, 80);
		}

	public static void main(String[] args) {
		AdapterClassesDemo appwin = new AdapterClassesDemo();
		
		appwin.setSize(new Dimension(200, 150));
		appwin.setTitle("AdapterClassesDemo");
		appwin.setVisible(true);
		
	}

}

class MyMouseAdapter3 extends MouseAdapter{
	AdapterClassesDemo adapterDemo;
	
	public MyMouseAdapter3(AdapterClassesDemo adapterDemo) {
		this.adapterDemo = adapterDemo;
	}
	
	public void mouseClicked(MouseEvent me) {
		adapterDemo.msg = "Mouse clicked";
		adapterDemo.repaint();
	}
	
	public void mouseDragged(MouseEvent me) {
		adapterDemo.msg = "Mouse dragged";
		adapterDemo.repaint();
	}
}	


class MyWindowAdapter3 extends WindowAdapter{
	
		public void windowClosing(WindowEvent we) {
			System.exit(0);
	}
}
