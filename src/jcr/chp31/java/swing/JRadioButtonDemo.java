package jcr.chp31.java.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JRadioButtonDemo implements ActionListener{
	JLabel jlab;
	
	JRadioButtonDemo(){
		JFrame jfrm = new JFrame();
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(250, 100);
		
		JRadioButton b1 = new JRadioButton("A");
		b1.addActionListener(this);
		jfrm.add(b1	);
		
		JRadioButton b2 = new JRadioButton("B");
		b2.addActionListener(this);
		jfrm.add(b2);
		
		JRadioButton b3 = new JRadioButton("C");
		b3.addActionListener(this);
		jfrm.add(b3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		
		jlab = new JLabel(" Select One ");
		jfrm.add(jlab);
		
		jfrm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		jlab.setText("You selected: " + ae.getActionCommand());
		
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JRadioButtonDemo();
			}
		});

	}

}
