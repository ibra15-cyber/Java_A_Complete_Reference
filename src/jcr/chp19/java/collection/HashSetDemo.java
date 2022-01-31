package jcr.chp19.java.collection;

import java.util.HashSet;

public class HashSetDemo {

	public static void main(String[] args) {
		
		HashSet<String>	hs = new HashSet<>();
		
		hs.add("Beta");
		hs.add("Alpha");
		hs.add("Eta");
		hs.add("Gamma");
		hs.add("Epsilon");
		hs.add("Omega");
		
		System.out.println("out hashset class " + hs); //isnt going to be arranged
		
		System.out.println("the hashcode for our hashset is : " + hs.hashCode());

	}

}
