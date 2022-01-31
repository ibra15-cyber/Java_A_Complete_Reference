package jcr.chp23.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TwoCreateSocketConnectedToInternernic {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//socket too doesnt have a constructor
		//it takes a site and a port
		Socket s = new Socket("whois.internic.net", 43);
		
		//Input and output stream too do same
		//there invoke methods without having a constructor
		//so input and output streams opened on the socket
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		
		//if args.length = 0 go to oraclepressbooks.com else return first element of args ie web page
		//name of website to obtain information from; will be in string form
		String str = (args.length == 0? "OraclePressBooks.com": args[0] + "\n");
		
		//getting a bytes of our return into an array
		byte[] buf = str.getBytes();
		
		//we writing our array back into our output stream
		out.write(buf);
		
		//while our byte int num isnt -1 (end of the line)
		//print it
		//then close
		int c;
		while((c=in.read()) != -1) {
			System.out.println((char) c);
		}
		s.close();
	}

}
