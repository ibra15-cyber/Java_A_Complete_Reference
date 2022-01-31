package jcr.chp19.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		
		System.out.print("original contents of al using iterator: " ); 
		
		Iterator<String> itr = al.iterator();
		while(itr.hasNext())
			System.out.print(itr.next() + " ");
		
		System.out.println();
		
		System.out.print("original contents of al using listIterator: " ); 
		
		ListIterator<String>litr = al.listIterator()	;
		while(litr.hasNext())
			System.out.print(litr.hasNext()+ "+ ");
		
		System.out.println();
		
		System.out.print("original contents of al using iterator: " ); 
		while(litr.hasPrevious())
			System.out.print(litr.previous() + "+ ");
		
		//listiterator can modified the content of the collection but for each can't
		
		
		
		
		
		
		
	}

}
