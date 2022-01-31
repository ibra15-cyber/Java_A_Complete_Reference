package jcr.chp19.java.collection;


import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
	
	LinkedHashSet<String>	lhs = new LinkedHashSet<String>();
		
		lhs.add("Beta");
		lhs.add("Alpha");
		lhs.add("Eta");
		lhs.add("Gamma");
		lhs.add("Epsilon");
		lhs.add("Omega");
		
		System.out.println("out hashset class " + lhs);
		
		System.out.println("the hashcode for our Linkhashset is : " + lhs.hashCode());

		
	}

}
