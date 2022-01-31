package jcr.chp21.java.io;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//creating an bytearrayoutputstream just like bufferedwriter or writer
		ByteArrayOutputStream f = new ByteArrayOutputStream();
		//creating a string 
		String s = "This should end up in an array"	;
		//invoking the bytes of the string and storing in array buf
		byte[] buf = s.getBytes();
		
		//we try to write into our byteoutputstream by passing our array
		//also not forget write need a try catch block
		try {
			f.write(buf);
		}catch(IOException e) {
			System.out.println("Error writing to buffer");
		}
		
		System.out.println("Buffer as a string");
		
		//convert of outputstream which contains our stream array back to string
		System.out.println(f.toString());
		System.out.println("into array");
		
		//invoke tobytearray on our outputstream and store the array
		//then loop through it and print each index
		//
		byte[] b = f.toByteArray();
		for(int i=0; i<b.length; i++) {
		System.out.print(b[i] +" ");  //bite equivalent
		//	System.out.print((char) b[i]); //char
		}
		System.out.println("\nTo an OutputStream()"); 
		//use try-with-resources to manage the file stream.
		//here we are creating a fileoutputstream just like filewriter 
		//we copy our bytearray into our fileoutputstream
		try(FileOutputStream f2 = new FileOutputStream("outputstream.txt")){
			f.writeTo(f2);
		} catch(IOException e) {
			System.out.println("I/O Error: " + e);
			return;
		}
		
		System.out.println("Doing a reset");
		f.reset();
		
		for(int i=0; i<3; i++)
			f.write('X');
		
		System.out.println(f.toString());
		
		
		

	}

}
