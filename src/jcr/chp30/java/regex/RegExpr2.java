package jcr.chp30.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr2 {

	public static void main(String[] args) {
		Pattern pat = Pattern.compile("Java");
		Matcher mat = pat.matcher("Java SE");
		System.out.println("Looking for Java in Java SE.");
		
		if(mat.find())
			System.out.println("Subsequence found");
		else
			System.out.println("No match");
		
		//javaScript type
//		/abc/.test("abc") //true
		System.out.println(Pattern.compile("abc").matcher("abc"));
		
		
		}

}
