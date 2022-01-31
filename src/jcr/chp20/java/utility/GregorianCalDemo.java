package jcr.chp20.java.utility;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalDemo {

	public static void main(String[] args) {
		
//		GregorianCalendar(int year, int month, int dayOfMonth)
//		GregorianCalendar(int year, int month, int dayOfMonth, int hours, int minutes)
//		GregorianCalendar(int year, int month, int dayOfMonth, int hours, int minutes, int seconds)

		//another version
//		GregorianCalendar(Locale locale)
//		GregorianCalendar(TimeZone timeZone)
//		GregorianCalendar(TimeZone timeZone, Locale locale)
		
		String[]  months= {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 	"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		
	
		int year;
		GregorianCalendar gcal = new GregorianCalendar();
		
		System.out.println("Date: " + gcal.get(Calendar.MONTH) + ":" + gcal.get(Calendar.DATE) + ":" + (year = gcal.get(Calendar.YEAR)) );
		
		System.out.println("TIME: " + gcal.get(Calendar.HOUR) + ":" + gcal.get(Calendar.MINUTE) + ":" + gcal.get(Calendar.SECOND) );

		//TEST CURRENT YEAR IS A LEAP YEAR	
	 
		if(gcal.isLeapYear(year)) {
			System.out.println("The year " + year + " is a leap year");
		} else {
			System.out.println("The year, " + year + " is not a leap year");
		}
		
		
		
		
	}

}
