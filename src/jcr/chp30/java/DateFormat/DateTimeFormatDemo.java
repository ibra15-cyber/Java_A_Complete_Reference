package jcr.chp30.java.DateFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeFormatDemo {

	public static void main(String[] args) {
		Date date = new Date(); //a date obj
		DateFormat df;				// a dateformat obj
		
		df  =  DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.JAPAN); //specify how we want our date format
		System.out.println("Japan: " + df.format(date)); //we print it
		
		df  =  DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.KOREA); //specify how we want our date format
		System.out.println("Korea: " + df.format(date)); //we print it
		
		df  =  DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.	UK); //specify how we want our date format
		System.out.println("UK: " + df.format(date)); //we print it
		
		df  =  DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.US); //specify how we want our date format
		System.out.println("US: " + df.format(date)); //we print it
		
		//so dateFormat handles both date and time
		//first instance  is date, second is time
		
		

	}

}
