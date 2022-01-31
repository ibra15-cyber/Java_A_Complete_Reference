package jcr.chp34.java.beans;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Colors extends Canvas implements Serializable  {
	transient private Color color; //not persistent
	private boolean rectangular; //persist
	
	public Colors(){
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				change();
			}
		});
		rectangular =false;
		setSize(200, 100);
		change();
		
	}
		
		public boolean getRectangle() {
			return rectangular;
		}
		
		public void setRectangular(boolean flag) {
			this.rectangular=flag;
			repaint();
		}
		
		public void change() {
			color = randomColor();
			repaint();
		}
		
		private Color randomColor() {
			int r = (int) (255*Math.random());
			int g = (int) (255*Math.random());
			int b = (int) (255*Math.random());
			return new Color (r, g, b);
		}
		
		public void paint(Graphics g) {
			Dimension d = getSize();
			int h = d.height;
			int w = d.width;	//getsize of the width
			g.setColor(color); //color is random
			
			if(rectangular)
				g.fillRect(0, 0, w-1, h-1);
			else
				g.fillOval(0, 0, w-1, h-1);	
	}
}