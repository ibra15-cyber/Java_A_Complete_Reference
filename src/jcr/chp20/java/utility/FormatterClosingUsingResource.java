package jcr.chp20.java.utility;

import java.util.Formatter;

public class FormatterClosingUsingResource {

	public static void main(String[] args) {
	
		try(Formatter fmt = new Formatter()){
			fmt.format("Formatting %s is easy %d %f", "with java", 10, 98.6);
			System.out.println(fmt);
		}

	}

}
