package jcr.chp31.java.swing;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

class PaintPanel extends JPanel{
	Insets ins; //holds the panel insets
	Random rand; //used to generate random nums
	
	PaintPanel(){
		//anticipating the set border working on our panel with automatic
		setBorder (BorderFactory.createLineBorder(Color.RED, 5));
		
		rand = new Random();
	}
	
	//paintComponent must be overridden
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x, y, x2, y2;
		
		int height = getHeight();
		int width = getWidth();
		
		ins = getInsets();
		//ins object occurs automatic
		
		//draw 10 lines 
		//using x y and x1 and y2 points
		//implemented by the g.drawline(x, y, x1, y1)
		for(int i =0; i< 10; i++) {
			x = rand.nextInt(width-ins.left);
			y = rand.nextInt(height-ins.bottom);
			x2 = rand.nextInt(width-ins.left);
			y2 = rand.nextInt(height-ins.bottom);
			
			g.drawLine(x, y, x2, y2);
		}
	}
}

public class PaintDemo {
	JLabel jlab;
	PaintPanel pp;
	
	PaintDemo(){
		JFrame jfrm  = new JFrame("Paint Demo");
		
		jfrm.setSize(200, 150);
		
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pp = new PaintPanel();
		
		jfrm.add(pp);
		
		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PaintDemo();
			}
		});
	}

}
