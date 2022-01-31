package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class TextFieldDemo extends Frame implements ActionListener {
	//FIELDS
	TextField name;
	TextField pass;
	
	//CONSTRUCTOR
	TextFieldDemo(){
		
		setLayout(new FlowLayout());
		
		//create controls (objects)
		Label namep = new Label("Name: ", Label.RIGHT);
		Label passp = new Label("Password: ", Label.RIGHT);
		
		name = new TextField(12);
		pass = new TextField(8);
		pass.setEchoChar('7');
		
		//finally adding to the window
		//so we have to group them 
		//before adding on the window
		add(namep);
		add(name);
		add(passp);
		add(pass);
		
		
		name.addActionListener(this);
		pass.addActionListener(this);
		
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	//OTHER METHODS ABSTRACT TO OVERRIDE
	
	//abstract itemstatechanged from item listener interface
	//here it means when an item is toggle change state
	public void actionPerformed(ActionEvent ie) {
		repaint();
	}
	
	//abstract method from frame
	//we are using the getState to track the above method
	public void paint(Graphics g) {
		g.drawString("Name: " + name.getText(), 20, 100);
		g.drawString("Selected text in name:"  + name.getSelectedText(), 20, 120);
		g.drawString("password: " + pass.getText(), 20, 140);
	}

	public static void main(String[] args) {
		TextFieldDemo appwin = new TextFieldDemo();
		
		appwin.setSize(new Dimension(500, 500));
		appwin.setTitle("CheckBoxGroup or RadioButton");
		appwin.setVisible(true);

	}

}
