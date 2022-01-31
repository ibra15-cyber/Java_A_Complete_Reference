package jcr.chp20.java.utility;

import java.util.Calendar;
import java.util.Formatter;

public class FormatterTimeAndDateFormatting {

	public static void main(String[] args) {
	
		Formatter fmt = new Formatter();
		Calendar cl = Calendar.getInstance();
		
		//display standard 12-hour time format
		fmt.format("%tr", cl);
		System.out.println(fmt);
		fmt.close();
		
		//display complete time and date information
		fmt = new Formatter();
		fmt.format("%tc", cl);
		System.out.println(fmt);
		fmt.close();
		
		//display jsut hour and minute
		fmt = new Formatter()	;
		fmt.format("%tl:%tM", cl, cl);
		System.out.println(fmt);
		fmt.close();
		
		//display month by name and number
		fmt = new Formatter();
		fmt.format("%tB %tb %tm", cl, cl, cl);
		System.out.println(fmt);
		fmt.close();
		

	}

}
