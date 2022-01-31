package jcr.chp34.java.beans;


import java.beans.*;
import java.awt.*;


public class IntrospectorDemo{
	public static void main(String args[]) {
		Colors color  = new Colors();
		try {
			
			Class<?> c = Class.forName("Colors");
			BeanInfo beanInfo = Introspector.getBeanInfo(c);
			
			System.out.println("Properties: ");
			PropertyDescriptor propertyDescriptor[] = 
					beanInfo.getPropertyDescriptors();
			
			for(int i = 0; i<propertyDescriptor.length; i++) {
				System.out.println("\t" + propertyDescriptor[i].getName());
			}
			
			System.out.println("Events: ");
			EventSetDescriptor eventSetDescriptor[] = 
					beanInfo.getEventSetDescriptors();
			
			for(int i = 0; i<eventSetDescriptor.length; i++) {
				System.out.println("\t" + eventSetDescriptor[i].getName());
			}
		} catch(Exception e) {
			System.out.println("Exception caught." + e);
		}
	}
}