package jcr.chp29.java.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamDemo8WithIterator {

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<>();
		
		myList.add("Alpha");
		myList.add("Beta");
		myList.add("Gamma");
		myList.add("Delta");
		myList.add("phi");
		myList.add("omega");
		
		Stream<String> myStream = myList.stream();
		
		Iterator<String> itr = myStream.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}

}
