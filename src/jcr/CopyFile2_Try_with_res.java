package jcr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile2_Try_with_res {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int i;
		
		//Confirming file specified
		if(args.length != 2){ //means it can't open more than 2 files: args 0, 1 means 2 files
			System.out.println("Usage: Showfile filename");
			return ;
		}
		
		// using try with resources to open file. file will be closed automatically
		// fin is local to try block hence exited when the try block completes
		//hence it doesn't need close() to close the file
		try(FileInputStream fin = new FileInputStream(args[0]);
				FileOutputStream fout = new FileOutputStream(args[1])){
			
			do {
				i = fin.read();
				if(i != -1)
					fout.write(i);
			} while(i != 1);
			
		} catch(FileNotFoundException e) {
			System.out.println("I/O Error: ." + e);
		} }
}
