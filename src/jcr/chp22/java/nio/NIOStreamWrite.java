/**
 * 
 */
package jcr.chp22.java.nio;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class NIOStreamWrite {

	public static void main(String[] args) throws IOException {
		
		//open the file and obtain a stream linked to it.
		try(OutputStream fout = 
				new BufferedOutputStream(
						Files.newOutputStream(Path.of("niostreamwriter.txt")))){
			
			//write some bytes to the stream
			//this code wrties abc to the file
			for(int i = 0; i< 26; i ++)
				fout.write( (byte) ('A' + i));	
		}catch (InvalidPathException e) {
			System.out.println("Path Error " + e);
		}catch (IOException e) {
			System.out.println("I/OError " + e);
		}

	}

}
