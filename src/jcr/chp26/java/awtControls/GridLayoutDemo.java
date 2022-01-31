package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class GridLayoutDemo extends Frame {
	//FIELDS
	static final int n = 4;
	
	//CONSTRUCTOR
	GridLayoutDemo(){
	
		setLayout(new GridLayout(n, n)); //4x4 grid
		
		setFont(new Font("SansSerif", Font.BOLD, 24)); //set font
		
		//adding button using loop
		//each time i*4+j
		//anytime the value of k > 0
		//add a button
		for (int i = 0; i < n; i++) {
			for(int j = 0; j<n; j++) {
				int k = i*n+j; 
				if(k>0)
					add(new Button(" " + k));
			}
		}
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		GridLayoutDemo appwin = new GridLayoutDemo();
		
		appwin.setSize(new Dimension(500, 500));
		appwin.setTitle("GridLayoutDemo");
		appwin.setVisible(true);

	}

}
