package jcr.chp21.java.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//try with resource
		//read file and open filewriter2 which will be in byte form
		try(FileReader fr = new FileReader("fileWriter2.txt")){
			int c;
			
			//while the byte isn't = -1 which is the end of the file
			while((c=fr.read()) != -1 )
				//c will read bytes
				//to char cast
				System.out.print((char) c);
		} catch(IOException e) {
			System.out.print("I/O Error: " + e);
		}

	}

}
