package jcr.chp21.java.io;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriterDemo {

	public static void main(String[] args) throws IOException {
		
		//creating char array writer obj
		CharArrayWriter f = new CharArrayWriter()	;
		
		String s = "this should end up in the array";
		
		//our array takes the length of the string
		char[] buf = new char[s.length()];
		
		//get chars of our string
		s.getChars(0, s.length(), buf, 0);
		
		//try to write our array into our char array writer
		try {
			f.write(buf);
		}catch(IOException e)	{
			System.out.println("Error Writing to Buffer");
		}
		
		System.out.println("Buffer as a string");
		System.out.println(f.toString());
		System.out.println("Info Array");
		
		char[] c = f.toCharArray();
		for(int i = 0; i<c.length; i++) {
			System.out.print(c[i]);
		}
		
		
		//sending it to  a file
		System.out.println("To a FileWriter");
		
		try(FileWriter f2  = new FileWriter("charArrayfile.txt")){
			f.writeTo(f2);
		} catch(IOException e	) {
			System.out.println("I/O Error: " + e);
		}
		
		System.out.println("Doing a reset");
		f.reset();
		
		for(int i =0; i<3; i++)
			f.write("x");
		System.out.println(f.toString());
		

	}

}
