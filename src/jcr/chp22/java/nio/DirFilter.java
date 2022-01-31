package jcr.chp22.java.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class DirFilter {

	public static void main(String[] args) {
		
		String dirname = "examples";
		
		DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
			public boolean accept(Path filename) {
				if(Files.isWritable(filename))
						return true;
				return false;			
			}
		};
			
			try(DirectoryStream<Path> dirstrm = 
					Files.newDirectoryStream(Path.of(dirname), how)){
				System.out.println("Directory of " + dirname);
				
				for(Path entry: dirstrm) {
					BasicFileAttributes attribs = 
							Files.readAttributes(entry, BasicFileAttributes.class);
					
					if(attribs.isDirectory()	)
						System.out.println("<DIR> ");
					else
						System.out.println("             ");
					
					System.out.println(entry.getName(1));
				}
			}catch (InvalidPathException e) {
				System.out.println("Path Error " + e);
			}catch(NotDirectoryException e) {
				System.out.println(dirname + " is not a directory");
			}catch (IOException e) {
				System.out.println("I/OError " + e);
			} 

	}

}
