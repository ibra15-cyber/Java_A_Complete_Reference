package jcr.chp19.java.collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		
		//initial size is 3 increament by 2
		Vector<Integer>	 v = new Vector<Integer>(3, 2);
		System.out.println("initial size: " + v.size()); //size is zero nothing inside
		System.out.println("initial capcity : " + v.capacity()); //capacity is 3 we stated that
		
		v.addElement(1);
		v.addElement(2);
		v.addElement(3);
		v.addElement(4);
		
		System.out.println("capacity after four aditioins: " + v.capacity());
		System.out.println("Current capacity: " + v.capacity());
		
		v.addElement(5);
		System.out.println("Current capacity : " + v.capacity());
		System.out.println("Current size : " + v.size());
		
		
		v.addElement(6);
		v.addElement(7);
		
		
		System.out.println("Current capacity: " + v.capacity());
		System.out.println("Current size: " + v.size());
		
		v.addElement(9);
		v.addElement(10);
		
		System.out.println("current capacity   " + v.capacity());
		
		v.addElement(11);
		v.addElement(12);
		
		System.out.println("first element: "+ v.firstElement());
		System.out.println("last element: " + v.lastElement());
		
		if(v.contains(3))
			System.out.println("vector contains 3");
		
		//ENUMERATE
		Enumeration<Integer> vEnum = v.elements()	;
		
		System.out.print("Elements in vector: ");
		while(vEnum.hasMoreElements())
			System.out.print(vEnum.nextElement() + " "	);
		System.out.println();
		
		
		
		 
		

	}

}
