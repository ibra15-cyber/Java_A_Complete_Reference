package jcr.chp22.java.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path>{
	
	//method
	public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) {
		System.out.println(path);
		return FileVisitResult.CONTINUE;
	}
}

public class DisplayDirectoryUsingWalkFileTree {

	public static void main(String[] args) {
		
		String dirname = "examples";
		
		System.out.println("Directory tree starting with " + dirname + ":\n");
		
		try {
			Files.walkFileTree(Path.of(dirname), new MyFileVisitor());
		} catch(IOException e) {
			System.out.println("I/O Error");
		}
		
		

	}

}
