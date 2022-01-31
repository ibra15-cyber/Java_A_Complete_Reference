package jcr.chp30.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr7 {

	public static void main(String[] args) {
		//use a character class
		Pattern pat = Pattern.compile("[a-z]+"); //shortest pattern then next
		Matcher mat = pat.matcher("this is a test");
		while(mat.find())
			System.out.println("Match: " + mat.group()); 
			}

}
