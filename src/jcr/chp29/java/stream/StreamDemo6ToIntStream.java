package jcr.chp29.java.stream;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class StreamDemo6ToIntStream {

	public static void main(String[] args) {
		ArrayList<Double> myList = new ArrayList<>();
		
		myList.add(1.1);
		myList.add(3.6);
		myList.add(9.2);
		myList.add(4.7);
		myList.add(12.1);
		myList.add(5.0);
		
		//any of the below can be used to call out our list
		//second one uses stream and for each
		System.out.println("Original list : "  + myList);
		
		System.out.print("Original list uisng for Each: ");
		myList.stream().forEach( (a) -> {
			System.out.print(a + " " );
		});
		System.out.println();
		
		IntStream cStrm = myList.stream().mapToInt( (a) -> (int) Math.ceil(a)); //ie for each a return its ceiling
		
		System.out.println("The ceilings of the values in myList");
		cStrm.forEach( (a) -> { //for each of our  a print a which contains the ceiling from above
			System.out.println(a + " ");
		});
		

		
	}

}
