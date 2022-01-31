package jcr.chp20.java.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) throws FileNotFoundException {
		//scanner 1
//		Scanner sc22 = new Scanner(System.in);
//		
//		//scanner 2 like BuffereReader
//		FileReader fin = new FileReader("Test.txt");
//		Scanner sc2 = new Scanner(fin);
//		
//		//scanner 3rd
////		String instr = "10 99.88 scanning is easy";
////		Scanner conin = new Scanner(instr);
////		conin.next();
//		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		double sum = 0.0;
		System.out.println("Enter numbers to average");
		
		while(sc.hasNext()) {												//
			if(sc.hasNextDouble()) {
				sum += sc.nextDouble();
				count++;
			}else {
				String str = sc.next();
				if(str.equals("done")){
					break;
				}
				else {
					System.out.println("Data format error");
					return;
				}
			}
			
		
		}
			sc.close();
			System.out.println("Average is " + sum/count);
			
		
		
		
		

	}

}
