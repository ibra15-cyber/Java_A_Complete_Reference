package jcr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile3Try_with_reso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i;
		
		//Confirming file specified
		if(args.length != 1){
			System.out.println("Usage: Showfile filename");
			return ;
		}
		
		// using try with resources to open file. file will be closed automatically
		// fin is local to try block hence exited when the try block completes
		//hence it doesn't need close() to close the file
		try(FileInputStream fin = new FileInputStream(args[0])){
			
			do {
				i = fin.read();
				if(i != -1)
					System.out.println((char) i);
			} while(i != 1);
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
		} catch(IOException e) {
			System.out.println("an i/o Error Occurred");
			
		}
	}

}
