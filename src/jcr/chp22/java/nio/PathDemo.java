package jcr.chp22.java.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class PathDemo {

	public static void main(String[] args) {
		
		Path filepath = Path.of("examples\\test.txt");
		
		System.out.println("file name: " + filepath.getFileName());
		System.out.println("Path: " + filepath);
		System.out.println("Absolute path: " + filepath.toAbsolutePath());
		System.out.println("parent; " + filepath.getParent());
		
		if(Files.exists(filepath))
			System.out.println("File Exit");
		else {
			System.out.println("File does not exit");
		}
		
		try {
			if(Files.isHidden(filepath))
				System.out.println("Files is hidden");
			
			else
				System.out.println("file is not hidden");
		} catch (InvalidPathException e) {
			System.out.println("Path Error " + e);
		}catch (IOException e) {
			System.out.println("I/OError " + e);
		}
		
		Files.isWritable(filepath);
		System.out.println("file is writable");
		
		Files.isReadable(filepath);	
		System.out.println("file is readable");
		
		try {
			BasicFileAttributes attribs= Files.readAttributes(filepath, BasicFileAttributes.class);
			
			if(attribs.isDirectory())
				System.out.println("The file is a directory");
			else
				System.out.println("not a directory");
			
			if(attribs.isRegularFile())
				System.out.println("file is a normal file");
			
			else
				System.out.println("the file is not a normal file");
			
			if(attribs.isSymbolicLink())
				System.out.println("file is a symbolic link");
			else
				System.out.println("file is not a symbolic link");
			
			System.out.println("Files last modified: " + attribs.lastModifiedTime());
			System.out.println("file size: 	" + attribs.size()  + " bytes");
			
			} catch(IOException e) {
				System.out.println("Error reading attributes: " + e	);
		}

		
	}
	}

