package jcr.chp21.java.io;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackReaderDemo {

	public static void main(String[] args) throws IOException {
		
		String s = "if (a==4) a = 0;\n";
		char[]	buff = new char[s.length()];
		s.getChars(0, s.length(), buff, 0);
		CharArrayReader in = new CharArrayReader(buff);
		
		int c;
		
		try(PushbackReader f = new PushbackReader(in)){
			while((c = f.read()) != -1) {
				switch(c) {
					case '=':
						if((c=f.read()) == '=')
							System.out.println();
						else {
							System.out.print("<-");
							f.unread(c);
						}
						break;
					default:
						System.out.print((char) c);
						break;
				}
			}
		}catch(IOException e) {
			System.out.println("I/O Error: " + e);
		}
	}
}
