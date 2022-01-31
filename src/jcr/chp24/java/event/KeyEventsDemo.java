package jcr.chp24.java.event;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KeyEventsDemo extends Frame implements KeyListener{
	String msg = " ";
	String keyState = " ";
	
	public KeyEventsDemo() {
		//key listener is listening to the default
		//but window listener is being overrided by a manual class
		addKeyListener(this);
		addWindowListener(new MyWindowAdapter2());
	}
	
	//implementing most of the methods from our interface
	public void keyPressed(KeyEvent ke) {
		keyState = "Key Down";
		
		int key = ke.getKeyCode();
		switch(key) {
		case KeyEvent.VK_F1:
			msg += "<F1>";
			break;
			
		case KeyEvent.VK_F2:
			msg += "<F2>";
			break;
			
		case KeyEvent.VK_F3:
			msg += "<F3>";
			break;
			
		case KeyEvent.VK_PAGE_DOWN:
			msg += "<PgDn";
			break;
			
		case KeyEvent.VK_PAGE_UP:
			msg += "<PgUp>";
			break;
			
		case KeyEvent.VK_LEFT:
			msg += "<Left Arrow>";
			break;
			
		case KeyEvent.VK_RIGHT:
			msg += "<Right Arrow>";
			break;
			
		}
		repaint();
	}
	
	public void keyReleased(KeyEvent ke) {
		keyState = "Key Up";
		repaint();
	}
	
	public void keyTyped(KeyEvent ke) {
		msg += ke.getKeyChar();
		repaint();
	}
	
	//this is for Frame class
	public void paint (Graphics g) {
		g.drawString(msg, 20 , 100);
		g.drawString(keyState, 20, 50);
	}

	public static void main(String[] args) {
		KeyEventsDemo appwin = new KeyEventsDemo();
		
		appwin.setSize(new Dimension(200, 150));
		appwin.setTitle("KeyEventsDemo");
		appwin.setVisible(true);
	
	}

}

class MyWindowAdapter2 extends WindowAdapter{
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	}
}
