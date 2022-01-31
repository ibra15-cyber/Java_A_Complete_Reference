package jcr.chp22.java.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;


public class ExplicitChannelRead {

	public static void main(String[] args) {
		
		int count;
		Path filepath = null;
		
		//first obtain a path to the file 
		try {
			filepath = Path.of("file2.txt");
		} catch(InvalidPathException e) {
			System.out.println("Path Error " +e );
			return;
		}
		
		//next, obtain a channel to that file within a try with resource block
		try(SeekableByteChannel fchan = Files.newByteChannel(filepath)){
			ByteBuffer mbuf = ByteBuffer.allocate(128);
			
			do {
				//read a buffer
				count = fchan.read(mbuf);
				
				//stop when end of file is reached
				if(count != -1) {
					mbuf.rewind();
					
					//read bytes from teh buffer and show
					//them on the screen as characters.
					for(int i = 0; i< count; i++)
						System.out.print((char) mbuf.get());
				}
			} while(count != -1);
			
			System.out.println();
		} catch(IOException e) {
			System.out.println("I/O Error: " +e);
		}
	}

}
