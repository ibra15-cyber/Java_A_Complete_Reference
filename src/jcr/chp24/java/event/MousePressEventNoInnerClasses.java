package jcr.chp24.java.event;

import java.awt.*;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MousePressEventNoInnerClasses  extends Frame{
String msg = "";
	
	public MousePressEventNoInnerClasses(){
		addMouseListener(new MyMouseAdapter5(this));
		addWindowListener(new MyWindowAdpter5());
	}
	
	public void paint (Graphics g) {
		g.drawString(msg, 20, 100);
	}

	public static void main(String[] args) {
			
		MousePressEventNoInnerClasses appwin = new MousePressEventNoInnerClasses();
		
		appwin.setSize(new Dimension(200, 150));
		appwin.setTitle("MousePressedDemo");
		appwin.setVisible(true);	

	}

}

//we got two classes one that extends mouse adapter

class MyMouseAdapter5 extends MouseAdapter{
	MousePressEventNoInnerClasses mousePressedDemo;
	
	MyMouseAdapter5(MousePressEventNoInnerClasses mousePressedDemo){
		this.mousePressedDemo  = mousePressedDemo;
	}
	
	public void mousePressed(MouseEvent me) {
		mousePressedDemo.msg = "Mouse Pressed";
		mousePressedDemo.repaint();
	}
}

//another that extends window adapter to close 
class MyWindowAdpter5 extends WindowAdapter{
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	}
}
