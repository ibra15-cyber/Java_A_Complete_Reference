package jcr.chp30.java.DateTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeDemo2 {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		System.out.println("Default: " + ld);
		System.out.println("Formated: " + ld.format(
				DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		
		//create a local date object
		//format our object with the date time formater
		//convert it to localized date using the Full format style
		LocalTime lt = LocalTime.now();
		System.out.println("Default: " + lt);
		System.out.println("Formated time: " + lt.format(
				DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
		
	}

}
