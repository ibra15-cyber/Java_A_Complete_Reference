package jcr.chp30.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr4 {

	public static void main(String[] args) {
		Pattern pat = Pattern.compile("W+"); //+ one or more time
																// * zero or more
																//? zero or one'
		Matcher mat = pat.matcher("W WW WWW");
		
		while(mat.find())
			System.out.println("Match: " + mat.group());

	}

}
