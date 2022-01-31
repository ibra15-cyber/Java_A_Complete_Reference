package jcr.chp20.java.utility;

import java.util.Locale;
import java.util.SimpleTimeZone;

public class TimeZoneDemo {

	public static void main(String[] args) {
		
//		SimpleTimeZone(int timeDelta, String tzName)
//		
//		SimpleTimeZone(int timeDelta, String tzId, int dstMonth0,int dstDayInMonth0, int dstDay0, int time0, int dstMonth1, int dstDayInMonth1, int dstDay1,int time1)
//		
//		SimpleTimeZone(int timeDelta, String tzId, int dstMonth0,int dstDayInMonth0, int dstDay0, int time0, int dstMonth1, int dstDayInMonth1, int dstDay1, int time1, int dstDelta)
//		
//		SimpleTimeZone(int timeDelta, String tzId, int dstMonth0,int dstDayInMonth0, int dstDay0, int time0,int time0mode, int dstMonth1, int dstDayInMonth1,int dstDay1, int time1, int time1mode, int dstDelta)

		SimpleTimeZone stz = new SimpleTimeZone(34, "FRENCH");
		System.out.println(stz.toString());
	
		//Locale time constructors
//		Locale(String language)
//		Locale(String language, String country)
//		Locale(String language, String country, String variant)
//	
		Locale lt = new Locale("GERMAN");
		System.out.println(lt.getLanguage()); //will print german
		System.out.println(lt.getDisplayName()); //german
		
		 
		
	
	
	
	}

}
