package jcr.chp29.java.stream;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo9UsingSpliterator {

	public static void main(String[] args) {
	ArrayList<String> myList = new ArrayList<>();
		
		myList.add("Alpha");
		myList.add("Beta");
		myList.add("Gamma");
		myList.add("Delta");
		myList.add("phi");
		myList.add("omega");
		
		Stream<String> myStream = myList.stream();
		
		Spliterator<String> splitItr = myStream.spliterator(); //obtaining spl
		Spliterator<String> splitItr2 = splitItr.trySplit(); //spitling
		
		//if split is split
		if(splitItr2 != null) {
			System.out.println("Output from splitItr2");
			splitItr2.forEachRemaining( (n) -> System.out.println(n) );
		}
		
		//then print this 
		System.out.println("\nOutput form splitItr: ");
		splitItr.forEachRemaining( (n) -> System.out.println(n) );

	}

}
