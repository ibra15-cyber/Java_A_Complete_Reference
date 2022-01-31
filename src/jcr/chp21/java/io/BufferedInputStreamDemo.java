package jcr.chp21.java.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {

	public static void main(String[] args) {
		//a string s is created
		String s = "This a &copy; copyright symbol "
				+ "but this &copy not. \n";
		
		//we use getbytes to get the the s byte repr and placed it in an array buf
		byte[] buf = s.getBytes();
		
		//we create byte array to take our byte array
		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		
		//declaring c and marked,  initially as false
		int c;
		boolean marked = false;
		
		//try to use bufferedInputStream just like bufferedreader to take a reader which is a byte arra
		try(BufferedInputStream f = new BufferedInputStream(in)){
			//a condition, while c = our f.read stored as c and shouldnt be -1
//			System.out.println(f.read()); //returns 84
			//that's: we are reading all the bytes in the array list passed into the buffinput
			while((c = f.read()) != -1) {
				
				//we gonna use switch to control what is it that we want
				//we pasing our int c = f.read which is the outcome of f.read
				//so switch is taken f.read() which returns int
				switch(c) {
				//when & is encounted and mark is true which is the negation of false
					case '&':
						if(!marked) { //this will be true hence the code will run
							//f.mark(32)
							f.mark(32);
							//then turn marked true
							marked = true; 
						} else {
							//else make marked false
							marked = false;
					}
					break;
					
					//if ; is met, and marked is true, make mark false
					//then go on to print (c)
					//else return the char conversion of c
					case ';':
						if(marked) { //marked has been made true by the first code
							marked = false; //make it false
							System.out.print(" (c) ");
						} else {
							System.out.print((char) c);	
						}
						break;
					
					// if case ' ' is met, marked is false, make marked false
						//reset our f===bufferedinputstream
						//else return char of c
				case ' ':
					if(marked) { //this wont run because marked is still false
						marked = false;
						f.reset();
						System.out.print("&");
					} else {
						System.out.print((char) c);
					}
					break;
					
					//else return the default, incase all else fails
					//if marked is true print the char and break
					default:
						if(!marked)
							System.out.print((char)c);
						break;
					
				}
			}
		} catch(IOException e) {
			System.out.println("I/O error: " + e);
		}
		boolean boy = false;
		if(!boy) {
			System.out.println("this will print: for its the negation of false");
			boy = true;
			if(boy)
			System.out.println("this too will print");
			boy = false;
			if(boy)
				System.out.println("this wont print");
		}

	}

}
