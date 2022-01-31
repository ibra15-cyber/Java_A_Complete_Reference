package jcr.chp30.java.DateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo4ParseTimeAndDate {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.parse(
				"June 21, 2018 12:01 AM", DateTimeFormatter.ofPattern(
				"MMMM d',' yyyy hh':'mm a"));
		
		System.out.println(ldt.format(
				DateTimeFormatter.ofPattern("MMMM d',' yyyy h':'mm a")));

	}

}
