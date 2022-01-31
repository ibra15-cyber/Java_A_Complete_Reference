package jcr.chp30.java.DateFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeFormatDemo {

	public static void main(String[] args) {
		Date date = new Date(); //a date obj
		DateFormat df;				// a dateformat obj
		
		System.out.println(date.getDay());
		
		df  =  DateFormat.getTimeInstance(DateFormat.SHORT, Locale.JAPAN); //specify how we want our date format
		System.out.println("Japan: " + df.format(date)); //we print it
		
		df  =  DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.KOREA); //specify how we want our date format
		System.out.println("Korea: " + df.format(date)); //we print it
		
		df  =  DateFormat.getTimeInstance(DateFormat.LONG, Locale.	UK); //specify how we want our date format
		System.out.println("UK: " + df.format(date)); //we print it
		
		df  =  DateFormat.getTimeInstance(DateFormat.FULL, Locale.US); //specify how we want our date format
		System.out.println("US: " + df.format(date)); //we print it
		
		
		
		//getTimeInstance is the opposite for getDateInstance

	}

}
