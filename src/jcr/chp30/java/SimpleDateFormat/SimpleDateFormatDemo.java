package jcr.chp30.java.SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {

	public static void main(String[] args) {
		
		Date date = new Date();
		SimpleDateFormat sdf;
		
		sdf = new SimpleDateFormat("hh:mm:ss"	);
		System.out.println(sdf.format(date));
		
		sdf  = new SimpleDateFormat("dd MMM yyy hh:mm:ss zzzz"); 
		//zzz = GMT
		//zzzz = Greenwhich mean time
		System.out.println(sdf.format(date));
		
		sdf = new SimpleDateFormat("E MM dd yyyy");
		System.out.println(sdf.format(date));
				

	}

}
