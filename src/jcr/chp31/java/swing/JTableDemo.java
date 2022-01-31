package jcr.chp31.java.swing;

import java.awt.*;
import javax.swing.*;

public class JTableDemo {
	String[] colHeads = { "Name", "Extension", "ID#"}; //creates a list of string to be passed as col head at table creation
	String[][] data = { //13 * 3 
			{"Gail", "4567", "865"},
			{"Ken", "7566", "555"},
			{"Vivian", "5634", "587"},
			{"Vivian", "5634", "587"},
			{"Melanie", "7345", "922"},
			{"Anne", "1237", "333"},
			{"John", "5656", "314"},
			{"mat", "7987", "097"	},
			{"Claire", "9777", "798"},
			{"Erwin", "9028", "797"},
			{"Jennifer", "7988", "879"},
			{"Ed", "8798", "987"},
			{"Helen", "8799", "798"}
		};
	
	JTableDemo(){
		JFrame jfrm = new JFrame(); //frame obj creation
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(300, 300);
		
		JTable table = new JTable(data, colHeads); //creating a table with array or arrays of strings and the header
																				// they sync ie data and the col Heads
		JScrollPane jsp = new JScrollPane(table); //table doenst have a scroll so we added it to scroll pane
		
		jfrm.add(jsp); //added the scroll pane to frame
		
		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JTableDemo();
			}
		});

	}

}
