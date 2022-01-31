package jcr.chp20.java.utility;

import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		
		//Date()
		//Date(long millisec)
		//Calender implements the date objects better
		Date date = new Date();
		
		//display date
		System.out.println(date);
		
		
		long msec = date.getTime();
		System.out.println("Milliseconds since Jan. 1, 1970 GMT " + msec);
		
		//............................................mine..............................................................
		int msec2 = (int) date.getTime();
		System.out.println("Milliseconds since Jan. 1, 1970 GMT " + msec2);

	}

}
