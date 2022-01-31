package jcr.chp21.java.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		
		//string literal created
		String source = "Now is the time for all good men\n"
				+ " to come to the aid of their country\n"
				+ " and pay their due taxes";
		
		// create a char that takes the length of our string
		//its like putting each char in in an array
		char[] buffer = new char[source.length()];
		
		//get chars from index 0 to the length of the string then pass the 
		//buffer array 
		source.getChars(0,  source.length(), buffer, 0);
		
		
		try(FileWriter f0 = new FileWriter("fileWriter1.txt");
				FileWriter f1 = new FileWriter("fileWriter2.txt");
				FileWriter f2 = new FileWriter("fileWriter3.txt")){
			
			//write to first file 
			//iterate the buffer and print each into file one
			for(int i =0; i<buffer.length; i +=2) {
				f0.write(buffer[i]);
			}
			
			//write to second file
			//the second file takes the buffer array
			f1.write(buffer);
			
			//write to third file 
			f2.write(buffer, buffer.length/4, buffer.length/4);
		}catch (IOException e) {
			System.out.println("An I/O error occurred");
		}
				

	}

}
