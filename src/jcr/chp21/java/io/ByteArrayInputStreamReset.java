package jcr.chp21.java.io;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamReset {

	public static void main(String[] args) {
		//creating a string
		String tmp = "abc";
		//getting the bytes of our string
		byte[] b = tmp.getBytes();
		//creating a byte object and passing our byte array
		ByteArrayInputStream in = new ByteArrayInputStream(b);
		
		//looping the array
		for(int i =0; i<2; i++) {
			//on condition the returned output isnt -1
				int c;
				while((c = in.read()) != -1) {
					//if our i == 0 it prints abc in lower but when i=1 it prints ABC
					//so if our i == 0 print abc
					//else print ABC
					if(i == 0) {
						System.out.print((char) c);
					}else {
						System.out.print(Character.toUpperCase((char) c));
					}
				}
				
				System.out.println();
				in.reset();
		
		}
		
	}

}
