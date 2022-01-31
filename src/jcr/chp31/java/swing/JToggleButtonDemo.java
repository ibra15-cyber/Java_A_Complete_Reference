package jcr.chp31.java.swing;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class JToggleButtonDemo {
	JToggleButtonDemo()	{
		
		JFrame jfrm = new JFrame("JToggleButton");
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(200, 100);
		
		JLabel jlab = new JLabel("Button is off");
		
		JToggleButton jbn = new JToggleButton("On/Off");

		jbn.addItemListener((ItemListener) new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if(jbn.isSelected())
					jlab.setText("Button is on.");
				else
					jlab.setText("Button is off.");
			}
			
		});
		
		jfrm.add(jbn);
		jfrm.add(jlab);
		
		jfrm.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JToggleButtonDemo();
			}
		});
	}

}
