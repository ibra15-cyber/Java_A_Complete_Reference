package jcr.chp31.java.swing;

//individually button on panels
//then panels on tab
//tab on frame

import javax.swing.*;
import java.awt.*;



class CitiesPanel extends JPanel{
	
	CitiesPanel(){
		//creating butotns that will be placed on the panel
		JButton b1 = new JButton("New York");
		JButton b2 = new JButton("London");
		JButton b3 = new JButton("Hong Kong");
		JButton b4 = new JButton("Tokyo");
		
		add(b1);
		add(b2); 
		add(b3);
		add(b4); //to the panel
	}
}


class ColorsPanel extends JPanel{
	
	ColorsPanel(){
		//creating check box that will be placed on the panel
		JCheckBox b1 = new JCheckBox("Red");
		JCheckBox b2 = new JCheckBox("Green");
		JCheckBox b3 = new JCheckBox("blue");
		JCheckBox b4 = new JCheckBox("black");
		
		add(b1);
		add(b2); 
		add(b3);
		add(b4); //to the panel
	}
}


class FlavorsPanel extends JPanel{
	
	FlavorsPanel(){
		//creating combo box or selection  that will be placed on the panel
		JComboBox<String> jcb = new JComboBox<String>(); //making a combo box of strings
		jcb.addItem("Vanilla");
		jcb.addItem("Chocolate");
		jcb.addItem("Strawberry");
		
		add(jcb); //adding a list of string in a combobox on a pane
	}
}

public class JTabbedPaneDemo {
	
	JTabbedPaneDemo(){
		
		JFrame jfrm = new JFrame("JTabbedPaneDemo");
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(400, 200);
		
		//creating tabbed pane obj
		//adding panels on tabs
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Cities", new CitiesPanel()); //name and object
		jtp.addTab("Colors", new ColorsPanel());
		jtp.addTab("Flavors", new FlavorsPanel());
		
		//adding our tabs on the frame
		jfrm.add(jtp);
		
		jfrm.setVisible(true); 
	}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JTabbedPaneDemo();
			}
		});

	}

}
