package jcr.chp30.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr8 {

	public static void main(String[] args) {
		//use replaceAll to replace any word that begins with Jon
		//.to the end
		//zero or more times
		//zero or one time
		//so replace everything to the space
		String str = "Jon Jonathan Frank Ken Todd";
		Pattern pat = Pattern.compile("Jon.* "); 
		Matcher mat = pat.matcher(str);
		
		System.out.println("original string "+ str);
		str = mat.replaceAll("Eric ");
		System.out.println("Modified sequence: " + str);
		
	}

}
