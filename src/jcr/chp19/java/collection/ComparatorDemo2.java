package jcr.chp19.java.collection;

import java.util.TreeSet;

class CompartorDemo2{
	public static void main(String args[]) {
		
		TreeSet<String> ts = new TreeSet<String>( (aStr, bStr) -> bStr.compareTo(aStr) );
		
		//the lambda expression is saying that
		//take two parameters and apply the a.compateTo(b)
		//since its returning the outcome of comparison of both a and b 
		//it can use lambda
		
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("D");
		
		for(String element: ts)
			System.out.println(element + " ");
		
		System.out.println();
		
		
		
	}
}