package jcr.chp20.java.utility;

import java.util.StringTokenizer;

public class StringTokenizerDeprAndReplacedByRegExpr {
	
	//static variable
	static String in = "title=Java: The Complete Reference;"
			+ "autor=Schildt;"
			+ "publisher=Oracle Press;"
			+ "copyright=2019";

	public static void main(String[] args) {
//		StringTokenizer(String str)
//		StringTokenizer(String str, String delimiters)
//		StringTokenizer(String str, String delimiters, boolean delimAsToken)
		
		StringTokenizer st = new StringTokenizer(in, "=;"); //= is a delimeter 
		
		
		while(st.hasMoreTokens()) {	
			String key = st.nextToken();
			String val = st.nextToken();
			System.out.println(key + "\t" + val); 
		}
		
		

	}

}
