package jcr.chp31.java.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextFieldDemo {
	//MAIN CLASS CONSTRUCTOR
	JTextFieldDemo(){
		//jfrm obj with a text filed to display
		JFrame jfrm = new JFrame("JTextFieldDemo");
		//setting our layout using Flowlayout
		jfrm.setLayout(new FlowLayout());
		//telling it to quit when exited
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(260, 120); //size of the frame
		
		JTextField jtf = new JTextField(15); //text field obj created to use 15 characters
		jfrm.add(jtf); //adding text field to fram
		
		JLabel jlab = new JLabel(); //label obj created
		jfrm.add(jlab); //adding the label to the frame
		
		//action listener or event for our text field
		//set the text in the text field to the that of the label
		//we could have used 4 ways i chose lambda exp
		jtf.addActionListener((ae) -> jlab.setText((jtf.getText())));
		
		jfrm.setVisible(true); //set visible
		
	}
	public static void main(String[] args) {
		//running our class
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JTextFieldDemo();
			}
		});

	}

}
