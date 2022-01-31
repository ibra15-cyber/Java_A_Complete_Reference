package jcr.chp22.java.nio;

import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.*;

public class NIOCopy {

	public static void main(String[] args) {
		
		if(args.length !=2) {
			System.out.println("usage: copy from to " );
			return;
		}
		
		try {
			Path source = Path.of(args[0]);
			Path target = Path.of(args[1]);
			
			//copy the file
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
			
		}catch (InvalidPathException e) {
			System.out.println("Path Error " + e);
		}catch (IOException e) {
			System.out.println("I/O Error " + e);
		} 

	}

}
