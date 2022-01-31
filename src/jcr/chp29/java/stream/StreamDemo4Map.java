package jcr.chp29.java.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo4Map {

	public static void main(String[] args) {
		ArrayList<Double> myList = new ArrayList<>();
		
		myList.add(7.0);
		myList.add(18.0);
		myList.add(10.0);
		myList.add(24.0);
		myList.add(17.0);
		myList.add(5.0);
//		odd code from a previous example on combiner and 
		// and accumulator commented out 
//		double productOfSqrt = myList.parallelStream().reduce(1.0, (a,b) -> a*Math.sqrt(b), 
//																								(a,b) -> a*b);
//		System.out.println("Product of sqrt : "  + productOfSqrt);
		//first part is accumulator and the second is combiner 
		System.out.println("Our original list" );
		myList.forEach((n)-> System.out.println(n));
		
		System.out.println("List map to find the corresponding square root");
		Stream<Double> sqrtStream = myList.stream().map( (a) -> Math.sqrt(a) );
//		sqrtStream.forEach((n)-> System.out.println( n));
		 
		System.out.println();
		
		double productOfSqrt = sqrtStream.reduce(0.0, (a,b ) -> a+b	);
		//a and b are numbers in our list a will be the initial value or intermediate
		//and b is the next value
		System.out.println("Product of sqare roots is " + productOfSqrt);
		
		//filter gives us what we want from a list
		//map maps each element to another output
		//reduce reduces it to a final value with 1 as mul identity and 0 for addition
	}

}
