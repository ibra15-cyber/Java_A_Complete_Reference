package jcr.chp31.java.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JCheckBoxDemo implements  ItemListener{
	JLabel jlab;
	
	JCheckBoxDemo() {
		JFrame  jfrm = new JFrame();
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(250, 100);
		
		JCheckBox cb = new JCheckBox("C");
		cb.addItemListener(this);
		jfrm.add(cb);
		
		cb = new JCheckBox("C++");
		cb.addItemListener(this);
		jfrm.add(cb);
		
		cb = new JCheckBox("Java");
		cb.addItemListener(this);
		jfrm.add(cb);
		
		cb = new JCheckBox("Perl");
		cb.addItemListener(this);
		jfrm.add(cb);
		
		jlab = new JLabel("Select Languages");
		jfrm.add(jlab);
		
		jfrm.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent ie) {
		JCheckBox cb = (JCheckBox) ie.getItem();
		
		if(cb.isSelected())
			jlab.setText(cb.getText() + " is selected");
		else
			jlab.setText(cb.getText() + " is selected");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JCheckBoxDemo();
			}
		});

	}

}
