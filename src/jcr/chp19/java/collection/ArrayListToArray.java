package jcr.chp19.java.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListToArray {

	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		
		System.out.println("Contents of al: " + al);
		
		Integer[] ia = new Integer[al.size()];
		//al.toArray(ia);
		System.out.println("printing our array: " + Arrays.toString(al.toArray(ia)));
		
		//sum the array
		int sum = 0;
		for(int i: ia)
			sum += i;
			System.out.println("sum is: " + sum);
			
		
		

	}

}
