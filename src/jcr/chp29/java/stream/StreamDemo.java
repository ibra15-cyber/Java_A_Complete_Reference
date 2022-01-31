package jcr.chp29.java.stream;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		//creating an array list object
		ArrayList<Integer> myList = new ArrayList<>();
		
		myList.add(7);
		myList.add(18);
		myList.add(10);
		myList.add(24);
		myList.add(17);
		myList.add(5);
		
		//printing back the arraylist contents
		System.out.println("Original list: " + myList); //printing the original list
		
		//invoking a stream on our collection object
		Stream<Integer> myStream = myList.stream();
		
		//reference method calls method compare from the integer class
		//invoking min and max methods on myStream (which was invoked on our list)
		//if is Present  method is true get those values
		//that is if there exists min values and max values
		Optional<Integer> minVal = myStream.min(Integer::compare);
		if(minVal.isPresent()	 )
				System.out.println("Minimum value: " + minVal.get());
		
		//repeating myStream obj creation on our collection of arraylist
		myStream = myList.stream();
		Optional<Integer> maxVal = myStream.max(Integer::compare);
		if(maxVal.isPresent()	 )
				System.out.println("Maximum value: " + maxVal.get());
		
		//here our stream is going further to invoke sorted 
		//then using a for each with a lambda method to traverse the list
		//...and printing them 
		Stream<Integer> sortedStream = myList.stream().sorted();
		System.out.println("Sorted Stream");
		sortedStream.forEach((n) -> System.out.print(n + " " ));
		System.out.println();
		
		//here we invoking stream on our list and using filter to get odd num
		//we then use for each to with lambda expression to print the filtered lsit
		Stream<Integer> oddVals  = myList.stream().sorted().filter((n) -> 
																							(n%2) ==1);
		System.out.println("odd values: " );
		oddVals.forEach((n) -> System.out.print(n + " " ));
		System.out.println();
		
		//same as above but filtering those odd nums > 5
		oddVals  = myList.stream().filter((n ) -> (n%2) == 1).filter((n) -> n>5);
		System.out.println("odd values qreater than 5: ");
		oddVals.forEach( (n) -> System.out.print(n + " " ));
		System.out.println();
		
		//filter is intermediate, hence was used twice with the same value
		//but stream is  a terminal method hence it consumes it values
		//and was repeated twice
		//min max too are terminal operations that return results based on the ele in stream
		
		
		
		

	}

}
