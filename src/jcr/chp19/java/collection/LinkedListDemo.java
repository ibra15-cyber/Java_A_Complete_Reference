package jcr.chp19.java.collection;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList<String> ll = new LinkedList<>();
		
		ll.add("F");
		ll.add("B");
		ll.add("D");
		ll.add("E");
		ll.add("C");
		
		System.out.println("our initial linkedlist: " + ll);
		
		ll.addFirst("FIRST");
		ll.add(1, "Second");
		ll.add("LAST");
		System.out.println("our initial linkedlist: " + ll);
		
		ll.remove("F");
		System.out.println("our initial linkedlist: " + ll);
		
		ll.removeFirst();
		ll.removeLast();
		
		System.out.println("linkedlist after deleting first and last: " + ll);
		
		
		System.out.println("Get the 2nd index " + ll.get(2)); 
		
		ll.set(2, " Changed"); //replace the 2nd with the string
		System.out.println("after setting 2nd index: " + ll); 
		
		

		
		

		
		


		
		

	}

}
