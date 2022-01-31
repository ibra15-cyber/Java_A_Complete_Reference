package jcr.chp21.java.io;

import java.io.File;

public class FileDemo {
	
	static void p(String s) {
		System.out.println(s);
		}

	public static void main(String[] args) {
		
//		File(String directoryPath)
//		File(String directoryPath, String filename)
//		File(File dirObj, String filename)
//		File(URI uriObj)
		
		
		
		File f1 = new File("java/COPYRIGHT.txt"); //or ("java\\COPYRIGHT")
		p("File Name: " + f1.getName());
		p("Path: " + f1.getPath());
		p("Absolute: " + f1.getAbsolutePath());
		p("Parent: " + f1.getParent());
		p(f1.exists() ? "is exits": "does not exit");
		p(f1.canWrite() ? "is writeable" : "is not writeable");
		p(f1.canRead() ? "is readable" : "is not readable");
		p("is "+ (f1.isDirectory() ? " " : "not " + " a directory"));
		p(f1.isFile() ? "is normal file": "might be a named pipe");
		p(f1.isAbsolute() ? "is absolute" : "is not absolute");
		p("File last modified: " + f1.lastModified());
		p("File size: " + f1.length() + " Bytes");
		p("is hidden " +f1.isHidden());
		p("total space " +f1.getTotalSpace());
		p("get free space: " + f1.getFreeSpace());

		
		
		
		
		
		
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
