package jcr.chp21.java.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumerator implements Enumeration<FileInputStream>{
	private Enumeration<String> files;
	
	InputStreamEnumerator(Vector<String> files){
		this.files = files.elements();
	}
	
	public boolean hasMoreElements()	{
		return files.hasMoreElements();
	}
	
	public FileInputStream nextElement() {
		try {
			return new FileInputStream(files.nextElement().toString());
		} catch(IOException e ) {
			return null;
		}
	}
}

public class SequenceInputStreamDemoAnExercise {

	public static void main(String[] args) {
		
		int c;
		//defining a collection to hold our files 
		Vector<String> files = new Vector<String>();
		
		//adding the elements to our vector. they are supposed to be of a string 
		files.addElement("fill1.txt");
		files.addElement("fill2.txt");
		files.addElement("fill3.txt");
		
		//inputstreamenumeratero is taking our collection
		InputStreamEnumerator ise = new InputStreamEnumerator(files);
		//and input stream is taking our input stream enumerator
		InputStream input = new SequenceInputStream(ise);
		try {
			//while our int or byte return is not equal to -1
			//print that and convert that byte to char instead of byte
			while((c=input.read())!= -1)
				System.out.println((char) c);
		} catch(NullPointerException e	 ) {
			System.out.println("I/O error: " + e);
		}catch(IOException e) {
			System.out.println("Error opening file");
		}  finally {
			try {
				input.close();
			} catch(IOException e) {
				System.out.println("Error closing sequence input stream");
			}
		}
	
		

	}

}
