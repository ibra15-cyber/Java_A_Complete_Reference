package jcr.chp22.java.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MappedChannedWrite {

	public static void main(String[] args) {
		
		try(FileChannel fchan = (FileChannel) Files.newByteChannel(Path.of("wri.txt"),
				StandardOpenOption.WRITE, 
				StandardOpenOption.READ, 
				StandardOpenOption.CREATE) ){
			
			//map the file into a buffer
			MappedByteBuffer mbuff = fchan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
			
			//write some bytes to the buffer
			for(int i =0; i<26; i++)
				mbuff.put((byte) ('A' + i));
		} catch (InvalidPathException e) {
			System.out.println("Path Error " + e);
		}catch (IOException e) {
			System.out.println("I/O Error " + e);
		}

	}

}
