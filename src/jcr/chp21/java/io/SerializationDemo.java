package jcr.chp21.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class MyClass implements Serializable{
	String s;
	int i;
	double d;
	
	MyClass(String s , int i, double d){
		this.s = s;
		this.i = i;
		this.d = d;
	}
	
	public String toString()	{
		return "s=" + s + "; i = " + i + "; d=" + d;
	}
	
}
public class SerializationDemo {

	public static void main(String[] args) {
		
		//creating object output stream which raps file output stream
		//just like buffered writer wraps filewriter 
		//our filename is serial
		try( ObjectOutputStream objOstrm= 
				new ObjectOutputStream(new FileOutputStream("serial")) ){
			
			//we are making object of our class which we will pass into the obj output stream
			MyClass object1 = new MyClass("hello" , -7, 2.7e10);
			//this is returning what we want to serialize
			System.out.println("Object1: " + object1); 
			
			//we are writing our object into our output stream
			objOstrm.writeObject(object1);
		} catch(IOException e) {
			System.out.println("Exception during serialization: " +e);
	}
		
		
		//object deserialization
		
		//making our obj input stream just like buffered reader
		//wrapping filereader or inputstream reader 
		//we are reading our file serial
		try(ObjectInputStream objIStrm = 
				new ObjectInputStream(new FileInputStream("serial"))){
			
			//we are reading our object of our class type
			MyClass object2 = (MyClass) objIStrm.readObject()	;
			
			//printing it out
			System.out.println("object2: " + object2);
		} catch(Exception e) {
			System.out.println("Exception during deserializaton: " + e);
		}		
}
}