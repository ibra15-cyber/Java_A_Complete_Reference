package jcr.chp21.java.io;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderDemo {

	public static void main(String[] args) throws IOException {
		
		String tmp = "abcdefghijklmniopqrstuvwxyz";
		//int length = tmp.length();
		char[] c = new char[tmp.length()];
		//getting the chars  just like the tmp.getBytes in the previous examples
		tmp.getChars(0, tmp.length(), c, 0);
		int i;
		try(CharArrayReader input1 = new CharArrayReader(c)){
			System.out.print("Input is: ");
			while((i= input1.read()) != -1	) {
				//i alone will be printing a byte
				//cast with cahr
				System.out.print((char)i);
			}
			System.out.println();
		}catch (IOException e) {
			System.out.println("I/O Error: " + e);
		}
		
		
		//this will read only the first five chars
		try(CharArrayReader input2 = new CharArrayReader(c, 0, 5)){
			System.out.print("Input is: ");
			while((i= input2.read()) != -1	) {
				//i alone will be printing a byte
				//cast with cahr
				System.out.print((char)i);
			}
			System.out.println();
		}catch (IOException e) {
			System.out.println("I/O Error: " + e);
		}

	}

}
