package jcr.chp23.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class FiveURLConnectionDemo {

	public static void main(String[] args) throws IOException {
		
		int c;
		//collect a url 
		URL hp = new URL("http://www.internic.net");
		
		//open connection on url
		URLConnection hpcon = hp.openConnection();
		
		//get property on our opened connection
		long d = hpcon.getDate()	;
		if(d==0)
			System.out.println("no date information");
		else {
			System.out.println("Date; " + new Date(d));
		}
		
		//get content of our opened connection
		System.out.println("Content-Type: " + hpcon.getContentType());
		
		//get the expiration date 
		//so d here is get expiration 
		d=hpcon.getExpiration();
		if(d==0)
			System.out.println("No expiration information.");
		else {
			System.out.println("Expires: " + new Date(d));
		}
		
		d = hpcon.getLastModified();
		if(d==0)
			System.out.println("No last modified information");
		else {
			System.out.println("Last-Modified: " + new Date(d));
		}
		
		//with content length -1 means end of the file
		long len = hpcon.getContentLengthLong();
		if(len==-1)
			System.out.println("Content length unvailable");
		else
			System.out.println("content-length: " + len);
		
		//if not 0 do this
		if(len != 0) {
			System.out.print("=== Content ===");
			//invoke input stream on our opened hp connection
			//if our byte int value isn't -1: end of the file
			//print chars
			InputStream input = hpcon.getInputStream();
			while(((c=input.read()) != -1)) {
				System.out.print((char) c);
			}
			input.close();
		} else
			System.out.println("No content available");
		
	
		
		
		
		
	}

}
