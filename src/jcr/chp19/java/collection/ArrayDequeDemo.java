package jcr.chp19.java.collection;

import java.util.ArrayDeque;

public class ArrayDequeDemo {

	public static void main(String[] args) {
		
		ArrayDeque<String> adq = new ArrayDeque<String>();
		
		adq.push("A");
		adq.push("B");
		adq.push("D");
		adq.push("E");
		adq.push("F");
		adq.push("C");
		
		System.out.println("Popping the stack: " );
		
		System.out.println("My array deque: " + adq);  //print it invertin
		
		System.out.println("popping " + adq.poll()); 	//the last one will get pop up
	}

}
