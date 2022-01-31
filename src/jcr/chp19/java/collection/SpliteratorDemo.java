/**
 * 
 */
package jcr.chp19.java.collection;

import java.util.ArrayList;
import java.util.Spliterator;

public class SpliteratorDemo {

	public static void main(String[] args) {
		
		ArrayList<Double> vals = new ArrayList<>();
		
		vals.add(1.0);
		vals.add(2.0);
		vals.add(3.0);
		vals.add(4.0);
		vals.add(5.0);
		
		System.out.println("contents of vals: \n");
		Spliterator<Double>	spltitr = vals.spliterator();
		//like the Iterator<Double> itr = vals.iterator();
		
		while(spltitr.tryAdvance((n) -> System.out.println(n) ));
		System.out.println();
		
		
		
		//create new list that contains square rootes
		spltitr = vals.spliterator()	;
		ArrayList<Double> sqrs = new ArrayList<>();
		while(spltitr.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));
		
		//use for each remaining() to display contents of sqrs.
		System.out.println("Contents of sqrs : \n");
		spltitr =sqrs.spliterator()	;
		spltitr.forEachRemaining((n)-> System.out.println(n));
		System.out.println();
		
	}

}
