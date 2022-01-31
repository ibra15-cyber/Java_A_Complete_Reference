package jcr.chp21.java.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushBackInputStreamDemo {

	public static void main(String[] args) {
		//we create a string
		String s = "if (a == 4) a = 0;\n";
		//we change it into a byte and save the array
		byte[] buf = s.getBytes();
		
		//.............................tyring to print the byte rep of our string................
		System.out.print("our string s, " + s + " in byte are: ");
		for (byte b : buf)
			System.out.print(b + " ");
		//..............................................................................................................
		
		//reading it in our byte arrayinputstream
		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		int c;
		
		//passing it in pushbackinput stream
		try(PushbackInputStream f = new PushbackInputStream(in)){
			//while f.read which returns an int isnt = -1
			//pass c, byte values into our switch
			//if we meet = print .eq. else print <-
			while((c = f.read() ) != -1) {
				switch(c) {
					case '=':
						if((c = f.read()) == '=')
							System.out.print(".eq."); //replace = with .eq.
						else {
							System.out.print("<-");
							f.unread(c); //unread makes it forget the application the second r
							//round just like reset hence it goes with the second option <-
						}
						break;
				default: 
					System.out.print((char) c);
					break;
				}
			}
		}catch(IOException e) {
			System.out.print("I/O Error: " + e);
		}

}
}
