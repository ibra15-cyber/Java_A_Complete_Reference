package jcr.chp31.java.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonDemo implements ActionListener {
		JLabel jlab;
		JButtonDemo(){
			JFrame jfrm = new JFrame("JButtonDemo");
			
			jfrm.setLayout(new FlowLayout());
			
			jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ImageIcon hourglass = new ImageIcon("hourglass.png");
			
			JButton jb = new JButton(hourglass); //hour button takes icon
			jb.setActionCommand("Hourglass");
			jb.addActionListener(this);
			
			jfrm.add(jb);
			
			ImageIcon analog = new ImageIcon("analog.png");
			jb = new JButton(analog); //hour button takes icon
			jb.setActionCommand("Analog clock");
			jb.addActionListener(this);
			jfrm.add(jb);
			
			ImageIcon digital = new ImageIcon("digital.png");
			jb = new JButton(digital); //hour button takes icon
			jb.setActionCommand("Digital clock");
			jb.addActionListener(this);
			jfrm.add(jb);
			
			ImageIcon stopwatch = new ImageIcon("stopwatch.png");
			jb = new JButton(stopwatch); //hour button takes icon
			jb.setActionCommand("Stop clock");
			jb.addActionListener(this);
			jfrm.add(jb);
			
			
			jlab = new JLabel("Choose a Timepiece");
			jfrm.add(jlab);
			
			jfrm.setVisible(true);
		}	
			//handle button events 
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("You have selected " + ae.getActionCommand());
			}
			
		
	public static void main(String[] args) {
		SwingUtilities.invokeLater( new Runnable() {
			public void run()	{
				new JButtonDemo();
			}
		});
		

	}

}
