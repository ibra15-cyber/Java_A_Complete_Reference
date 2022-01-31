package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;


public class ButtonsDemo extends Frame implements ActionListener{
	String msg = " ";
	Button yes, no, maybe;
	
	ButtonsDemo(){
		//we aint creating a JFrame object because we are accessing it through a class
		//that inherits teh frame
		
		//creating a layout
		setLayout(new FlowLayout());
		
		//creating buttons
		yes = new Button("Yes");
		no = new Button("No");
		maybe = new Button("Undecided");
		
		//add here could have been a jframe object.add(yes)
		//adding buttons on our layout
		add(yes);
		add(no);
		add(maybe);
		
		//action listeners
		//normally you call setter methods directly
		//here we are invoking our methods through objects and
		//passing this because this same class is responsible for implementing our actionlistener interface
		//so we are creating action listeners on the button objects
		yes.addActionListener(this);
		no.addActionListener(this);
		maybe.addActionListener(this);
		
		//controlling the window with add window listener which takes an anonymous 
		//class of of window adapter.
		//implementing the method to close
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	//implementing our abstract methods for the action listener interface
	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		if(str.equals("Yes")) 
			msg = "you pressed yes.";
		
		else if(str.equals("No"))
			msg = "you pressed no";
		
		else
			msg = "you pressed undecided";
		
		repaint();
		
	}
	
	//paint is an abs
	public void paint(Graphics g) {
		g.drawString(msg, 20, 100);
	}
	
	public static void main(String[] args) {
		ButtonsDemo appwin = new ButtonsDemo();
		
		appwin.setSize(new Dimension(250, 150));
		appwin.setTitle("ButtonDemo");
		appwin.setVisible(true);
	}

}
