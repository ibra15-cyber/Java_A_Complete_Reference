package jcr.chp19.java.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AlgorithmsDemo {

	public static void main(String[] args) {
		
		LinkedList<Integer > ll  = new LinkedList<Integer>();
		
		ll.add(-8);
		ll.add(20);
		ll.add(-20);
		ll.add(8);
		
		//collections have reverse method
		Comparator<Integer> r = Collections.reverseOrder();
		
		//sort takes 2 para: a collection and a reverse order
		Collections.sort(ll, r);
		
		System.out.println("List sorted in reverse: " );
		
		for(int i : ll)
			System.out.println(i + " ");
		
		
		//shuffle list
		Collections.shuffle(ll);
		System.out.println("List shuffled or randomized:  " );
		for(int i : ll)
			System.out.println(i + " ");
		System.out.println();
		
		System.out.println("minimun: " + Collections.min(ll));
		System.out.println("max: " + Collections.max(ll));
		

	}

}
