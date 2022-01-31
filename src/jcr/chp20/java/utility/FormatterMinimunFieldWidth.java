package jcr.chp20.java.utility;

import java.util.Formatter;

public class FormatterMinimunFieldWidth {

	public static void main(String[] args) {
		Formatter fmt = new Formatter();
		
		fmt.format("|%f|%n|%12f|%n|%012f|", 10.12345, 10.12345, 10.12345);
		System.out.println(fmt);
		
		
//		The first line displays the number 10.12345 in its default width. The second
//		line displays that value in a 12-character field. The third line displays the value
//		in a 12-character field, padded with leading zeros
	}

}
