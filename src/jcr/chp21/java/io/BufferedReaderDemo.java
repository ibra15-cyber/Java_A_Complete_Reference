package jcr.chp21.java.io;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;

public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		
		//we created a string literal
		String s = "This is a &copy; copyright symbol"
				+ " but this is &copy not.\n	";
		//we create a an array of char return type
		char[ ] buff = new char[s.length()];
		//where we seeking the chars of our string
		s.getChars(0, s.length(), buff, 0);
		
		//creating a char array reader just like file reader which takes a source
		CharArrayReader in = new CharArrayReader(buff);
		int c ;
		boolean marked = false;
		
		//trying to wrap our reader in a buffer reader
		try(BufferedReader f = new BufferedReader(in)){
			//f.read returns an int and it should not be equal -1
			//which is the end of the line
			while((c=f.read())!= -1) {
				//our switch case: does what ever the situation permits
				switch(c) {

					case '&':								//if & is reached
						if(!marked) {					//and mark is true
							f.mark(32);					//do this 
							marked = true;			//and change mark to true
						}else {								//else if marked is still false
							marked = false;			//make marked false
						}
						break;
						
					case ';':									//if this ; is reached
						if (marked) {					//and marked is false
							marked = false;			//make marked false
							System.out.print("(c)");//then print this
						} else {									//else if marked is true
							System.out.print((char) c); 	//and ; is met change it to char
						}
						break;
						
					case ' ':										//if this ' ' is met
						if (marked) {						//and marked is false
							marked = false;				//marked is false
							f.reset();							//reset mark
							System.out.print("&");	//then print this
						}else {									//if marked is true
							System.out.print((char) c);	//produce the char ' ' 
						}
						break;
						
						default:										//finally do this
							if(!marked) {							//if marked is true
								System.out.print((char) c); //print the char
							}
							break;
				}
			}
		} catch(IOException e ) {
			System.out.println("I/O Error: " +e);
		}
	}
}
