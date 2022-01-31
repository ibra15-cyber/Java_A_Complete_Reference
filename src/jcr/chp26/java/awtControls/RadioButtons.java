package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class RadioButtons extends Frame implements ItemListener {
	//FIELDS
	String msg = "";
	Checkbox windows;
	Checkbox android;
	Checkbox solaris;
	Checkbox mac;
	CheckboxGroup cbg;
	
	//CONSTRUCTOR
	RadioButtons(){
		cbg = new CheckboxGroup();
		setLayout(new FlowLayout());
		
		//creation of radio button must take a name similar to all  other objects 
		//in the same group
		//only one will be selected  
		//you can decide to selected non
		windows = new Checkbox("Windows", cbg, true); //will be checked by default
		android = new Checkbox("android" , cbg, false); 
		solaris = new Checkbox("solaris", cbg, false);
		mac= new Checkbox("mac os", cbg, false);
		
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
		msg = "Current selection: " ;
		msg += cbg.getSelectedCheckbox()	.getLabel();
		g.drawString(msg, 20,  120);
	
	}

	public static void main(String[] args) {
		RadioButtons appwin = new RadioButtons();
		
		appwin.setSize(new Dimension(240, 220));
		appwin.setTitle("CheckBoxGroup or RadioButton");
		appwin.setVisible(true);

	}

}
