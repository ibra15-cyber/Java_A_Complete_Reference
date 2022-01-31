package jcr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//to reaed from a file 
		//BufferedReader br2 = new BufferedReader(new FileReader("source"));
		System.out.println("Enter a string but q to quit." );
		
		//read characters
		char c;

		do {
			//c = (char) br.read(); //obj br.read and convert byte to char and assign to c
			c = (char) br.read();
			System.out.println(c);
			
//			System.out.println("this shd print"); //but here we are dealing with read from system
		} while(c != 'q'); //c is character so != works
	}

}
