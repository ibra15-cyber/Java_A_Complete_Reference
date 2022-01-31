package jcr.chp24.java.event;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MousePressEventInnerClasses extends Frame {
	String msg = "";
	
	MousePressEventInnerClasses(){
		addMouseListener(new MyMouseAdapter4(this));
		addWindowListener(new MyWindowAdapter4());
	}
	
	public void paint (Graphics g) {
		g.drawString(msg, 20, 100);
	}

	public static void main(String[] args) {
		MousePressEventInnerClasses appwin = new MousePressEventInnerClasses();
		
		appwin.setSize(new Dimension(200, 150));
		appwin.setTitle("MousePressedDemo");
		appwin.setVisible(true);	
	}

}

class MyMouseAdapter4 extends MouseAdapter{
	MousePressEventInnerClasses mousePressedDemo;
	
	MyMouseAdapter4(MousePressEventInnerClasses mousePressedDemo){
		this.mousePressedDemo = mousePressedDemo;
	}
	
	public void mousePressed(MouseEvent me) {
		mousePressedDemo.msg = "Mouse Pressed";
		mousePressedDemo.repaint();
	}
}


class MyWindowAdapter4 extends WindowAdapter{
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	}
}
