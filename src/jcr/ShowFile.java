/**
 * 
 */
package jcr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author dell
 *
 */
public class ShowFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		FileInputStream fin;
		
		if(args.length != 1) {
			System.out.println("Usage: ShowFile filename");
			return;
		}
		
		//attempt to open a file
		try {
			fin = new FileInputStream(args[0]);
		} catch(FileNotFoundException e) {
			System.out.println("Cannot open file" + e);
			return;
		}
		
		//file read to be read
		try {
			do {
				i = fin.read();
				if(i != -1) {
					System.out.print((char) i);
				} 
			} while(i != -1);
		}catch(IOException e) {
				System.out.println("Error Reading File");
			}
			
			//close file
			try {
				fin.close();
			}catch(IOException e) {
				System.out.println("Error closing file");
			}
		}
		
}

