package jcr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i;
		FileInputStream fin = null;
		FileOutputStream fout =null;
		
		//confirm file name has been specified
		if(args.length != 2) {
			System.out.println("Usage: ShowFile filename");
			return;
		}
		
		//open file : attempt to open
		try {
			fin = new FileInputStream(args[0]);
			fout = new FileOutputStream(args[1]);
			
			
			do {
				i = fin.read();
				if(i!=-1) {
					fout.write(i);
				} 
			}while(i != -1);
			
		}catch (IOException e) {
			System.out.println("I/O Error: " + e);
		} finally {
			//close file in all cases
			try {
				if(fin != null) {
					fin.close()	;
				}
			}catch(IOException e2) {
					System.out.println("Error Closing InputFile");
				}
			try {
				if (fout != null)
					fout.close()	;
			} catch (IOException e2) {
				System.out.println("Error Closing Output File");
			}
			}
		}

}
