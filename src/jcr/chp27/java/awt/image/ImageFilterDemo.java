package jcr.chp27.java.awt.image;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ColorModel;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageConsumer;
import java.awt.image.MemoryImageSource;
import java.awt.image.RGBImageFilter;
import java.io.*;
import java.io.IOException;
import javax.imageio.*;
import java.lang.reflect.*;


public class ImageFilterDemo extends Frame implements ActionListener {
	
	Image img;
	PlugInFilter pif;
	Image fimg;
	Image curImg;
	LoadedImage limg;
	Label label;
	Button resetbutton;
	String[] filters = {"Grayscale", "Invert", "Constrast", "Blur", "Sharpen"};
	
	ImageFilterDemo(){
		Panel p = new Panel();
		add(p, BorderLayout.SOUTH);
		
		resetbutton = new Button("Reset");
		resetbutton.addActionListener(this);
		p.add(resetbutton);
		
		for (String fstr : filters) {
			Button b = new Button(fstr); //make buttons for each filter
			b.addActionListener(this);
			p.add(b);
		}
		
		label = new Label("");
		add(label, BorderLayout.NORTH);
		
		try {
			File imageFile = new File("Capture.PNG");
			
			img = ImageIO.read(imageFile);
		} catch(IOException exc) {
			System.out.println("Cannot load image file.");
			System.exit(0);
		}
		
		limg = new LoadedImage(img);
		add(limg, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	public void actionPerformed(ActionEvent ae) {
		String a = "";
		
		try {
			a = ae.getActionCommand();
			if(a.equals("Reset")) {
				limg.set(img);
				label.setText("Norma");
			} else {
				pif = (PlugInFilter)(Class.forName(a)).getConstructor().newInstance();
				fimg = pif.filter(this, img);
				limg.set(fimg);
				label.setText("Filtered: " + a);
			}
			repaint();
		} catch(ClassNotFoundException e) {
			label.setText(a + " not found");
			limg.set(img);
			repaint();
		} catch(InstantiationException e) {
			label.setText("Couldnt new " + a );
		} catch(IllegalAccessException e) {
			label.setText("no access: " + a); 
		} catch(NoSuchMethodException | InvocationTargetException e) {
			label.setText("Filter creation error: " + e);
		}
	}
	
	public static void main(String[] args) {
		TileImage appwin = new TileImage();
				
				appwin.setSize(new Dimension(420, 420));
				appwin.setTitle("TileImage");
				appwin.setVisible(true);

	}
}
//PlugInfilter.java
interface PlugInFilter{
	java.awt.Image filter(java.awt.Frame f, java.awt.Image in);
}

//LoadedImage.java
class LoadedImage extends Canvas{
	Image img;
	
	LoadedImage(Image i){
		set(i);
	}
	
	void set(Image i) {
		img = i;
		repaint();
	}
	
	public void paint(Graphics g) {
		if(img == null) {
			g.drawString("no image", 10, 30);
		} else {
			g.drawImage(img, 0, 0, this);
		}
	}

	public Dimension getPrefferedSize() {
		return new Dimension(img.getWidth(this), img.getHeight(this));
	}
	
	public Dimension getMinimumSize() {
		return getPrefferedSize();
	}
	
}
	
//GrayScale.java
class Grayscale extends RGBImageFilter implements PlugInFilter{
	
	public Grayscale() {
	}
	
	public Image filter(Frame f, Image in) {
		return f.createImage(new FilteredImageSource(in.getSource(), this));
	}
	
	public int filterRGB(int x, int y, int rgb) {
		int r = (rgb >>16) &  0xff;
		int g = (rgb >> 8) & 0xff;
		int b = rgb & 0xff;
		int k = (int) (.56*g +.33*r + .11*b);
		return (0xff00000| k<<16| k<<8| k);
	}
}

//invert.java
class Invert extends RGBImageFilter implements PlugInFilter{
	public Invert() {
	}
	
	public Image filter(Frame f, Image in) {
		return f.createImage(new FilteredImageSource(in.getSource(), this));
	}
	
	public int filterRGB(int x, int y, int rgb) {
		int r = 0xff -(rgb>>16) & 0xff;
		int g = 0xff -(rgb >>8) & 0xff;
		int b = 0xff - rgb & 0xff;
		
		return (0xff000000| r<<16| g<<8 |b);
	}
}

//contrast.java
class Contrast extends RGBImageFilter implements PlugInFilter{
	
	public Image filter(Frame f, Image in) {
		return f.createImage(new FilteredImageSource(in.getSource(), this));
	}
	
	private int multclamp(int in, double factor) {
		in = (int)(in*factor);
		return in>255? 255: in;
	}
	
	double gain = 1.2;
	private int cont (int in) {
		return (in <128) ? (int)(in/gain): multclamp(in, gain);
	}
	
	public int filterRGB(int x, int y, int rgb) {
		int r= cont((rgb >> 16) & 0xff);
		int g = cont((rgb>>88) & 0xff);
		int b = cont(rgb &0xff);
		return (0xf000000|r<<16| g<<8|b);
	}
	
}

//Convolver.java
abstract class Convolver implements ImageConsumer, PlugInFilter{
	int width, height;
	int[] imgpixels, newimgpixels;
	boolean imageReady = false;
	
	abstract void convolve();
	
	public Image filter(Frame f, Image in) {
		imageReady = false;
		in.getSource().startProduction(this);
		waitForImage();
		newimgpixels = new int[width*height];
		
		try {
			convolve();
		} catch(Exception e) {
			System.out.println("Convolver failed" + e);
			e.printStackTrace();
		}
		
		return f.createImage(
				new MemoryImageSource(width, height, newimgpixels, 0, width));	
	}
	
	synchronized void waitForImage() {
		try {
			while(!imageReady)
				wait();
		} catch(Exception e) {
			System.out.println("Interrupted");
		}
	}
	
	public void setProperties(java.util.Hashtable<?, ?> dummy) {}
	public void setColorModel(ColorModel dummy) {
	}
	public void setHints (int dummy) {
}
	public synchronized void imageComplete(int dummy) {
		imageReady = true;
		notifyAll();
	}
	public void setDimensions(int x , int y) {
		width = x;
		height = y;
		imgpixels  = new int [x*y];
	}
	public void setPixels (int x1, int y1, int w, int h, ColorModel model, byte[] pixels, int off, int
			scansize) {
		int pix, x, y, x2, y2, sx, sy;
		
		x2 = x1+w;
		y2 = y1+h;
		sy = off;
		for(y=y1; y<y2; y++) {
			sx = sy;
			for(x=x1; x<x2; x++) {
				pix = model.getRGB(pixels[sx++]);
				if((pix & 0xff000000) == 0)
						pix = 0x00ffffff;
						imgpixels[y*width+x] = pix;
			}
			sy += scansize;
		}
	}
	
	public void setPixels (int x1, int y1, int w, int h, ColorModel model, int pixels[], int off, int scansize) {
	
		int pix, x, y, x2, y2, sx, sy;
		
		x2 = x1+w;
		y2 = y1+h;
		sy = off;
		for(y=y1; y<y2; y++) {
			sx = sy;
			for(x=x1; x<x2; x++) {
				pix = model.getRGB(pixels[sx++]);
				if((pix & 0xff000000) == 0)
						pix = 0x00ffffff;
						imgpixels[y*width+x] = pix;
			}
			sy += scansize;
		}
	} 
}
	
//blur 
	class Blur extends Convolver{
		public void convolve() {
			for(int y=1; y<height-1; y++) {
				for(int x = 1; x<width-1; x++) {
					int rs = 0;
					int gs = 0;
					int bs = 0;
					
					for(int k = -1; k<=1; k++) {
						for(int j=-1; j<=1; j++) {
							int rgb = imgpixels [(y+k)*width+x+j];
							int r = (rgb>>16)&0xff;
							int g =(rgb>>8)&0xff;
							int b= rgb &0xff;
							rs += r;
							gs +=g;
							bs +=b;
						}
					}
					
					rs/=9;
					gs/=9;
					bs/=9;
					
					newimgpixels[y*width+x] = (0xff00000| 
														rs <<16| gs<<8| bs);
				}
			}
		}
	}
	
	// sharpen.java
	
class Sharpen extends Convolver{
		private final int clamp(int c ) {
			return (c>255? 255: (c<0?0: c));
		}
			
		public void convolve() {
			int r0 = 0, g0 = 0, b0 = 0;
			for (int y=1; y<height-1; y++) {
				for(int x =1; x<width-1; x++) {
					int rs = 0;
					int gs = 0;
					int bs = 0;
					
					for (int k=-1; k<=1; k++) {
						for(int j=-1; j<=1; j++) {
							int rgb = imgpixels[(y+k)*width+x+j];
							int r = (rgb >> 16) & 0xff;
							int g = (rgb >> 8) & 0xff;
							int b = rgb & 0xff;
							if(j==0 && k==0) {
								r0 = r;
								g0 = g;
								b0 =b ;
							} else {
								rs += r;
								gs += g;
								bs  += b;
							}
						}
					}
					rs >>= 3;
					gs >>=3;
					bs >>= 3;
					newimgpixels[y*width+x] = (0xff000000|
																	clamp(r0+r0-rs) <<	16 |
																	clamp(g0+g0-gs) <<8|
																	clamp(b0+b0-bs));
				}
			}
		}
	}