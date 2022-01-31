package jcr.chp31.java.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuDemoCheckboxRadiobox implements ActionListener{
	JLabel jlab;
	
	MenuDemoCheckboxRadiobox(){
		JFrame jfrm = new JFrame(); //frame obj creation
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(300, 300);
		
		jlab = new JLabel();
		
		JMenuBar jmb = new JMenuBar();
		
		
		
		JMenu  option = new JMenu("Options");
		JMenu help = new JMenu("Help");
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F); //use key even virtual key f
		//file menu item
		JMenuItem open  = new JMenuItem("Open", KeyEvent.VK_O);
		open.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem close = new JMenuItem("Close", KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
				
		JMenuItem save = new JMenuItem("Save", KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_E);
		exit.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		
		//add to file menu
		file.add(open);
		file.add(close);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		
		jmb.add(file);
		
		//Option menu item now going to use checkboxes  and radion button
		JMenu   colors = new JMenu("Colors");
		JCheckBoxMenuItem red = new JCheckBoxMenuItem("Red");
		JCheckBoxMenuItem green = new JCheckBoxMenuItem("Green");
		JCheckBoxMenuItem blue  = new JCheckBoxMenuItem("Blue");
		//add to file menu
		colors.add(red);
		colors.add(green);
		colors.add(blue);
		
		option.add(colors);
		
		//turning it into a radio box
		JMenu priority = new JMenu("Priority");
		JRadioButtonMenuItem high = new JRadioButtonMenuItem("High", true);
		JRadioButtonMenuItem low = new JRadioButtonMenuItem("Low");
		
		//group your radio button menu item into one one and add them
		ButtonGroup bg = new ButtonGroup();
		bg.add(high);
		bg.add(low);
		
		priority.add(high); //go on to add menu items on menu
		priority.add(low);
		
		
		
		option.add(priority); //menu on menu
		
		option.addSeparator();
		
		JMenuItem reset = new JMenuItem("Reset");
		option.add(reset);
		
		jmb.add(option);
		
		//final about in help meu
		
		//set an icon on the menu item
		ImageIcon icon = new ImageIcon("digital.png");
		JMenuItem about = new JMenuItem("About", icon);
//		about.setDisabledIcon(icon); //disable icon
		help.add(about);
		
		//adding tool tip text
		about.setToolTipText("This is about me, in a demonstration of tool tip, i night i slept without talking with qurbat");
		
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
				new MenuDemoCheckboxRadiobox();
			}
		});

	}

}
