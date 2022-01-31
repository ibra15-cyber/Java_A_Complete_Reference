package jcr.chp31.java.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;

public class JTreeDemo {
	
	JTreeDemo(){
		JFrame jfrm = new JFrame(); //frame obj creation
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(200, 250);
		
		//first is a top level selection of the tree
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");
		
		//a sub tree that will have a as the top and the rest pin on it
		DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
		DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
		DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
		
		//another sub tree with b as the header but also a tree nod
		DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
		DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
		DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
		DefaultMutableTreeNode b3= new DefaultMutableTreeNode("B3");
		
		//we are adding sub sub to sub a
		a.add(a1);
		a.add(a2);
		top.add(a); //adding all of a to top
		
		//we are adding sub sub to sub tree b
		b.add(b1);
		b.add(b2);
		b.add(b3);
		
		top.add(b); //adding all of b to top
		
		//making a tree object that takes top tree node
		JTree tree = new JTree(top);
		
		JScrollPane jsp = new JScrollPane(tree); //because we want a scroll pane we adding our tree to scroll pane
		
		jfrm.add(jsp); //adding our scroll pane finally on to our frame
		
		JLabel jlab = new JLabel(); //label obj with no text or icon
		jfrm.add(jlab, BorderLayout.SOUTH); //adding our label but specifying borderlayout
		
		//actionListener to our tree when selected using anonymous inner class
		//implementing the value changed
		//and anytime we want our label to out put selection + path of the tree selected
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent tse) {
				jlab.setText("Selection is " + tse.getPath());
			}
		});
		
		jfrm.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JTreeDemo();
			}
		});;

	}

}
