package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class ButtonPressed extends Frame implements ActionListener {
	//fields
	String msg = " ";
	Button[] bList = new Button[3]; //we are making a list of 3 buttons
	
	//constructor
	ButtonPressed(){
		setLayout(new FlowLayout());
		
		Button yes = new Button("yes");
		Button no= new Button("no");
		Button maybe = new Button("Undecided");
		
		//store ref to buttons
		bList[0] = (Button) add(yes);
		bList[1] = (Button) add(no);
		bList[2] = (Button) add(maybe);
		
		//register to receive action events
		for(int i = 0; i<3; i++) {
			bList[i].addActionListener(this);
		}
		
		//closing window using anonymous class
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
}
	
	//OTHER METHODS
	
	//handle button action event
	public void actionPerformed(ActionEvent ae) {
		for(int i = 0; i<3; i++) {
			if(ae.getSource() == bList[i]) {
				msg   = "You pressed: " + bList[i].getLabel();
			}
		}
		repaint();
	}
	
	//handle drawing on frame by overriding an abstract class paint
	public void paint(Graphics g) {
		g.drawString(msg, 20, 100);
	}

	public static void main(String[] args) {
		ButtonPressed appwin = new ButtonPressed();
		
		appwin.setSize(new Dimension(250, 150));
		appwin.setTitle("ButtonList");
		appwin.setVisible(true);


		

	}

}
