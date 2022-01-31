package jcr.chp27.java.awt.image;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;

public class DoubleBuffer extends Frame	{
	int gap = 3;
	int mx, my;
	boolean flicker = true;
	Image buffer = null;
	int w = 400, h = 400;
	
	public DoubleBuffer() {
		
		//constructor takes mouse motion listener and implement an anonymous class
		//action adapter cant; it only implements the lambda expres becasue it has only
		//one method
		//since mouse motion listener implements adapter, it uses mouse motion adapter
		//and will implement more than one method
		//here mouseDragged and mouseMoved are called in an anonymous class
		addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged(MouseEvent me) {
				mx = me.getX(); 	//get x and y coordinates and do not flicker. then repaint
				my = me.getY();
				flicker = false;
				repaint();
			}
			
			public void mouseMoved(MouseEvent me) {
				mx = me.getX();		//get x and y coordinate and flicker when mouse moved
				my = me.getY();
				flicker = true;
				repaint();
			}
		});
		
		//window listener too has more than one method hence it can imple the 
		//anon class but not lambda exp
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	//our frame implementing paint and update
	//hence it can impl anonymous class or
	//allow another class to handle it 
	public void paint(Graphics g) {
		Graphics screengc = null;
		
		if(!flicker) {
			screengc = g;
			g=buffer.getGraphics();
		}
		
		g.setColor(Color.blue);
		g.fillRect(0, 0, w, h);
		
		g.setColor(Color.red);
		for(int i =0; i<w; i += gap)
			g.drawLine(i, 0, w-i, h);
		
		for(int i =0; i<h; i += gap)
			g.drawLine(0, i, w, h-i);
		
		g.setColor(Color.black);
		g.drawString("Press mouse button to double buffer", 10, h/2);
		
		g.setColor(Color.yellow);
		g.fillOval(mx-gap, my-gap, gap*2+1, gap*2+1	);
		
		if(!flicker)
			screengc.drawImage(buffer, 0, 0, null);
	}
	
	public void update(Graphics g) {
		paint(g);
	}

	public static void main(String[] args) {
		DoubleBuffer appwin = new DoubleBuffer();
				
				appwin.setSize(new Dimension(400, 400));
				appwin.setTitle("Double Buffer");
				appwin.setVisible(true);
				
				appwin.buffer = appwin.createImage(appwin.w, appwin.h);


	}

}
