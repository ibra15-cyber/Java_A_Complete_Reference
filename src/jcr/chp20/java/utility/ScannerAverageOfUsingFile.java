package jcr.chp20.java.utility;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerAverageOfUsingFile {

	public static void main(String[] args) throws IOException {
		
		int count = 0;
		double sum = 0.0;
		
		//write to a file to a file
		FileWriter wtf = new FileWriter("test2.txt");
		wtf.write("2 3.4 5 6 7.4 9.1 10.5 done");
		wtf.close();
		
		//read file 
		FileReader fin = new FileReader("test2.txt");
		
		//use can either use scanner or BufferedReader br = new BufferedReader()
		//scanner is reading our opened file
		Scanner sc = new Scanner(fin);
		
		//read and sum numbers.
		while(sc.hasNext()) {       //take for scanner
			if(sc.hasNextDouble()){	//if its double
				sum += sc.nextDouble(); //add it to sum
				count ++;
			}
			else { 	//else to take control of the string 
				String st = sc.next();
				if(st.equals("done")) {
					break;
				}else {
					System.out.println("File format error.");
					return;
				}
			}
		}
		
		sc.close();
		System.out.println("Average is " + sum/count);
		
		
		

	}

}
