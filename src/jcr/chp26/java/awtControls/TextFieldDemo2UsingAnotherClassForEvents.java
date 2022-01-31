package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

//1. i want to override the action listener using 1. a class
	//so you create a new class that does the implementing
	//if you have an method from diff class that you will call
	//create a constructor and create obj of that class
	//now you can invoke the method (here from Frame) in any method of the default class we are in

public class TextFieldDemo2UsingAnotherClassForEvents extends Frame  {
	//FIELDS
	TextField name;
	TextField pass;
	
	//CONSTRUCTOR
	TextFieldDemo2UsingAnotherClassForEvents(){
		
		setLayout(new FlowLayout());
		
		//create controls (objects)
		
		//this is just the label
		Label namep = new Label("Name: ", Label.RIGHT);
		Label passp = new Label("Password: ", Label.RIGHT);
		
		//the textfield
		name = new TextField(12);
		pass = new TextField(8);
		pass.setEchoChar('?'); //set echo to hide the keys
		
		//finally adding to the window
		//so we have to group them 
		//before adding on the window
		//but first we need the namep before the name 
		//and passp before pass
		add(namep);
		add(name);
		add(passp);
		add(pass);
		
		//you will only pass this in MyActionListener if it implemented a constructor
		name.addActionListener(new MyActionListener(this)); 
		pass.addActionListener(new MyActionListener(this));
		
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	//OTHER METHODS ABSTRACT TO OVERRIDE
	
	
	//abstract method from frame
	//we are using the getState to track the above method
	public void paint(Graphics g) {
		g.drawString("Name: " + name.getText(), 20, 100);
		g.drawString("Selected text in name:"  + name.getSelectedText(), 20, 120);
		g.drawString("password: " + pass.getText(), 20, 140);
	}

	public static void main(String[] args) {
		TextFieldDemo2UsingAnotherClassForEvents appwin = new TextFieldDemo2UsingAnotherClassForEvents();
		
		appwin.setSize(new Dimension(500, 500));
		appwin.setTitle("CheckBoxGroup or RadioButton");
		appwin.setVisible(true);

	}

}

//2nd method: using another class to implement the listener
//here its actionlistener
//it must implement actionPerfomed method
//i did not need to extend Frame for repaint to work

class MyActionListener implements ActionListener {
	TextFieldDemo2UsingAnotherClassForEvents txtfield;
		
		MyActionListener(TextFieldDemo2UsingAnotherClassForEvents txtfield){
			this.txtfield = txtfield;
		}
	
		public void actionPerformed(ActionEvent ie) {
			//instead of using obj to access the pain from the Frame class
			//note you cant even use obj because its a class; you use constructor
			//use a constructor
			//txtfield.repaint();
			txtfield.repaint();
		}
	
}