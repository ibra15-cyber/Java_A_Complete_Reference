package jcr.chp31.java.swing;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MenuDemoFinal2 implements ActionListener {
	JLabel label; //created our labe obj
	JMenuBar mb;  //menu bar
	JToolBar tb; 		//tool bar 
	JPopupMenu pm; //popup menu
	JFrame frm;
	
	DebugAction setAct; //instance of DebugAction an inner class
	DebugAction clearAct;
	DebugAction resumeAct;
	
	MenuDemoFinal2(){
		frm = new JFrame("Complete Menu Demo");
		
		frm.setSize(360, 200);
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel();
		
		mb = new JMenuBar();
		
		pm = new JPopupMenu();
		
		makeFileMenu();
		
		makeActions();
		
		makeOptionsMenu();
		
		makeHelpMenu();
		
		makePopupMenu();
		
		//when a mouse is pressed call pop up trigger
				//show our pop up menu
		frm.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if(me.isPopupTrigger())
//						pm.show(me.getComponent(), me.getX(), me.getY()); //preferred
						pm.show(frm, me.getX(), me.getY());
				}
			public void mouseReleased(MouseEvent me) {
					if(me.isPopupTrigger())
						pm.show(me.getComponent(), me.getX(), me.getY());
				}
			});
		
		frm.add(label, SwingConstants.CENTER);
		
		frm.add(tb, BorderLayout.NORTH);
		
		frm.setJMenuBar(mb);
		
		frm.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String comstr = ae.getActionCommand();
		
		if(comstr.equals("Exit"))
			System.exit(0);
		
		else
			label.setText(comstr + " Selected");
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
			
			label.setText(comstr + " Selected");
			
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
	
	//menu file method
		public void makeFileMenu() {
			JMenu file = new JMenu("File");
			file.setMnemonic(KeyEvent.VK_F); //use key even virtual key f
			//file menu item
			JMenuItem open  = new JMenuItem("Open", KeyEvent.VK_O);
			open.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
			
			JMenuItem close = new JMenuItem("Close",  KeyEvent.VK_C);
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

			mb.add(file);
			
			open.addActionListener(this);
			close.addActionListener(this);
			save.addActionListener(this);
			exit.addActionListener(this);
			}
	
		
		public void makeOptionsMenu(){
			//Option menu item now going to use checkboxes  and radio button
			JMenu  option = new JMenu("Options");
			
			JMenu   colors = new JMenu("Colors");
			JCheckBoxMenuItem red = new JCheckBoxMenuItem("Red");
			JCheckBoxMenuItem green = new JCheckBoxMenuItem("Green");
			JCheckBoxMenuItem blue  = new JCheckBoxMenuItem("Blue");
			
			//add items to menu colors
			colors.add(red);
			colors.add(green);
			colors.add(blue);
			
			//add menu colors to menu option
			option.add(colors);
			
			//turning it into a radio box
			JMenu priority = new JMenu("Priority");
			JRadioButtonMenuItem high = new JRadioButtonMenuItem("High", true);
			JRadioButtonMenuItem low = new JRadioButtonMenuItem("Low");
			
			//group your radio button menu item into one one and add them
			ButtonGroup bg = new ButtonGroup();
			bg.add(high);
			bg.add(low);
			
			//go on to add menu items on menu
			priority.add(high); 
			priority.add(low);
			
			option.add(priority); //menu on menu
			
			//create a debug menu that goes under options
			//menu bar item use the actions to create the items
			JMenu debug = new JMenu("Debug");
			JMenuItem setActm = new JMenuItem(setAct);
			JMenuItem clearActm = new JMenuItem(clearAct);
			JMenuItem resumeActm = new JMenuItem(resumeAct);
					
			debug.add(setActm);
			debug.add(clearActm);
			debug.add(resumeActm);
					
			option.add(debug); //add debug menu to option menu
			option.addSeparator();
			
			JMenuItem reset = new JMenuItem("Reset");
			option.add(reset);
			
			mb.add(option);
			
			red.addActionListener(this);
			blue.addActionListener(this);
			green.addActionListener(this);
			high.addActionListener(this);
			low.addActionListener(this);
			reset.addActionListener(this);
			
		}
		
		public void makeHelpMenu() {
			
			//final about in help me
			//set an icon on the menu item
			JMenu help = new JMenu("Help");
			
			ImageIcon icon = new ImageIcon("digital.png");
			JMenuItem about = new JMenuItem("About", icon);
//			about.setDisabledIcon(icon); //disable icon
			help.add(about);
			
			//adding tool tip text
			about.setToolTipText("This is about me, in a demonstration of tool tip, i night i slept without talking with qurbat");
			
			mb.add(help);
			
			about.addActionListener(this);
		}
		
		public void makeActions() {
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

		}
		
		public void makeToolBar() {
			JToolBar tb = new JToolBar("Debug");
		
		    //create toolbar buttons by using the actions
			JButton setAbn = new JButton(setAct);
			JButton clearAbn = new JButton(clearAct);
			JButton resumAbn = new JButton(resumeAct);
				
			//create debug toolbar
			JToolBar dtb = new JToolBar("Breakpoints");
			dtb.add(setAct);
			dtb.add(clearAct);
			dtb.add(resumeAct);
		
		}
		
		public void makePopupMenu() {
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
			
			copyp.addActionListener(this);
			cutp.addActionListener(this);
			pastep.addActionListener(this); //action listener implemented by action performed
		}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MenuDemoFinal2();
			}
		});

	}	
}
	
	



