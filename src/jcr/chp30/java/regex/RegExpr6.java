package jcr.chp30.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr6 {

	public static void main(String[] args) {
		Pattern pat = Pattern.compile("e.+?d"); //shortest pattern then next
		Matcher mat = pat.matcher("extend cup end table");
		while(mat.find())
			System.out.println("Match: " + mat.group()); 
		
		Pattern pat2 = Pattern.compile("e.?+d"); //shortest pattern then next
		Matcher mat2 = pat2.matcher("extend cup end table");
		while(mat2.find())
			System.out.println("Match2: " + mat2.group()); 
	}

}