package jcr.chp19.java.collection;

import java.util.Comparator;
import java.util.TreeSet;


class MyComp implements Comparator<String>{
	
	public int compare(String aStr, String bStr) {
		//reverse the comparison
		return bStr.compareTo(aStr);
	}
}


public class ComparatorDemo {

	public static void main(String[] args) {
		
		TreeSet<String> ts = new TreeSet<String> (new MyComp());
		
		//Add elemetns to the tree set
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E"); 
		ts.add("F");
		ts.add("D");
		
		//display the elements.
		for(String ele: ts)
			System.out.print(ele + " ");
		

	}

}
