package jcr.chp21.java.io;

import java.io.File;
import java.io.FilenameFilter;

class OnlyExt implements FilenameFilter {
	String ext;
	
	public OnlyExt(String ext) {
		this.ext = " . " + ext;
	}

	public boolean accept(File dir, String name) {
		return name.endsWith(ext);
	}
}

public class DirectoryDemoReturnAParticularList {
	

	public static void main(String[] args) {
		
		String dirname = "C:\\Users\\dell\\Desktop\\dev\\java\\JavaCompleRef";
		File f1 = new File(dirname);
		FilenameFilter filter = new OnlyExt("txt");
		String s[] = f1.list(filter) ;
		
		for(int i = 0; i< s.length; i++)
			System.out.println(s[i]);
		
	}

}
