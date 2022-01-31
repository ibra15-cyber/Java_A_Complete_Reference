package jcr.chp31.java.swing;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class JListDemo {
	//we create a list of strings call cities
	String[] Cities = {
			"New York", "Chicago", "Houston", "Denver", "Los Angeles", "Seattle",
			"London", "Paris", "New Delhi", "Hong Kong", "Tokyo", "Syndney"
	};
	
	//constructor
	JListDemo() {
		//creating our frame, 
		//setting frame layout which will have been just teh setLayout in Panel creation
		//closing when exited and setting size
		JFrame jfrm = new JFrame("JList Demo");
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(200, 200);
		
		//we make a j list of String to be passed and we passed our cities array
		JList<String> jlist = new JList<String>(Cities);
		
		
		//we creat a scrollpane to add our j list on
		//then setting the size of our j scroll pane
		JScrollPane jscrlp = new JScrollPane(jlist);
		jscrlp.setPreferredSize(new Dimension(120, 90));
		
		//we create a j lab obj with default string choose a city
		JLabel jlab = new JLabel("Choose a City");
		
		//using lambda expression to listener
		//the book used anonymouse inner class
		//we could have also implemented an List Selection listener for this class 
		//or another class
		jlist.addListSelectionListener( (le) -> {
			int idx = jlist.getSelectedIndex();
			
			if(idx != -1)
				jlab.setText("Current selection: " + Cities[idx]);
			
			else
				jlab.setText("Choose a City");
		});
		
		//adding scroll pane on to the frame
		//adding our label onto the frame
		jfrm.add(jscrlp);
		jfrm.add(jlab);
		
		//we set visibility of our frame
		jfrm.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JListDemo();
			}
		});

	}

}
