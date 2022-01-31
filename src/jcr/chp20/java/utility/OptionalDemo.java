package jcr.chp20.java.utility;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		
		//Optional doenst have constructor but methods
//		Optional
//		OptionalDouble
//		OptionalInt
//		OptionalLong
		
		Optional<String> noVal = Optional.empty();
		
		Optional<String> hasVal = Optional.of("ABCDEFG");
		
		if(noVal.isPresent())
			System.out.println("This won't be displayed");
		else {
			System.out.println("noVal has no value");		
		}
		
		if(hasVal.isPresent())
			System.out.println("This will be displayed: " + hasVal.get());
		else {
			System.out.println("noVal has no value");
		}
		
		String defStr = noVal.orElse("Default String"); //if no val print default string
		System.out.println(defStr);

	}

}
