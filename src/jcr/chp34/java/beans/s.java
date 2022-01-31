//package jcr.chp34.java.beans;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.beans.BeanInfo;
//import java.beans.Introspector;
//import java.beans.PropertyDescriptor;
//import java.io.Serializable;
//
//
//class Colors extends Canvas implements Serializable  {
//	transient private Color color; //not persistent
//	private boolean rectanglar; //persist
//	
//	public Colors(){
//		addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent me) {
//				change();
//			}
//		});
//		rectangular =false;
//		setSize(200, 100);
//		change();
//		
//		public boolean getRectangle() {
//			return rectangular;
//		}
//		
//		public void setRectangular(boolean flag) {
//			this.rectangular=flag;
//			repaint();
//		}
//		public void change() {
//			color = randomColor();
//			repaint();
//		}
//		
//		private Color randomColor() {
//			int r = (int) (255*Math.random());
//			int g = (int) (255*Math.random());
//			int b = (int) (255*Math.random());
//			return new Color (r, g, b);
//		}
//		
//		public void paint(Graphics g) {
//			Dimension d = getSize();
//			int h = d.height;
//			int w = d.width;
//			g.setColor(color);
//			
//			if(rectangular)
//				g.fillRect(0, 0, w-1, h-1);
//			else
//				g.fillOval(0, 0, w-1, h-1);	
//		}
//}
//}
//
//public class ColorsBeanInfo extends SimpleBeanInfo {
//	public PropertyDescriptor[] getPropertyDescriptors() {
//		try {
//			PropertyDescriptor rectangular = new PropertyDescriptor("rectangular",
//					Colors.class	);
//			return pd;
//		} catch(Exception e) {
//			System.out.println("Exception caught. " + e);
//		}
//		return null;
//	}
//}
//
//public class IntrospectorDemo{
//	public static void main(String args[]) {
//		try {
//			Class<?> c = Class.forName("Colors");
//			BeanInfo beaninfo = Introspector.getBeanInfo(c);
//			
//			System.out.println("Properties: ");
//			PropertyDescriptor[] propertyDescriptor = 
//					beanInfo.getPropertyDescriptors();
//			
//			for(int i = 0; i<propertyDescriptor.length; i++) {
//				System.out.println("\t" + propertyDescriptor[i].getName());
//			}
//		} catch(Exception e) {
//			System.out.println("Exception caught." + e);
//		}
//	}
//}