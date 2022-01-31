package jcr.chp24.java.event;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SimpleKeyEvent extends Frame implements KeyListener {
	String msg = " ";
	String keyState = " ";
	
	public  SimpleKeyEvent() {
		//this because the constructor implemented the keylistener 
		//instead of calling it from another class. be it inner or independent class
		addKeyListener(this);
		addWindowListener((WindowListener) new MyWindowAdapter());
	}
	
	public void keyPressed(KeyEvent ke) {
		keyState = "Key Down";
		repaint();
	}
	
	public void keyReleased(KeyEvent ke) {
		keyState = "Key Up";
		repaint();
	}
	

	public void keyTyped(KeyEvent ke) {
		msg  += ke.getKeyChar();
		repaint();
	}
	
	public void paint(Graphics g) {
		g.drawString(msg, 20, 100);
		g.drawString(keyState, 20, 50);
	}
	
	public static void main(String[] args) {
		
		SimpleKeyEvent appwin = new SimpleKeyEvent()	;
		
		appwin.setSize(new Dimension(200, 150));
		appwin.setTitle("SimpleKey");
		appwin.setVisible(true);
		}
}

class MyWindowAdapter extends WindowAdapter{
	public void windowCloasing(WindowEvent we) {
		System.exit(0);
	}
}
