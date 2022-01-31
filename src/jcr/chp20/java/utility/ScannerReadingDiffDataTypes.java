package jcr.chp20.java.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerReadingDiffDataTypes {

	public static void main(String[] args) throws IOException {
		
		int i;
		double d;
		boolean b;
		String str;
		
		//write output to a file
		FileWriter wtf = new FileWriter("Test3.txt");
		wtf.write("Testing Scanner 10 12.2 one true two false");
		wtf.close();
		
		FileReader fin = new FileReader("Test3.txt");
		//defining with scanner and buffered reader
		Scanner sc = new Scanner(fin);
		BufferedReader br = new BufferedReader(fin);
	//ystem.out.println("Reading using bufferedReader: " + br.readLine());
		
		while(sc.hasNext()) {
			if(sc.hasNextInt()) {
				i  = sc.nextInt();
				System.out.println("int: " + i);
			} else if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				System.out.println("double: " + d);
			}	else if (sc.hasNextBoolean()) {
				b = sc.nextBoolean();
				System.out.println("boolean: " + b);		
			}else { 
				str = sc.next();
				System.out.println("String: " + str);
			}
		}
		
		sc.close();
		
		

	}

}
