package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class ChoiceDemo extends Frame implements ItemListener {
	//FIELDS
	String msg = "";
//	Checkbox windows;
//	Checkbox android;
//	Checkbox solaris;
//	Checkbox mac;
	Choice os;
	Choice browser;
	
	//CONSTRUCTOR
	ChoiceDemo(){
		
		setLayout(new FlowLayout());
		
		os = new Choice();
		browser = new Choice();
		
		//os infront because we got two different classes os and browser
		os.add("windows");
		os.add("android");
		os.add("solaris");
		os.add("mac");
		
		//that of browser
		browser.add("Internet Explorer");
		browser.add("firefox");
		browser.add("chrome");
		
		//finally adding to the window
		//so we have to group them 
		//before adding on the window
		add(os);
		add(browser);
		
		os.addItemListener(this);
		browser.addItemListener(this);
		
		
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
		msg = "Current OS: " ;
		msg += os.getSelectedItem();
		g.drawString(msg, 20,  120);
		
		msg = "Current Browser: " ;
		msg += browser.getSelectedItem();
		g.drawString(msg, 20,  140);
		
		
	
	}

	public static void main(String[] args) {
		ChoiceDemo appwin = new ChoiceDemo();
		
		appwin.setSize(new Dimension(500, 500));
		appwin.setTitle("CheckBoxGroup or RadioButton");
		appwin.setVisible(true);

	}

}
