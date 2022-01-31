package jcr.chp31.java.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuDemo implements ActionListener{
	JLabel jlab;
	
	MenuDemo(){
		JFrame jfrm = new JFrame(); //frame obj creation
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(300, 300);
		
		jlab = new JLabel();
		
		JMenuBar jmb = new JMenuBar();
		
		JMenu file = new JMenu("File");
		JMenu  option = new JMenu("Options");
		JMenu help = new JMenu("Help");
		
		//file menu item
		JMenuItem open  = new JMenuItem("Open");
		JMenuItem close = new JMenuItem("Close");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		//add to file menu
		file.add(open);
		file.add(close);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		
		jmb.add(file);
		
		//Option menu item
		JMenu   colors = new JMenu("Colors");
		JMenuItem red = new JMenuItem("Red");
		JMenuItem green = new JMenuItem("Green");
		JMenuItem blue  = new JMenuItem("Blue");
		//add to file menu
		colors.add(red);
		colors.add(green);
		colors.add(blue);
		
		option.add(colors);
		
		JMenu priority = new JMenu("Priority");
		JMenuItem high = new JMenuItem("High");
		JMenuItem low = new JMenuItem("Low");
		priority.add(high);
		priority.add(low);
		
		option.add(priority);
		option.addSeparator();
		
		JMenuItem reset = new JMenuItem("Reset");
		option.add(reset);
		
		jmb.add(option);
		
		//final about in help meu
		JMenuItem about = new JMenuItem("About");
		help.add(about);
		
		jmb.add(help);
		
		//adding action listeners to menu items
		open.addActionListener(this);
		close.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		red.addActionListener(this);
		blue.addActionListener(this);
		green.addActionListener(this);
		high.addActionListener(this);
		low.addActionListener(this);
		reset.addActionListener(this);
		about.addActionListener(this);
		
		jfrm.add(jlab);
		
		jfrm.setJMenuBar(jmb);
		
		jfrm.setVisible(true);
	}
	
	//overriding our action listener
	public void actionPerformed(ActionEvent ae) {
		String comstr = ae.getActionCommand(); //get action command
		if (comstr.equals("Exit"))  								//if it equals exit quit
			System.exit(0);
		else
			jlab.setText( comstr + " Selected");  //else change the label text
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MenuDemo();
			}
		});

	}

}
