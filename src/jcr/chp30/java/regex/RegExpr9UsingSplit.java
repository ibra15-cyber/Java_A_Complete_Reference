package jcr.chp30.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr9UsingSplit {

	public static void main(String[] args) { 
		//delimeters to split a string
		Pattern pat  = Pattern.compile("[ ,.!]"); //compiling a pattern
		
		//applying split on pattern object
		String[] strs = pat.split("one two,alpha9 12!done.");
		
		//printing our pattern
		for(int i = 0; i<strs.length; i++)
			System.out.println("next token: " + strs[i]);
		
		
		//..............................USING STRING TO APPLY MATCH
		System.out.println("abcdef".matches("abcd"));
		
		//.................................Matching without pattern
		System.out.println(match);
		
	}

}
