package jcr.chp19.java.collection;

import java.util.ArrayList;

public class ForEachDemo {

	public static void main(String[] args) {
		
		ArrayList<Integer> vals = new ArrayList<Integer>();
		
		vals.add(1);
		vals.add(2);
		vals.add(3);
		vals.add(4);
		vals.add(5);
		
		System.out.println("contents of vals: " );
		for (int v : vals)
			System.out.println(v + " ");
		
		//if you are not changing anythng in the array use for each otherwise iterator
		
		int sum=0;
		for(int v: vals)
			sum += v;
		
		System.out.println("Sum of values: " + sum);

	}

}
