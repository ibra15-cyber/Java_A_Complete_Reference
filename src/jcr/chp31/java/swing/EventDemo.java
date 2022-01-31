package jcr.chp31.java.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class EventDemo implements ActionListener{
	JLabel jlab;
	JButton jbnalpha, jbnbeta;
	EventDemo(){
		JFrame jfrm = new JFrame("An Event Example");
		
		jfrm.setLayout(new FlowLayout());
		
		jfrm.setSize(220, 90);
		
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		 jbnalpha = new JButton("Alpha");
		jbnbeta = new JButton("Beta");
		
		//..............................using the first method..........
		//implementing Action Listener interface using this and runnnig the method
		// outside the constructor
//		jbnalpha.addActionListener(this);
//		jbnbeta.addActionListener(this);
//		
		//..............................using a second method...........
		//using anonymous class and implementing everything in one
		//good for this instance
		
//		jbnalpha.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				jlab.setText("Alpha was pressed"); //override the label
//			}
//		});
//		
//		jbnbeta.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				jlab.setText("Beta was pressed");
//			}
//		});
		
		//..............................3rd option....................................
		//create another class to implement action listener interface 
		//and override the method performed
		
		//................................4th method.....................................
		//because action listener has only one method action performed
		//we could use a lambda expression. 
		jbnalpha.addActionListener((ae) -> jlab.setText("Alpha was pressed."));
		jbnbeta.addActionListener((ae) -> jlab.setText("Beta was pressed"));
		//still in the constructor
		
		//add our buttons on our frame
		jfrm.add(jbnalpha);
		jfrm.add(jbnbeta);
		
		//create a label and add on the frame
		jlab = new JLabel("Press a button");
		jfrm.add(jlab);
		
		//set visibility
		jfrm.setVisible(true);
		
	}
	
//	public void actionPerformed(ActionEvent ae) {
////		if(EventDemo.jbnalpha)
//			jlab.setText("Alpha was pressed");
////		else
////			jlab.setText("Beta was pressed");
//	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run()	{
				new EventDemo();
			}
		});

	}

}
