package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo extends Frame {
	//FIELDS
	Checkbox windows10;
	Checkbox windows7;
	Checkbox windows8;
	Checkbox android;
	Checkbox solaris;
	Checkbox mac;
	Panel osCards;
	Panel winPan;
	Panel otherPan;
	CardLayout cardLO;
	Button win;
	Button other;
	
	CardLayoutDemo(){
		//set layout type
		setLayout(new FlowLayout());
		
		//defining our objects of class button
		win = new Button("Windows");
		other = new Button("Other");
		
		//new cardlayout and panel object
		cardLO = new CardLayout();
		osCards = new Panel();
		
		//making a checkbox of windows
		windows7 = new Checkbox("Windows 7", true);
		windows8 = new Checkbox("Windows 8");
		windows10 = new Checkbox("Windows 10");
		
		//making a checkbox of other os
		mac = new Checkbox("mac os");
		solaris = new Checkbox("solaris");
		android = new Checkbox("android");
		
		//creating panels for win and other os
		winPan = new Panel();
		otherPan = new Panel();
		
		
		//adding buttons to the frame
		add(win);
		add(other); 
		
		//set os panel, the biggest or largest panel to card layout
		osCards.setLayout(cardLO);
	
		//windows check boxes to a panel
		winPan.add(windows10);
		winPan.add(windows7);
		winPan.add(windows8);
		
		//others check box to panel
		otherPan.add(solaris);
		otherPan.add(mac);
		otherPan.add(android);
		
		//add panels to card deck
		osCards.add(winPan, "Windows");
		osCards.add(otherPan, "Other");
		
		//add card to main frame panel
		add(osCards);
		
		//using lambda expressions to handle button events
		//show the card layout of oscards for windows and other
		win.addActionListener(ae -> cardLO.show(osCards, "Windows")) ;
		other.addActionListener(ae-> cardLO.show(osCards, "Other"));
		
		//register mouse adapter using pressed event by anonymous class
		addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent me) {
				//when the cardlayout is pressed shuffle to the next os card
				cardLO.next(osCards);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		CardLayoutDemo appwin = new CardLayoutDemo();
		
		appwin.setSize(new Dimension(300, 220));
		appwin.setTitle("CardLayout Demo");
		appwin.setVisible(true);
	}

}
