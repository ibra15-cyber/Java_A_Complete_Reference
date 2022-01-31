package jcr.chp19.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedSet;

public class Test {

	public static void main(String[] args) {
		
		
		ArrayList<String> astr  = new ArrayList<>();
		
		astr.add("mango");
		astr.add("apple");
		astr.add("banana");
		
		
		System.out.println("arraylist can be printed out without any restrictions " + astr);
		//iterating with iterator
		Iterator<String> ist = astr.iterator();
		while(ist.hasNext()) {
			System.out.println(ist.next());
		}
		
		//iterator with 
		System.out.println("for each: ");
		for(String s : astr)
			System.out.println(s);
		
		//arraylist without type 
		ArrayList wdgeneric = new ArrayList();
		
		//using addAll
		wdgeneric.addAll(astr);
		System.out.println(wdgeneric);
		
		//.......................................................................................Array........................................
		
		int[] arr = {1, 2, 3, 4, 5, 6,7};
		System.out.println(Arrays.toString(arr));
		
	
		

	}

}
