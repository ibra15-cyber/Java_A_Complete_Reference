package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class TextAreaDemo extends Frame {
	//FIELDS
	TextArea text;
	
	//CONSTRUCTOR
	TextAreaDemo(){
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		String val = "Java 9 is the latest version of the most"
				+ "\n widley usde  compluter language for internertnet progamming"
				+ "\nbuilding on a rich herritage, java has advanced both"
				+ "\none of the readsons for java ongoing success is its"
				+ "\nstill. instead java has coninssitely adapted to the"
				+ "\nrapidly changing landscape of the networkd workd"
				+ "\nmoreover, java has often led the wasiy charing the"
				+ "\ncourse for others to follow ";
		
		text = new TextArea(val, 10, 30);
		
		add(text); //adding text to the frame
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		TextAreaDemo appwin = new TextAreaDemo();
		
		appwin.setSize(new Dimension(500, 500));
		appwin.setTitle("Text Area Demo");
		appwin.setVisible(true);

	}

}
