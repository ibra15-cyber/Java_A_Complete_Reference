package jcr.chp21.java.io;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamDemo {

	public static void main(String[] args) {
		
		//we created a sting obj using stirng literal
		String tmp = "abcdefghijklmnopqrstuvwxyz";
		//then we got its bytes into an array
		
		byte[] b = tmp.getBytes()	;
		System.out.println(tmp.getBytes()); //getbyte method is in an array 
		
//		ByteArrayInputStream(byte array [ ])
//		ByteArrayInputStream(byte array [ ], int start, int numBytes)
		ByteArrayInputStream in1 = new ByteArrayInputStream(b);
		ByteArrayInputStream in2 = new ByteArrayInputStream(b, 0, 3); //only the first 3 indexes
		
		System.out.println(in1);
  
	}

}
