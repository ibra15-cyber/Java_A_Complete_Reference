package jcr.chp31.java.swing;
import java.awt.*;
import javax.swing.*;

public class JLabelDemo {
	JLabelDemo(){
		JFrame jfrm = new JFrame("JLabelDemo");
		
		jfrm.setLayout(new FlowLayout());
		
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jfrm.setSize(260, 210);
		
		ImageIcon ii = new ImageIcon("hourglass.png");
		//JLabel can take a string, an icon and alignment
		//the icon can be gotten using the image icon above
		JLabel jl = new JLabel("Hourglass", ii, JLabel.CENTER);
		
		jfrm.add(jl);
		
		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run()	{
				new JLabelDemo();
			}
		});
	}

}
