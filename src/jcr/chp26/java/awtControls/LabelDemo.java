package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class LabelDemo extends Frame{
	
	LabelDemo()	{
		//use a flow layout
				setLayout(new FlowLayout()); //will center them
				
				Label one = new Label("one");
				Label two = new Label("Two");
				Label three = new Label("Three");
				
				//add label to frame
				add(one);
				add(two);
				add(three);
				
				//closing using window adapter as an anonymous class
				//but using event listener add window listener
				addWindowListener(new WindowAdapter() {
					
					public void windowClosing(WindowEvent we) {
						System.exit(0);
					}
				});
	}

	public static void main(String[] args) {
		LabelDemo appwin = new LabelDemo();
		
		appwin.setSize(new Dimension(300, 100));
		appwin.setTitle("LableDemo");
		appwin.setVisible(true);

		
		

	}

}
