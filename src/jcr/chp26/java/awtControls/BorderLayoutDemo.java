package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class BorderLayoutDemo extends Frame {
	//FIELDS

	
	//CONSTRUCTOR
	BorderLayoutDemo(){
		
		//adding button directly to the frame
		add(new Button("This is across the top."), BorderLayout.NORTH );
		add(new Button("the footer message might go here."), BorderLayout.SOUTH);
		add(new Button("Right"), BorderLayout.EAST);
		add(new Button ("Left"), BorderLayout.WEST);
		
		//textArea
		String msg = "The reasonable man adapts"
				+ "himself to the world\n"
				+ "the unreasonable one persists in \n"
				+ "trying to adapt the world to himself.\n"
				+ "therefore all progress depends\n"
				+ "on the unreasonable man\n\n"
				+ "					George Bernad Shaw	\n\n";
		add(new TextArea(msg), BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		BorderLayoutDemo appwin = new BorderLayoutDemo();
		
		appwin.setSize(new Dimension(500, 500));
		appwin.setTitle("BorderLayout Demo");
		appwin.setVisible(true);

	}

}
