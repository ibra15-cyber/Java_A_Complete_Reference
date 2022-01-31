package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

//implementing ActionListener and not ItemListener
public class ListDemo extends Frame implements ActionListener {
	//FIELDS
	String msg = "";
//	Checkbox windows;
//	Checkbox android;
//	Checkbox solaris;
//	Checkbox mac;
	List os;
	List browser;
	
	//CONSTRUCTOR
	ListDemo(){
		
		setLayout(new FlowLayout());
		
		//multiselection list
		os = new List(4, true);
		//single selection
		browser = new List(4);
		
		//os infront because we got two different classes os and browser
		os.add("windows");
		os.add("android");
		os.add("solaris");
		os.add("mac");
		
		//that of browser
		browser.add("Internet Explorer");
		browser.add("firefox");
		browser.add("chrome");
		browser.add("opera");
		
		//make initial selection
		browser.select(1);
		os.select(0);
		
		//finally adding to the window
		//so we have to group them 
		//before adding on the window
		add(os);
		add(browser);
		
		//add action listener but not add item listener
		os.addActionListener(this);
		browser.addActionListener(this);
		
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	//OTHER METHODS ABSTRACT TO OVERRIDE
	
	//abstract actionPerformed but not itemstatechanged from item listener interface
	//here it means when an item is toggle change state
	public void actionPerformed(ActionEvent ae) {
		repaint();
	}
	
	//abstract method from frame
	//we are using the getState to track the above method
	public void paint(Graphics g) {
		int[] idx;
		
		msg = "Current OS: " ;
		idx = os.getSelectedIndexes();
		for (int i = 0; i<idx.length; i++)
			msg += os.getItem(idx[i]) + " ";
		g.drawString(msg, 6,  120);
		
		msg = "Current Browser: " ;
		msg += browser.getSelectedItem();
		g.drawString(msg, 6,  140);
		
		
	
	}

	public static void main(String[] args) {
		ListDemo appwin = new ListDemo();
		
		appwin.setSize(new Dimension(500, 500));
		appwin.setTitle("ListDemo with Selection");
		appwin.setVisible(true);

	}

}
