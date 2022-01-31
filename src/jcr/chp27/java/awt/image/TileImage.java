package jcr.chp27.java.awt.image;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TileImage extends Frame{
	Image img;
	Image[] cell = new Image[4*4];
	int iw, ih;
	int tw, th;
	
	TileImage(){
		try {
			File imageFile = new File("Capture.PNG");
			
			//load image
			img = ImageIO.read(imageFile);
			
			iw = img.getWidth(null);
			ih = img.getHeight(null);
			
			tw = iw/4;
			th = ih/4;
			
			CropImageFilter f;
			FilteredImageSource fis;
			
			for(int y=0; y<4; y++) {
				for(int x=0; x<4; x++) {
					f = new CropImageFilter(tw*x, th*y, tw, th);
					fis = new FilteredImageSource(img.getSource(), f);
					int i = y*4+x;
					cell[i] = createImage(fis);
				}
			}
			
			for(int i = 0; i<32; i++) {
				int si = (int) (Math.random() * 16);
				int di = (int) (Math.random() * 16);
				Image tmp = cell[si];
				cell[si] = cell[di];
				cell[di] = tmp;
			}
		} catch (IOException exc) {
			System.out.println("cannot load image file.");
			System.exit(0);
		}
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	public void paint(Graphics g) {
		for(int y=0; y<4; y++) {
			for(int x=0; x<4; x++) {
				g.drawImage(cell[y*4+x], x*tw + getInsets().left, y*th +getInsets().top, null);
				
			}
		}
	}

	public static void main(String[] args) {
		TileImage appwin = new TileImage();
		
		appwin.setSize(new Dimension(420, 420));
		appwin.setTitle("TileImage");
		appwin.setVisible(true);
	}

}
