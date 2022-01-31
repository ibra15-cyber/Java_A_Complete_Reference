package jcr.chp24.java.event;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//here we are craming all the interface into the main
//so we will be able to call this in our constructor instead of creating an instance of a created class
public class  MouseEventsDemo extends Frame
		implements MouseListener, MouseMotionListener{
	
	String msg = " ";
	int mouseX = 0;
	int mouseY = 0;
	
	public MouseEventsDemo(){
		//this means we aint overriding any of the methods
		//hence we usign the default, which we extended or implemented
		//to make the addWindowListener take this, implement its class inside our main class
		//but java doesnt support multiple inheritance
		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(new MyWindowAdapter());
		
	}
	
	//implementing our mouse listerner interface methods
	public void mouseClicked(MouseEvent me) {
		msg = msg + " -- click recieved";
		repaint();
	}
	
	public void mouseEntered(MouseEvent me) {
		mouseX = 100;
		mouseY = 100;
		msg = "Mouse entered.";
		repaint();
	}
	
	public void mouseExited(MouseEvent me) {
		mouseX = 100;
		mouseY = 100;
		msg = "Mouse exited.";
		repaint();
	}
	
	public void mousePressed(MouseEvent me) {
		mouseX = me.getX();
		mouseY = me.getY();
		msg = "Button down";
		repaint();
	}
	
	public void mouseReleased(MouseEvent me) {
		mouseX = me.getX();
		mouseY = me.getY();
		msg = "Button Released";
		repaint();
	}
	
	public void mouseDragged(MouseEvent me) {
		mouseX = me.getX()	;
		mouseY = me.getY();
		msg = "*" + " mouse at " + mouseX + ", " + mouseY;
		repaint();
	}
	
	public void mouseMoved(MouseEvent me) {
		msg  = "Moving mouse at " + me.getX() + ", " + me.getY();
		repaint();
	}
	
	//this one is from our frame class
	public void paint(Graphics g) {
		g.drawString(msg, mouseX, mouseY);
	}
	

	public static void main(String[] args) {
		MouseEventsDemo appwin = new MouseEventsDemo();
		
		appwin.setSize(new Dimension(300, 300));
		appwin.setTitle("MouseEventsDemo");
		appwin.setVisible(true);
	}
}

// a class that extends window adapter  and overides the window closing method
class MyWindowApter extends WindowAdapter{
	
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	}
}
		