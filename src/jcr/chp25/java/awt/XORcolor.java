package jcr.chp25.java.awt;

import java.awt.*;
import java.awt.event.*;

public class XORcolor  extends Frame	{
	int chsX=100, chsY=100;
	
	XORcolor(){
		//constructor not initializing our hardcoded int variable
		
		//our invoked method takes an anonymous class
		addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseMoved(MouseEvent me) {
				int  x  = me.getX()	;
				int y = me.getY()	;
				chsX =x-10; 		//subtract 10 from the horizontal line
				chsY = y-10; 		//subtract 10 from the vertical y line
				repaint();
			}
		});
		
		//second method invoked from extending the frame
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing (WindowEvent we) {
				System.exit(0);
				}
		});
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(20, 40, 60, 70);
		
		g.setColor(Color.blue);
		g.fillRect(110, 40, 60, 70);

		g.setColor(Color.black);
		g.fillRect(200, 40, 60, 70);
		
		g.setColor(Color.red);
		g.fillRect(60, 120, 160, 110);
		
		//xor
		g.setXORMode(Color.black);
		g.drawLine(chsX-10, chsY, chsX+10, chsY);
		g.drawLine(chsX, chsY-10, chsX, chsY+10);
	}
	
	public static void main(String[] args) {
		XORcolor appwin = new XORcolor();
		
		appwin.setSize(new Dimension(300, 260));
		appwin.setTitle("XOR Demo");
		appwin.setVisible(true);

	}

}
