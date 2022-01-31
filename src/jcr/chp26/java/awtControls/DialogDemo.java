package jcr.chp26.java.awtControls;

import java.awt.*;
import java.awt.event.*;

public class DialogDemo extends Frame{
	String msg ="";
	CheckboxMenuItem debug, test;
	SampleDialog myDialog; //from an independ class
	
	DialogDemo(){
		 myDialog = new SampleDialog(this, "New Dialog Box");
		 
		//making a menu bar
		MenuBar mbar  = new MenuBar();
		//we set our menu bar object
		setMenuBar(mbar); 
		
		//making a menu call file
		Menu file = new Menu("File");
		
		//making a menu item
		MenuItem item1 = new MenuItem("New...");
		file.add(item1);
		//adding our menu items on our menu objec
		MenuItem  item2, item3, item4, item5;
		file.add(item2 = new MenuItem("Open..."));
		file.add(item3 = new MenuItem("Close"));
		file.add(item4 = new MenuItem("-"));
		file.add(item5 = new MenuItem("Quit..."));
		mbar.add(file);
		
		//second menu obj
		Menu edit = new Menu("Edit");
		
		//making menu items
		MenuItem item6, item7, item8, item9;
		
		//adding menu item on our edit menu
		edit.add(item6 = new MenuItem("Cut"));
		edit.add(item7 = new MenuItem("Copy"));
		edit.add(item8 = new MenuItem("Paste"));
		edit.add(item9 = new MenuItem("-")); //this make the dividing line
		
		//making a sub menu
		Menu sub = new Menu("Special");
		MenuItem item10, item11, item12;
		//adding menuitem on sub 
		sub.add(item10 = new MenuItem("First"));
		sub.add(item11 = new MenuItem("Second"));
		sub.add(item12 = new MenuItem("Third"));
		//adding sub on edit
		edit.add(sub);
		
		//making a debug of a checkboxmenuitem
		debug = new CheckboxMenuItem("Debug");
		edit.add(debug);	//adding to edit
		test = new CheckboxMenuItem("Testing");
		edit.add(test);
		mbar.add(edit); //adding edit menu on menu bar
		
		//event listeners
		//several option eith this and implementing the interface in this same class
		//2 making a class that implements all the interfaces and also override the methods
		//3. using anonymous class for those with more than one method and overriding the abstract method
		//4. using a lambda expression for those events with only one method like actionListener
		MyMenuHandler2 handler = new MyMenuHandler2();
		item1.addActionListener(handler); //listen to item1
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		item4.addActionListener(handler);
		item6.addActionListener(handler);
		item7.addActionListener(handler);
		item8.addActionListener(handler);
		item9.addActionListener(handler);
		item10.addActionListener(handler);
		item11.addActionListener(handler);
		item12.addActionListener(handler);
		debug.addItemListener(handler); //this is an itemListener 
		test.addItemListener(handler);
		
		item5.addActionListener((ae)-> System.exit(0)); //action listener imp lambda exp
																						//but to System.exit(0);
		//anonymous listener
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	//print out below the code
	public void paint(Graphics g) {
		g.drawString(msg, 10, 220);
		
		if(debug.getState())
			g.drawString("Debug is on.", 10, 240);
		
		else
			g.drawString("Debug if off", 10, 240);
		
		if(test.getState())
			g.drawString("Testing is on.", 10, 260);
		
		else
			g.drawString("Testing is off", 10, 260);
	}

	public static void main(String[] args) {
		DialogDemo appwin = new DialogDemo();
		
		appwin.setSize(new Dimension(250, 300));
		appwin.setTitle("DialogDemo");
		appwin.setVisible(true);

	}



//here we are using inner class 
//we can use independent classes too
class MyMenuHandler2 implements ActionListener, ItemListener{
	
	//actionPerformed method from addActionListener 
	public void actionPerformed(ActionEvent ae) {
		msg = "You selected: ";
		String arg = ae.getActionCommand()	;
		
		if(arg.equals("New..."))
			msg += "New.";
		
		else if(arg.equals("Open..."))
			msg += "Open";
		
		else if(arg.equals("Edit"))
			msg +="Edit.";
		
		else if(arg.equals("Close"))
			msg +="Close";
		
		else if(arg.equals("Copy"))
			msg +="Copy.";
		
		else if(arg.equals("Paste"))
			msg +="Paste.";
		else if(arg.equals("First"))
			msg +="First.";
		else if(arg.equals("Second"))
			msg +="Second.";
		else if(arg.equals("Third"))
			msg +="Third.";
		else if(arg.equals("Debug"))
			msg +="Debug.";
		else if(arg.equals("Testing"))
			msg +="Testing.";
		
		repaint();
	}
	
	//handle item events
	public void itemStateChanged(ItemEvent ie) {
		repaint();
	}
	
	}
}

class SampleDialog extends Dialog{
	
	SampleDialog(Frame parent, String title){
		super(parent, title, false);
		setLayout(new FlowLayout());
		setSize(300,200);
		
		add(new Label("Press this button"));
		
		Button b;
		add(b = new Button("Cancle"));
		b.addActionListener((ae)-> dispose());
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}
	public void paint(Graphics g) {
		g.drawString("This is in the dialog box", 20, 80);
	}
}