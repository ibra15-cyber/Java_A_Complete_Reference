package jcr.chp20.java.utility;

import java.util.Calendar;
import java.util.Formatter;

public class FormatterJustifyingOutput {

	public static void main(String[] args) {
		
		Formatter fmt = new Formatter();
		
		//right justify 
		fmt.format("|%10.2f|", 123.123); //move 10 spaces and 2 decimal nums
		System.out.println(fmt);
		fmt.close();
		
		//left justify
		fmt = new Formatter();
		fmt.format("|%-10.2f|", 123.123); //move -10 and 2 decimal spaces
		System.out.println(fmt);
		fmt.close();
		
		
		//add plus infront of decimal numbers
		fmt = new Formatter();
		fmt.format("%+d",  100); //+100
		System.out.println(fmt);
		fmt.close();
		
		//adding space to align positive and negative numbers
		fmt = new Formatter();
		fmt.format("% d", -100);
		System.out.println(fmt);
		fmt.close();
		
		//without the sign; positive
		fmt = new Formatter();
		fmt.format("% d", 100);
		System.out.println(fmt);
		fmt.close();
		
		fmt = new Formatter();
		fmt.format("% d", -200);
		System.out.println(fmt);
		fmt.close();
		
		fmt =new Formatter();
		fmt.format("% d", 200);
		System.out.println(fmt);
		fmt.close();
		
		//negative numeric output inside parentheses
		fmt =new Formatter();
		fmt.format("%(d", -400); //- allow the output = (400)
		System.out.println(fmt);
		fmt.close();
		
		//Comma flag
		fmt =new Formatter();
		fmt.format("%,.2f", 4356783497.34); //maintain the same decimal places but separate with comma
		System.out.println(fmt);
		fmt.close();
		
		//Capitalize
		fmt =new Formatter();
		fmt.format("%X", 250); //capital hexadecimal of 250
		System.out.println(fmt);
		fmt.close();
		
		fmt =new Formatter();
		fmt.format("%E", 123.1234);  //e is capitalized
		System.out.println(fmt);
		fmt.close();
		
		//arguement index %n$ where n is a number
		fmt =new Formatter();
		fmt.format("%3$d %1$d %2$d", 10, 20, 30); //print 3rd 30 before 10 before 20
		System.out.println(fmt);
		fmt.close();
		
		//referencing the same obj
		fmt =new Formatter();
		fmt.format("%d in hex is %1$x", 255); //same num reference 2 times: 1. normal int second %1$x hexa
		System.out.println(fmt);
		fmt.close();
		
		//short hand of above
		fmt =new Formatter();
		fmt.format("%d in hex is %<x", 255);  //< pointing to the same
		System.out.println(fmt);
		fmt.close();
		
		//using shortcut to format time and date (relative indexing)
		Formatter fmt3 = new Formatter();
		Calendar cal = Calendar.getInstance();
		fmt3.format("Today is day %te of %<tB, %<tY", cal); //e day, b month, y year
		System.out.println(fmt3);
		
		
		
		
		
		
	}

}
