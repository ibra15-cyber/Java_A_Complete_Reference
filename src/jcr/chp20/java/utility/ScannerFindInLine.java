package jcr.chp20.java.utility;

import java.util.Scanner;

public class ScannerFindInLine {

	public static void main(String[] args) {
		
//		String findInLine(Pattern pattern)
//		String findInLine(String pattern)
		
		String str = "Name: Tom Age: 28 ID: 77";
		
		Scanner sc = new Scanner(str);
		//so scanner takes System.in console
		//also takes a file open for reaed
		//and now str
		
		sc.findInLine("Age:"); //find age
		
		
		if(sc.hasNext()) {
			System.out.println(sc.next());
		}
		else
			System.out.println("Error");
		
		sc.close();
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//		sc.findWithinHorizon(str, 2);
//		if(sc.hasNext()) {
//			System.out.println(sc.next());
//		}
//		else
//			System.out.println("Error");
//		
//		sc.close();
		//also 
//		String findWithinHorizon(Pattern pattern, int count)
//		String findWithinHorizon(String pattern, int count)

		

	}

}
