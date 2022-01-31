package jcr.chp20.java.utility;

import java.util.Formatter;

public class FormatterPrecision {

	public static void main(String[] args) {

		Formatter fmt = new Formatter();
		
		fmt.format("%.4f", 123.1234567);
		System.out.println("4 decimal places: " + fmt);
		fmt.close();
		
		fmt= new Formatter();
		fmt.format("%16.2e", 123.1234567);
		System.out.println("this 2 decimal places of exponent : "+ fmt);
		fmt.close();
		
		fmt = new Formatter();
		fmt.format("%.15s", "Formatting with java is now easy");
		System.out.println("only the first 15 string will print: "  + fmt);
		fmt.close();
	
	}

}
