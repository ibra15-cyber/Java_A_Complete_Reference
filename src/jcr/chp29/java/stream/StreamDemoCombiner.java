package jcr.chp29.java.stream;

import java.util.ArrayList;

public class StreamDemoCombiner {

	public static void main(String[] args) {
		ArrayList<Double> myList = new ArrayList<>();
		
		myList.add(7.0);
		myList.add(18.0);
		myList.add(10.0);
		myList.add(24.0);
		myList.add(17.0);
		myList.add(5.0);
		
		double productOfSqrt = myList.parallelStream().reduce(1.0, (a,b) -> a*Math.sqrt(b), 
																								(a,b) -> a*b);
		System.out.println("Product of sqrt : "  + productOfSqrt);
		//first part is accumulator and the second is combiner 
		
	}

}
