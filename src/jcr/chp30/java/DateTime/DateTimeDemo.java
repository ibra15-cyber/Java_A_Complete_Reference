package jcr.chp30.java.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeDemo {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		System.out.println("LocalDate currently: "+ ld);
		
		LocalTime lt  = LocalTime.now();
		System.out.println("Local Time: Currently: " + lt);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Local date and time: " + ldt);

	}

}
