package jcr.chp21.java.io;

import java.io.File;

public class FileCreatingDirectory {

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\dell\\Desktop\\dev\\java\\JavaCompleRef");
		System.out.println(file.mkdirs());
		

	}

}
