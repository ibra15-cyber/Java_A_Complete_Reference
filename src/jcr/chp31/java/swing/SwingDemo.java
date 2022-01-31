package jcr.chp31.java.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SwingDemo {
		
	SwingDemo(){
		JFrame jfrm  = new JFrame("A Simple Swing Application");
		
		jfrm.setSize(275, 100);
		
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close at exit
		
		JLabel jlab = new JLabel(" Swing means powerful GUIs.");
		
		jfrm.add(jlab); //adding our label on our frame
		
		jfrm.setVisible(true);
	}
	public static void main(String[] args) {
		//using anonymous class to start run of runnable thread
		//run is going to create an instant of our swing class 
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingDemo();
			}
		});
		
	}

}
