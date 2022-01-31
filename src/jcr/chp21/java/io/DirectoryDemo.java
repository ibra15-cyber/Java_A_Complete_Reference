package jcr.chp21.java.io;

import java.io.File;

public class DirectoryDemo {

	public static void main(String[] args) {
		
		String dirname = "C:\\Users\\dell\\Desktop\\dev\\java\\JavaCompleRef"; ///storing the parent folder as a string
		File f1 = new File(dirname); //java is a parent folder hence a directory
		System.out.println(f1.getAbsoluteFile() );
		
		if(f1.isDirectory()) {
			System.out.println("Directory of " + dirname);
			String[] s = f1.list();

			for(int i = 0; i<s.length; i++) {
				File f = new File(dirname + "/" + s[i]); //take the file and the directory name
				if(f.isDirectory()) {
					System.out.println(s[i] + " is a directory");
				} else {
					System.out.println(s[i] + " is a file");
				}
			}
		} else {
			System.out.println(dirname + " is not a directory");
		}
	}

}
