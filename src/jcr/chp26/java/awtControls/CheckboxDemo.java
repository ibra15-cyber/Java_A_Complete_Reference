package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class CheckboxDemo extends Frame implements ItemListener {
	//FIELDS
	String msg = "";
	Checkbox windows;
	Checkbox android;
	Checkbox solaris;
	Checkbox mac;
	
	//CONSTRUCTOR
	CheckboxDemo(){
		setLayout(new FlowLayout());
		
		windows = new Checkbox("Windows", true); //will be checked by default
		android = new Checkbox("android");
		solaris = new Checkbox("solaris");
		mac= new Checkbox("mac os");
		
		add(windows);
		add(android);
		add(solaris);
		add(mac);
		
		windows.addItemListener(this);
		android.addItemListener(this);
		mac.addItemListener(this);
		solaris.addItemListener(this);
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	//OTHER METHODS ABSTRACT TO OVERRIDE
	
	//abstract itemstatechanged from item listener interface
	//here it means when an item is toggle change state
	public void itemStateChanged(ItemEvent ie) {
		repaint();
	}
	
	//abstract method from frame
	//we are using the getState to track the above method
	public void paint(Graphics g) {
		msg = "Current state: " ;
		g.drawString(msg, 20,  120);
		
		msg = "		Windows: " + windows.getState();
		g.drawString(msg, 20, 140);
		
		msg = "		Android: " + android.getState();
		g.drawString(msg, 20, 160);
		
		msg = "		Solaris: " + solaris.getState();
		g.drawString(msg, 20, 180);
		
		msg = "		mac OS: " + mac.getState();
		g.drawString(msg, 20, 200);
		
	}
	
	

	public static void main(String[] args) {
		CheckboxDemo appwin = new CheckboxDemo();
		
		appwin.setSize(new Dimension(240, 220));
		appwin.setTitle("CheckeBoxDemo");
		appwin.setVisible(true);

	}

}
