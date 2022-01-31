package jcr.chp31.java.swing;

//buttons on pane
//pane on scroll pane
//scroll pane on frame

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JScrollPaneDemo {
	
	JScrollPaneDemo(){
		//creating frame obj
		JFrame jfrm = new JFrame("JScrollPaneDemo");
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(400, 400);
		
		//creating panel and panel is setting the layout 
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(20, 20));
		
	
		int b = 0;
		for (int i = 0; i< 20; i++) {
			for(int j = 0; j<20; j++) {
				jp.add(new JButton("Botton " + b)); //add button on panel label it botton and increment b
				++b;
				
			}
		}
		
		JScrollPane jsp = new JScrollPane(jp); //adding our 20 * 20 grid to scroll pane
		
		jfrm.add(jsp, BorderLayout.CENTER); //our scroll pane on our frame
		
		jfrm.setVisible(true);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run()	{
				new JScrollPaneDemo();
			}
		});

	}

}
