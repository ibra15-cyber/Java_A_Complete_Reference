package jcr.chp31.java.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class DebugToobarAction implements ActionListener{
	JLabel jlab;
	JPopupMenu pm;
	DebugAction setAct;
	DebugAction clearAct;
	DebugAction resumeAct;
	
	DebugToobarAction(){
		//......................................JFrame.....................................................
		JFrame jfrm = new JFrame(); //frame obj creation
//		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(300, 300);
		
		//.....................................Label.........................................................
		jlab = new JLabel();
		
		//.....................................Menu Bar.................................................
		JMenuBar jmb = new JMenuBar();
		
		//......................................Menu and Menu Item...........................
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
		
		//.................................pop up menu
		pm = new JPopupMenu();
		
		//creating menu item for our pop up
		JMenuItem cutp = new JMenuItem("Cut");
		JMenuItem copyp = new JMenuItem("Copy");
		JMenuItem pastep = new JMenuItem("Paste");
		
		//.....................................adding to pop up menu
		pm.add(cutp);
		pm.add(copyp);
		pm.add(pastep);
		
		//when a mouse is pressed call pop up trigger
		//show our pop up menu
		jfrm.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if(me.isPopupTrigger())
//					pm.show(me.getComponent(), me.getX(), me.getY()); //preferred
					pm.show(jfrm, me.getX(), me.getY());
			}
			public void mouseReleased(MouseEvent me) {
				if(me.isPopupTrigger())
					pm.show(me.getComponent(), me.getX(), me.getY());
			}
		});
		
		JToolBar tb = new JToolBar("Debug");
		
		ImageIcon set = new ImageIcon("setBP.gif");
		ImageIcon clear  = new ImageIcon("clearBP.gif");
		ImageIcon resume = new ImageIcon("resume.gif");
		
		JButton setb  = new JButton(set);
		setb.setActionCommand("Set Breakpoint");
		setb.setToolTipText("Set Breakpoint");
		
		JButton clearb = new JButton(clear);
		clearb.setActionCommand("Clear Breakpoint");
		clearb.setToolTipText("Clear Breakpoint");
		
		JButton resumeb = new JButton(resume);
		resumeb.setActionCommand("Resume");
		resumeb.setToolTipText("Resume");
		
		//adding buttons to toolbar
		tb.add(setb);
		tb.add(clearb);
		tb.add(resumeb);
		
		//adding toolbar to frame
		jfrm.add(tb, BorderLayout.SOUTH);
		
		//............................image icons for debug options
		ImageIcon setIcon = new ImageIcon("setBP.gif");
		ImageIcon clearIcon  = new ImageIcon("clearBP.gif");
		ImageIcon resumeIcon = new ImageIcon("resume.gif");
		
		//actions
		setAct = 
				new DebugAction("Set Breakpoint", setIcon,
						KeyEvent.VK_S, KeyEvent.VK_B, "Set a break point.");
				
		clearAct = 
				new DebugAction("Clear Breakpoint", clearIcon,
						KeyEvent.VK_C, KeyEvent.VK_L, "Clear a break point.");
		
		resumeAct = 
				new DebugAction("Resume", resumeIcon,
						KeyEvent.VK_R, KeyEvent.VK_R, "Resume execution after break.");
		
		//initially disable clear breakpoing option
		clearAct.setEnabled(false);
		
		//create toolbar buttons by using the actions
		JButton setAbn = new JButton(setAct);
		JButton clearAbn = new JButton(clearAct);
		JButton resumAbn = new JButton(resumeAct);
		
		//create debug toolbar
		JToolBar dtb = new JToolBar("Breakpoints");
		dtb.add(setAct);
		dtb.add(clearAct);
		dtb.add(resumeAct);
		
		//add toolbar to north
		jfrm.add(dtb, BorderLayout.NORTH);
		
		//create a debug menu that goes under options
		//menu bar item use the actions to create the items
		JMenu debug = new JMenu("Debug");
		JMenuItem setactm = new JMenuItem(setAct);
		JMenuItem clearactm = new JMenuItem(clearAct);
		JMenuItem resumeactm = new JMenuItem(resumeAct);
		
		debug.add(setactm);
		debug.add(clearactm);
		debug.add(resumeactm);
		
		option.add(debug); //add debug menu to option menu
		
		//...................................adding action listeners to menu items
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
		copyp.addActionListener(this);
		cutp.addActionListener(this);
		pastep.addActionListener(this); //action listener implemented by action performed
		clearb.addActionListener(this);
		setb.addActionListener(this);
		resumeb.addActionListener(this);
		
		jfrm.add(jlab, BorderLayout.CENTER); //we aint using flowLayout on the label
		
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
				new DebugToobarAction();
			}
		});

	}

	class DebugAction extends AbstractAction{
		DebugAction(String name, Icon image, int mnem, int accel, String tTip){
			super(name, image);
			putValue(ACCELERATOR_KEY,
					   KeyStroke.getKeyStroke(accel, InputEvent.CTRL_DOWN_MASK));
			
			putValue(MNEMONIC_KEY, mnem);
			putValue(SHORT_DESCRIPTION, tTip);
		}
		
		//handle event for both toolbar adn debug menu
		
		public void actionPerformed(ActionEvent ae) {
			String comstr = ae.getActionCommand();
			
			jlab.setText(comstr + " Selected");
			
			//toogle the enabled status of set and clear breakpoint
			if(comstr.equals("Set Breakpoint")) {
				clearAct.setEnabled(true);
				setAct.setEnabled(true);
			} else if(comstr.equals("Clear Breakpoint")) {
				clearAct.setEnabled(false);
				setAct.setEnabled(true);
			}
		}
	}
}
