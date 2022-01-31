package jcr.chp30.java.DateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo3CustomDateTime {

	public static void main(String[] args) {
		//demonstrating of patter method
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.format(
				DateTimeFormatter.ofPattern("MMMM d', ' yyyy h':'mm a")));
				//month in string; date,
				//year; hour
				//min; am/pm

	}

}
