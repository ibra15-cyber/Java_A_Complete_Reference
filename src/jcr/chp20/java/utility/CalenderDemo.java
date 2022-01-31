package jcr.chp20.java.utility;

import java.util.Calendar;

public class CalenderDemo {

	public static void main(String[] args) {
	
		String[]  months= {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 	"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		
		//calender has methods with no constructor
		Calendar calendar = Calendar.getInstance();
		
		//calendarObj.get(Calendar.VARIABLE);
		//VARIABLE = MONTH, DATE, YEAR, HOUR, MINUTE AND SECOND
		System.out.print("Date: " );
		System.out.print(months[calendar.get(Calendar.MONTH)]);  //this will print july but without month[	] it will will be 6 for index begins at 0; 
		System.out.print(" " + calendar.get(Calendar.DATE) + " ");
		System.out.println(calendar.get(Calendar.YEAR));
		
		System.out.print("Time: " );
		System.out.print(calendar.get(Calendar.HOUR) + ":");
		System.out.print(calendar.get(Calendar.MINUTE) + ":");
		System.out.print(calendar.get(Calendar.SECOND));
		
		//SETING TIME AND DATE
		calendar.set(Calendar.HOUR, 10);
		calendar.set(Calendar.MINUTE, 29);
		calendar.set(Calendar.SECOND, 22);
		
		System.out.println();
		System.out.println("Updated time: ");
		System.out.print(calendar.get(Calendar.HOUR) + ":") ;
		System.out.print(calendar.get(Calendar.MINUTE) );
		System.out.print(calendar.get(Calendar.SECOND)+ "\n");
		
		//mine
		System.out.print("Our created time is: " + calendar.get(Calendar.HOUR) + ":"
				+ calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
		
		
		
	}

}
