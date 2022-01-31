package jcr.chp19.java.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<String > al = new ArrayList<>();
		
		System.out.println("Initial size of our arrylist: " + al.size());
		
		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		al.add(1, "A2");
		
		System.out.println("Size of our arraylist after addition: " + al.size());
		
		//remover elements from the array list
		al.remove("F");
		al.remove(2);
		
		System.out.println("Size of our arraylist after deletion: " + al.size());
		
		System.out.println("Contensts of our array: " + al);
		
		
		//ensure capacity
		//al.ensureCapacity(10);  //min capacity
		System.out.println("Size of our arraylist after ensuring capacity: " +al );
		
		//al.trimToSize();
		System.out.println("Size of our arraylist after ensuring capacity: " +al );
		


	}

}
