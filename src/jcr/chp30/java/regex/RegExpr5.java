package jcr.chp30.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr5 {

	public static void main(String[] args) {
		//wilcard and quantifier
		Pattern pat = Pattern.compile("e.+d"); //begins with e and ends with d
																//will go for longest pattern that matches
																// hence: extend cup end
		Matcher mat = pat.matcher("extend cup end table");
		
		while(mat.find())
			System.out.println("Match: " + mat.group());

	}

}
