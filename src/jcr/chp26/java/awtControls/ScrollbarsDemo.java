package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

//implements AdjustmentListerner instead of itemListener or actionListener
public class ScrollbarsDemo extends Frame implements AdjustmentListener {
	//FIELDS
	String msg = "";
	Scrollbar vertSB;
	Scrollbar horzSB;
	
	//CONSTRUCTOR
	ScrollbarsDemo(){
		
		setLayout(new FlowLayout());
		
		//create scroll bar objects
		vertSB = new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 200);
		vertSB.setPreferredSize(new Dimension(20, 100));
		
		horzSB = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
		horzSB.setPreferredSize(new Dimension(100, 20));
		
		//finally adding to the window
		//so we have to group them 
		//before adding on the window
		add(vertSB);
		add(horzSB);
		
		vertSB.addAdjustmentListener(this);
		horzSB.addAdjustmentListener(this);
		
		//add mousemotionlistener
		addMouseMotionListener(new MouseAdapter() {
			
			//update scrol bars to reflect mouse dragging
			public void mouseDragged(MouseEvent me) {
				int x = me.getX()	;
				int y = me.getY();
				
				vertSB.setValue(y);
				horzSB.setValue(x);
				repaint();
			}
		});
		
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	//OTHER METHODS ABSTRACT TO OVERRIDE
	
	//abstract itemstatechanged from item listener interface
	//here it means when an item is toggle change state
	public void adjustmentValueChanged(AdjustmentEvent ae) {
		repaint();
	}
	
	//abstract method from frame
	//we are using the getState to track the above method
	public void paint(Graphics g) {
		msg = "Vertical: "+ vertSB.getValue();
		msg += ", Horizontal:" + horzSB.getValue();
		g.drawString(msg, 20,  160);
		
		//show current mous drage position
		g.drawString("*", horzSB.getValue(), vertSB.getValue());
		
	}

	public static void main(String[] args) {
		ScrollbarsDemo appwin = new ScrollbarsDemo();
		
		appwin.setSize(new Dimension(500, 500));
		appwin.setTitle("CheckBoxGroup or RadioButton");
		appwin.setVisible(true);

	}

}
