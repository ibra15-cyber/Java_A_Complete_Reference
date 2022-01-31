package jcr.chp20.java.utility;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerDelimeters {

	public static void main(String[] args) throws IOException {
		
		int count = 0;
		double sum = 0.0;
		
		//write to file
		FileWriter fw = new FileWriter("Test4txt");
		fw.write("2, 3.4,  5,6, 7.4, 9.1, 10.5, done");
		fw.close();
		
		FileReader rf = new FileReader("Test4.txt");
		Scanner sc = new Scanner(rf);
		
		sc.useDelimiter(", *"); 
		
		//read and sum
		while(sc.hasNext()) {
			if(sc.hasNextDouble()) {
				sum += sc.nextDouble();
				count++;
			}
			else {
				String str = sc.next();
				if(str.equals("done")) break;
				else {
					System.out.println("File format error");
				}
			}
		}
		sc.close();
		System.out.println("Average is " + sum/count);
		
		
		//.................................................me trying to print back the delimeter................
		//returning delimiter from our file using scanner
		Pattern strp = sc.delimiter();
		System.out.println(strp);
		
		

	}

}
