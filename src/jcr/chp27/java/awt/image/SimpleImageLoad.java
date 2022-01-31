package jcr.chp27.java.awt.image;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SimpleImageLoad extends Frame {
	Image img;
	
	SimpleImageLoad(){
		try {
			//get the file
			File imageFile = new File("Capture.PNG");
			
			//Load image and save in variable img
			img = ImageIO.read(imageFile);
		} catch (IOException exc) {
			System.out.println("Cannot load image file");
			System.exit(0);
		}
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	//this will paint our frame with the loaded image
	public void paint(Graphics g) {
		g.drawImage(img, getInsets().left, getInsets().top, null);
	}

	public static void main(String[] args) {
		SimpleImageLoad appwin = new SimpleImageLoad();
		
		appwin.setSize(new Dimension(400, 365));
		appwin.setTitle("Simple Image Load");
		appwin.setVisible(true);

	}

}
