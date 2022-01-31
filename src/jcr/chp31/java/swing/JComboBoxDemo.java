package jcr.chp31.java.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JComboBoxDemo {
	
	String[] timepieces = { "Hourglass", "Analog", "Digital", "stopwatch"}; //string array 
	JComboBoxDemo(){	//constructor
		JFrame jfrm = new JFrame(); //frame obj creation
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(400, 250);
		
		JComboBox<String> jcb = new JComboBox<> (timepieces); //combo box obj to take string henc timpieces
		jfrm.add(jcb);
		
		JLabel jlab = new JLabel(new ImageIcon("hourglass.png")); //jlabel with default icon image 
		jfrm.add(jlab);
		
		jcb.addActionListener(new ActionListener() { //event listener action listener for our combo box
			public void actionPerformed(ActionEvent ae) {
				String s =   (String) jcb.getSelectedItem(); //get the name and set it to s of type string
																					//get selected i suspect is formating capitalization too
				jlab.setIcon(new ImageIcon(s + ".png")); //change our label icon to the string name with .png 
																					//thus update our label icon with the item name selected
			}
		});
		
		jfrm.setVisible(true);
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JComboBoxDemo();
			}
		});

	}

}
