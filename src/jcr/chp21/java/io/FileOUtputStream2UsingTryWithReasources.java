package jcr.chp21.java.io;


import java.io.FileOutputStream;
import java.io.IOException;

public class FileOUtputStream2UsingTryWithReasources {
//same as the code before
	public static void main(String[] args) {
		String source = "Now is the time for all good men\n"
				+ " to come to the aid of their country\n"
				+ " and pay their due taxes.	";
		//get the bytes of our string source 
		//but it in a buf array
		byte buf[] = source.getBytes();
		
		//create a file f0 f1 f2 using a FileOutputStream//actual creation of the files
		try(	FileOutputStream f0 = new FileOutputStream("file0.txt");
				FileOutputStream f1 =  new FileOutputStream("file1.txt");
				FileOutputStream f2 = new FileOutputStream("file2.txt")){
			//write to first file
			//transverse our array and increment by 2
			for(int i=0; i<buf.length; i+=2)
				//each time write to f0 the string at i thus 0, 2, 4, 6 etc
				f0.write(buf[i]);
			
			//write to second file
			//copy everything from our array and write to file 1
			f1.write(buf);
			
			//write to third file
			f2.write(buf, buf.length-buf.length/4, buf.length/4 );
			
		} catch(IOException e) {
			System.out.println("An I/O Erro Occured");
			//then finally execute this piece of code to close the files 
		}
		}
		

}

