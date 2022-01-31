package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

//1. i want to override the action listener using 1. a class
	//so you create a new class that does the implementing
	//if you have an method from diff class that you will call
	//create a constructor and create obj of that class
	//now you can invoke the method (here from Frame) in any method of the default class we are in

//using anonymous class instead of using the main class or another class 
//dindt work because action listener has only one method hence can use lambda exp
//those listeners with more than two methods can use anonymous class.


public class TextFieldDemo2UsingAnonymousClassForEvents extends Frame  {
	//FIELDS
	TextField name;
	TextField pass;
	
	//CONSTRUCTOR
	TextFieldDemo2UsingAnonymousClassForEvents(){
		
		setLayout(new FlowLayout());
		
		//create controls (objects)
		Label namep = new Label("Name: ", Label.RIGHT);
		Label passp = new Label("Password: ", Label.RIGHT);
		
		name = new TextField(12);
		pass = new TextField(8);
		pass.setEchoChar('?');
		
		//finally adding to the window
		//so we have to group them 
		//before adding on the window
		add(namep);
		add(name);
		add(passp);
		add(pass);
		
		//you will only pass this in MyActionListener if it implemented a constructor
		//2 things
			//1. actionlistener doesnt have action adapter because those with adapters 
			//have 2 or more abstract methods but actionlistener has one
		
		//2. this will be a poor programing to use 2 definition on a method when you
		//just create one and implement it with the objects
		//so anonymous class wont work for this
		//we are then left with two options
		//implement that interface and call the method here
		//or create a separate class that will implement the interface
		
		//but actionListener can use lambda expression
		//remember with lambda expressions, the left takes the para to be passed
		//and the right return the action
		//then finally if our lambda expression has a variable name, we invoke the name with 
		//the method
		//which are not doing here. but it still works with the para passed and what it should return
		name.addActionListener((ae) -> repaint());
		pass.addActionListener((ae) -> repaint());
			
	
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	//abstract method from frame
	//we are using the getState to track the above method
	public void paint(Graphics g) {
		g.drawString("Name: " + name.getText(), 20, 100);
		g.drawString("Selected text in name:"  + name.getSelectedText(), 20, 120);
		g.drawString("password: " + pass.getText(), 20, 140);
	}

	public static void main(String[] args) {
		TextFieldDemo2UsingAnonymousClassForEvents appwin = new TextFieldDemo2UsingAnonymousClassForEvents();
		
		appwin.setSize(new Dimension(500, 500));
		appwin.setTitle("CheckBoxGroup or RadioButton");
		appwin.setVisible(true);

	}
}
