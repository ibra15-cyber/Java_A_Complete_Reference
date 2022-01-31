package jcr.chp22.java.nio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class ShowFile {

	public static void main(String[] args) throws IOException {
		
		int i ;
		
		//first confirm that a filename has been speicified
		
		if(args.length != 1) {
			System.out.println("Usage: showFile filename");
			return;
		}
		
		//open the file and obtain a stream linked to it
		try(InputStream fin = Files.newInputStream(Path.of(args[0]))){
			do {
				i = fin.read();
				if(i != -1)
					System.out.println((char) i);
			}while(i!=-1);
		}catch (InvalidPathException e) {
			System.out.println("Path Error " + e);
		}catch (IOException e) {
			System.out.println("I/O Error " + e);
		}

	}

}
