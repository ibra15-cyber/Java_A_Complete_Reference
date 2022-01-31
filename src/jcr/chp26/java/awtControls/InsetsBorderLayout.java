package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class InsetsBorderLayout extends Frame {
	//FIELDS

	
	//CONSTRUCTOR
	InsetsBorderLayout(){
		setBackground(Color.cyan);
		
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
	
	//overriding a static abstract method
	//we be returned when an obj of the class is created
	//although uisng our constructor
	public Insets getInsets() {
		return new Insets(40, 20, 10, 20);
		
	}

	public static void main(String[] args) {
		InsetsBorderLayout appwin = new InsetsBorderLayout();
		
		appwin.setSize(new Dimension(500, 500));
		appwin.setTitle("BorderLayout Demo");
		appwin.setVisible(true);

	}

}
