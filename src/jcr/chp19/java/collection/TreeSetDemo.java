package jcr.chp19.java.collection;

import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		
		TreeSet<String> ts = new TreeSet<String>();
		
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");
		
	
		
		
		ts.ceiling("ceiling");
		
		System.out.println("our treeset " + ts); //in sorted order
		
			ts.pollFirst();
			System.out.println("after pollfirst " + ts);
			
			ts.pollLast()	;
			System.out.println("after pulling last " + ts);
			
			//implementing NavigableSet class
			
			
			System.out.println("our treeset " + ts.subSet("B", "D"));


	}

}
