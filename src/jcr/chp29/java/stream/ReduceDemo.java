package jcr.chp29.java.stream;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceDemo {

	public static void main(String[] args) {
		//creating an array list object
		ArrayList<Integer> myList = new ArrayList<>();
		
		myList.add(7);
		myList.add(18);
		myList.add(10);
		myList.add(24);
		myList.add(17);
		myList.add(5);
		
		Optional<Integer> productUsingOptional = myList.stream().reduce(
				(a, b) -> a*b	); //lambda exp: take a and b return a * b
		if(productUsingOptional.isPresent())
			System.out.println("Product as Optional: " + productUsingOptional.get());
		
		//2nd version 
		int productUsingGeneric  = myList.stream().reduce(1, (a, b) -> a*b);
		//where 1 is the identity in multiplication
		System.out.println("Product using generic \"Integer\" is: " + productUsingGeneric);
		
		//reduce i realised is also intermediate just like filter, they dont consume their data 
		//as compared to max and min of stream 
		
		//to check for a product for only the even in the list
		int evenProduct = myList.stream().reduce(1,  (a,b) -> {
			if (b%2 == 0) {
				System.out.println("b includes: " + b);
				return a*b;
			}
			else
				System.out.println("i dont expect a to print: "+ a);
				return a; //a will be holding the current result and b the next
		});
		
		System.out.println("Optional for even b value: "+ evenProduct);
	}

}
