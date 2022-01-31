package jcr.chp25.java.awt;

import java.awt.*;
import java.awt.event.*;

public class MultilineOutputforNewLineAndNextChar extends Frame {
	int curX=20, curY=40; //current position
	Font f;
	
	MultilineOutputforNewLineAndNextChar(){
		f = new Font("SanSerif", Font.PLAIN, 12);
		setFont(f);
		
		//anonymous method to close our window
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
	}
	
	//our method outside of our constructor
	//will only be called through the class object
	public void paint(Graphics g) {
		FontMetrics fm = g.getFontMetrics()	;
		
		nextLine("this on line one.", g);
		nextLine("this is on line two.", g);
		sameLine(" this is on the same line.", g);
		sameLine(" this,  too.", g);
		nextLine("this is on line three. ", g);
		
		curX = 20; curY = 40;   //reset the coordinates for each repaint
	}
		
		//advance to next line
		void nextLine(String s, Graphics g) {
			FontMetrics fm = g.getFontMetrics();
			
			curY += fm.getHeight();
			curX =20;
			g.drawString(s, curX, curY);
			curX += fm.stringWidth(s); 
		}
		
		//display on same line
		void sameLine(String s, Graphics g) {
			FontMetrics fm = g.getFontMetrics();
			
			g.drawString(s, curX, curY);
			curX += fm.stringWidth(s);
		}
	

	public static void main(String[] args) {
		MultilineOutputforNewLineAndNextChar appwin = new MultilineOutputforNewLineAndNextChar();
		
		appwin.setSize(new Dimension(300, 120));
		appwin.setTitle("multiline");
		appwin.setVisible(true);
		

	}

}
